package com.pms.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    Connection conn =DBUtil.getDBConnection();

    public int addProduct(Product product){
        String insertQuery ="insert into product values(?,?,?,?)";
        int count = 0;
        try{
            PreparedStatement pstmt =conn.prepareStatement(insertQuery);

            pstmt.setInt(1,product.getPid());
            pstmt.setString(2,product.getPname());
            pstmt.setDouble(3,product.getPrice());
            pstmt.setDate(4,product.getDom());

            count = pstmt.executeUpdate();
        }catch(SQLException sqe){
            sqe.printStackTrace();
        }
        return count;
    }
    public int updateProduct(Product product){
        String updateQuery = "update product set pname =?"+", price =?, dom =? where pid =?";
        int count =0;
        try{
            PreparedStatement pstmt =conn.prepareStatement(updateQuery);

            pstmt.setString(1,product.getPname());
            pstmt.setDouble(2,product.getPrice());
            pstmt.setDate(3,product.getDom());
            pstmt.setInt(4,product.getPid());

            count =pstmt.executeUpdate();
        }catch(SQLException sqe){
            sqe.printStackTrace();
        }
        return count;
    }

    public Product getProductByNo(int pid){
        String selectQuery = "select * from product where pid =?";
        Product product = null;
        try{
            PreparedStatement pstmt =conn.prepareStatement(selectQuery);
            pstmt.setInt(1,pid);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                pid = rs.getInt("pid");
                String pname = rs.getString("pname");
                Double price = rs.getDouble("price");
                Date dom = rs.getDate("dom");
                product = new Product();
                product.setPid(pid);
                product.setPname(pname);
                product.setPrice(price);
                product.setDom(dom);
            }
        }catch(SQLException sqe){
            sqe.printStackTrace();
        }
        return product;
    }

    public int deleteProductByNo(int pid){
        String deleteQuery ="delete from product where pid =?";
        int count = 0;
        try{
            PreparedStatement pstmt =conn.prepareStatement(deleteQuery);
            pstmt.setInt(1,pid);
            count = pstmt.executeUpdate();
        }catch (SQLException sqe){
            sqe.printStackTrace();
        }
        return count;
    }

    public List<Product> getAll() {

        String selectAllQuery = "select * from product";

        List<Product> list = new ArrayList<Product>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(selectAllQuery);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                int pid = rs.getInt("pid");
                String pname = rs.getString("pname");
                double price = rs.getDouble("price");
                Date dom = rs.getDate("dom");

                Product product = new Product();
                list.add(product);

                product.setPid(pid);
                product.setPname(pname);
                product.setPrice(price);
                product.setDom(dom);

            }

        } catch (SQLException sqe) {
            // TODO Auto-generated catch block
            sqe.printStackTrace();
        }

        return list;
    }
}
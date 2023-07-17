package com.pms.pojo;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean flag =true;
        ProductDAO dao = new ProductDAO();
        while(flag) {
            System.out.println("Welcome to PMS");
            System.out.println("1.ADD Product");
            System.out.println("2.UPDATE Product");
            System.out.println("3.DELETE Product");
            System.out.println("4.SELECT Product");
            System.out.println("5.SELECT All");
            System.out.println("0.EXIT");


            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter product ID: ");
                    int pid1 = sc.nextInt();
                    System.out.println("Enter product name: ");
                    String pname1 = sc.next();
                    System.out.println("Enter product price");
                    double price1 = sc.nextDouble();
                    System.out.println("Enter date of manufacture: ");
                    String date1 = sc.next();
                    Date dom1  = Date.valueOf(date1);

                    Product product1 = new Product();
                    product1.setPid(pid1);
                    product1.setPname(pname1);
                    product1.setPrice(price1);
                    product1.setDom(dom1);
                    int count = dao.addProduct(product1);
                    System.out.println(count+" records inserted");
                    break;
                case 2:
                    System.out.println("Enter product ID");
                    int pid2 = sc.nextInt();
                    System.out.println("Enter product name");
                    String pname2 = sc.next();
                    System.out.println("Enter product price");
                    double price2 = sc.nextDouble();
                    System.out.println("Enter date of manufacture");
                    String date2 = sc.next();
                    Date dom2 = Date.valueOf(date2);

                    Product product2 = new Product();
                    product2.setPid(pid2);
                    product2.setPname(pname2);
                    product2.setPrice(price2);
                    product2.setDom(dom2);
                    int count1 = dao.updateProduct(product2);
                    System.out.println(count1+" records updated");

                    break;
                case 3:
                    System.out.println("Enter product ID to delete one product");
                    int pid3 = sc.nextInt();
                    int count3 = dao.deleteProductByNo(pid3);
                    System.out.println(count3+" records deleted");
                    break;
                case 4:
                    System.out.println("Enter product ID to select record");
                    int pid4 = sc.nextInt();
                    Product productObj = dao.getProductByNo(pid4);
                    System.out.println(productObj);
                    break;
                case 5:
                    List<Product> list = dao.getAll();
                    for(Product product :list){
                        System.out.println(product);
                    }
                    break;
                case 0:
                    flag = false;

                    break;
                default:
                    System.err.println("Invalid input..");
                    break;
            }
        }
    }

}
package Jdbc_Practice;

import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

         //1)Adım:Driver yükle

        Class.forName("org.postgresql.Driver");


        //2.Adım:database Bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Ss20112013Ss.");
        //3.Adım:Statemn olusturma
        Statement st=con.createStatement();

        //4.Adım:ResultSet oluşturma
        ResultSet result1=st.executeQuery("Select * from ogrenciler");

        //5.Adım:Sonuçları al

        while (result1.next()) {

            System.out.println(result1.getInt(1) + "==>" + result1.getString(2) + "==>" +
                    result1.getString(3) + "==>" + result1.getString(4));
        }
        //6.Adım:Kapat
         con.close();
         st.close();
         result1.close();



        }





    }


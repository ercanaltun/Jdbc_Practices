package Jdbc_Practice;

import java.sql.*;

public class Query2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Ss20112013Ss.");
        Statement st = con.createStatement();

        //Soru-1:Ögrenciler table daki Erkek öğrencileri listeleyiniz

        ResultSet result1=st.executeQuery("Select * from ogrenciler Where cinsiyet='E'");

        while (result1.next()) {

            System.out.println(result1.getInt(1) + "==>" + result1.getString(2) + "==>" +
                    result1.getString(3) + "==>" + result1.getString(4));
        }















    }
}

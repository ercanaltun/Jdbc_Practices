package Jdbc_Practice;

import java.sql.*;

public class Query2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "Ss20112013Ss.");
        Statement st = con.createStatement();

        //Soru-1:Ögrenciler table daki Erkek öğrencileri listeleyiniz

        ResultSet result1 = st.executeQuery("Select * from ogrenciler Where cinsiyet='E'");

        while (result1.next()) {

            System.out.println(result1.getInt(1) + "==>" + result1.getString(2) + "==>" +
                    result1.getString(3) + "==>" + result1.getString(4));


            ResultSet data = st.executeQuery("select * from ogrenciler where cinsiyet='E'");


            //SORU: Öğrenciler tablosundaki Erkek möğrencileri listeleyiniz?

            while (data.next()) {
                //System.out.println(data.getInt(1) + data.getString(2) +
                //        data.getInt(3) + data.getString(4));

                System.out.printf("%-6d %-15.15s %-8s %-8s\n", ((ResultSet) data).getInt(1), data.getString(2), data.getString(3), data.getString(4));

            }
            con.close();
            st.close();
            data.close();
        }
    }
}
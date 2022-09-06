package jdbc;

import java.sql.*;

public class Alistirmalar03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1Adım: Driver a kaydol
        Class.forName("org.postgresql.Driver");

        //2.Adım:database bağlan
        Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Ss20112013Ss.");

        //3.Adım:Statement oluştur
        Statement st=con.createStatement();

        //4.Adım Query çalıştır

      //  String str="Create table cars(car_id int,name varchar(20),model varchar(20),year int)";
       // ResultSet result1 =st.executeQuery(str);

        //Soru-1:Cars table nı tüm değerleriyle çağır
        String sql="Select * from cars";
        ResultSet result2 = st.executeQuery(sql);
        while (result2.next()){

            System.out.println(result2.getString("car_id") + " " + result2.getString("name") + " " +
                    result2.getString("model") + " " + result2.getString("year"));

        }












    }
}

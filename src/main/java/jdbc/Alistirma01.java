package jdbc;

import java.sql.*;



public class Alistirma01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.Adım:Driver a kaydol
        Class.forName("org.postgresql.Driver");

        //2.Adım:Database bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Ss20112013Ss.");

        //3:Adım:Statment oluştur
        Statement st = con.createStatement();

        //4.Adım:Query çağır
        String sql = "Create table family(name varchar(30),status varchar(10),age int)";
         st.execute(sql);


        //5:Adım:Bağlantı ve Statement'ı kapat
      //  con.close();
       // st.close();


    }
}

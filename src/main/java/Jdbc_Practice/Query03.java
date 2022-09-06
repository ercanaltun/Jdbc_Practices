package Jdbc_Practice;

import java.sql.*;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "Ss20112013Ss.");
        Statement st = con.createStatement();



        PreparedStatement ps= con.prepareStatement("select * from ogrenciler");
        ResultSet rs=ps.executeQuery();

        ResultSetMetaData rsmd=rs.getMetaData();

        System.out.println("Sutun Sayısı : "+rsmd.getColumnCount());

        System.out.println();

        System.out.println("1.Sutun ismi : "+rsmd.getColumnName(1));
        System.out.println("2.Sutun ismi : "+rsmd.getColumnName(2));
        System.out.println("3.Sutun ismi : "+rsmd.getColumnName(3));
        System.out.println("4.Sutun ismi : "+rsmd.getColumnName(4));

        System.out.println();

        System.out.println("Tablo Ismi : "+rsmd.getTableName(2));








    }
}

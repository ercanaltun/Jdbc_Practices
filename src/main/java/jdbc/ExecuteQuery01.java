package jdbc;

import java.sql.*;

public class ExecuteQuery01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Ss20112013Ss.");
        Statement st = con.createStatement();

        //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan
        // company ve number_of_employees değerlerini çağırın.
        //1.yol:
        String sql1="Select company, number_of_employees\n" +
                "From companies\n" +
                "order by number_of_employees\n" +
                "desc limit 1 offset 1";

        ResultSet result1=st.executeQuery(sql1);
       /*
       1.Yol:
        while (result1.next()){

            System.out.println(result1.getString("company")
                    + " ==> " + result1.getInt("number_of_employees"));
        }
        */
        //2:Yol:

        System.out.println();

        while (result1.next()){

            System.out.println(result1.getString(1) //index'i biliyorsak index ile de çağırabiliriz
                    + " ==> " + result1.getInt(2));
        }
        con.close();
        st.close();
        result1.close();





















    }
}

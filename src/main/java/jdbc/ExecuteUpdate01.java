package jdbc;

import java.sql.*;

public class ExecuteUpdate01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Ss20112013Ss.");
        Statement st = con.createStatement();

        //1. Örnek: number_of_employees değeri ortalama çalışan sayısından az olan
        // number_of_employees değerlerini 16000 olarak UPDATE edin.
        String sql1 = "Update companies\n" +
                "Set  number_of_employees = 16000\n" +
                "Where  number_of_employees<\n" +
                "(Select avg( number_of_employees)\n" +
                "From companies)";
        int updateSatirsayisi = st.executeUpdate(sql1);//Update edilen satır sayısını return eder
        System.out.println("updateSatirsayisi = " + updateSatirsayisi);

        String sql2 = "Select * from companies";

        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()) {

            System.out.println(result1.getInt(1) + "-- "
                    + result1.getString(2)
                    + "--" + result1.getInt(3));
        }

        con.close();
        st.close();
        result1.close();

    }
}

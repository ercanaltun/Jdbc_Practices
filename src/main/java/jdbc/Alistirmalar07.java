package jdbc;

import java.sql.*;

public class Alistirmalar07 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Alistirmalar", "postgres", "Ss20112013Ss.");
        Statement st = con.createStatement();

        //Soru-1:id si 5001 den buyuk olanların hdd sini 400 olarak güncelleyin
        //bunların tüm değerlerini çağırın

        String sql1 = "Update pc Set hdd=? Where id>?";

        PreparedStatement pst1 = con.prepareStatement(sql1);

        pst1.setString(1, "400gb ssd");
        pst1.setInt(2, 500);

        int updateSatirlar = pst1.executeUpdate();
        System.out.println("updateSatirlar = " + updateSatirlar);
        System.out.println();

        String sql2 = "Select * from pc where id>500";
        ResultSet result1 = st.executeQuery(sql2);
        while (result1.next()) {
            System.out.println(result1.getInt(1) + "==>" + result1.getString(2) + "==>" + result1.getString(3)
                    + "==>" + result1.getString(4) + "==>" + result1.getInt(5));
        }
        System.out.println();
        //Soru-2: a veya h ile başlayan markaların ram'ini 16gb olarak güncelleyin
        // ve bunlara ait tüm değerleri çağırın

        String sql3 = "Update pc Set ram=? Where marka ~* ?";

        PreparedStatement pst2 = con.prepareStatement(sql3);

        pst2.setString(1, "20gb");
        pst2.setString(2, "^[ah](.*)");
                           pst2.executeUpdate();

        String sql4 = "Select * from pc Where marka ~* '^[ah](.*)'";
        ResultSet result2 = st.executeQuery(sql4);

        while (result2.next()) {

            System.out.println(result2.getInt(1) + "==>" + result2.getString(2) + "==>" +
                    result2.getString(3) + "==>" + result2.getString(4) + "==>" +
                    result2.getInt(5));
        }


    }
}

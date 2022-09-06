package jdbc;

import java.sql.*;

public class Alistirmalar05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Alistirmalar", "postgres", "Ss20112013Ss.");
        Statement st = con.createStatement();


            //1. Örnek: fiyatı ortalamadan az olan
            // fiyatların değerlerini 24000 olarak UPDATE edin.
            String sql3 = "Update pc Set fiyat =24000 where fiyat< (Select avg(fiyat) From pc)";
            int degisenSatirSayisiFiyat = st.executeUpdate(sql3);
        System.out.println("degisenSatirSayisiFiyat = " + degisenSatirSayisiFiyat);

        System.out.println();

        String sql2 = "Select * from pc";
        ResultSet result2 = st.executeQuery(sql2);

        while (result2.next()) {

            System.out.println(result2.getInt(1) + "--" + result2.getString(2) + "--" +
                    result2.getString(3) + "--" + result2.getString(4) + "--" +
                    result2.getInt(5));
        }
        System.out.println();

        //Soru-2:Ram'i 8gb olanları 16 gb olarak updete edelim
        String sql1="Update pc Set ram='16gb' where ram='8gb'";
        int degisenSatirSayisiRam =st.executeUpdate(sql1);
        System.out.println("degisenSatirSayisiRam = " + degisenSatirSayisiRam);

        System.out.println();

        String sql4="select * from pc";
        ResultSet result1 = st.executeQuery(sql4);

        while (result1.next()){

            System.out.println(result1.getInt(1) + "--" + result1.getString(2) + "--" +
                    result1.getString(3) + "--" + result1.getString(4) + "--" +
                    result1.getInt(5));
        }

        con.close();
        st.close();
        result1.close();
        result2.close();


    }
    }

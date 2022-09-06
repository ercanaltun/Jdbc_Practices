package jdbc;

import java.sql.*;

public class Alistirmalar04 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Alistirmalar", "postgres", "Ss20112013Ss.");
        Statement st = con.createStatement();

        String sql1 ="Create table pc(id int,marka varchar(20),hdd varchar(20),ram varchar(20),fiyat int)";

        String sql2="Select * from pc";
        ResultSet result2=st.executeQuery(sql2);

        while (result2.next()){

            System.out.println(result2.getInt(1) + "--" + result2.getString(2) + "--" +
                    result2.getString(3) + "--" +result2.getString(4) + "--" +
                    result2.getInt(5));
        }
        System.out.println();

        //Soru-1:Fiyatı En yüksek 3. pc nin değerlerini getirin
        String sql3="Select * from pc order by fiyat desc limit 1 offset 2";
         ResultSet result1= st.executeQuery(sql3);

         while (result1.next()){

             System.out.println(result1.getInt(1) + "--" + result1.getString(2) + "--" +
                     result1.getString(3) + "--" +result1.getString(4) + "--" +
                     result1.getInt(5));
         }
        System.out.println();

          //Soru-2:ram=16gb olan markaları ve fiyatlarını çağır
        String sql4="Select marka,fiyat from pc Where ram='8gb'";
         ResultSet result3=st.executeQuery(sql4);

        while (result3.next()){

            System.out.println(result3.getString("marka") + "--" + result3.getInt("fiyat"));
        }

        System.out.println();

        //Soru-3:Baş harfi A veya C olan markaların değerlerini getir
        String sql5="Select * from pc where marka ~* '^[ac](.*)'";
        ResultSet result4=st.executeQuery(sql5);

        while (result4.next()){

            System.out.println(result4.getInt(1) + "--" + result4.getString(2) + "--" +
                    result4.getString(3) + "--" +result4.getString(4) + "--" +
                    result4.getInt(5));
        }
        con.close();
        st.close();
        result1.close();
        result2.close();
        result3.close();
        result4.close();



    }
}

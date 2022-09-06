package jdbc;

import java.sql.*;

public class Alistirmalar08 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Ss20112013Ss.");
        Statement st = con.createStatement();

        String sql1 = "Select * from mobile";
        ResultSet result1 = st.executeQuery(sql1);

        while (result1.next()) {

            System.out.println(result1.getInt(1) + "==>" + result1.getString(2) + "==>" +
                    result1.getString(3) + "==>" + result1.getInt(4));
        }
        System.out.println();


        //Soru-1:Mobile table'da id'si 1001,1003 olanların price'nı 9000 olarak güncelleyin
        String sql3 = "Update mobile set price=9000 where id in(1001,1003)";
        int updateedilenSatirSayisi = st.executeUpdate(sql3);
        System.out.println("updateedilenSatirSayisi = " + updateedilenSatirSayisi);

        System.out.println();

        String sql4 = "Select * from mobile where id in(1001,1003)";
        ResultSet result2 = st.executeQuery(sql4);
        while (result2.next()) {

            System.out.println(result2.getInt(1) + "==>" + result2.getString(2) + "==>" +
                    result2.getString(3) + "==>" + result2.getInt(4));
        }
        System.out.println();

        //Soru-2:Mobile table'a made_in adında bir field(column) ekledikten sonra
        //   1001 ve 1003'e S.Korea, 1002'ye ise USA ekleyerek update edin
        //1.Adım:
        String sql5 = "Alter table mobile add made_in varchar(20)";
        st.executeUpdate(sql5);

        //2.Adım:
        String sql6 = "Update mobile set made_in='S.Korea' Where id in(1001,1003)";
        st.executeUpdate(sql6);

        //3.Adım:
        String sql7 = "Update mobile set made_in='USA' Where id=1002";
        st.executeUpdate(sql7);

        String sql8 = "select * from mobile";
        ResultSet result3 = st.executeQuery(sql8);

        while (result3.next()) {

            System.out.println(result3.getInt(1) + "==>" + result3.getString(2) + "==>"
                    + result3.getString(3) + "==>" +
                    result3.getInt(4) + "==>" + result3.getString(5));
        }

        con.close();
        st.close();
        result1.close();
        result2.close();
        result3.close();


    }
}

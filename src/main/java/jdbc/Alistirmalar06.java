package jdbc;

import java.sql.*;

public class Alistirmalar06 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Alistirmalar", "postgres", "Ss20112013Ss.");
        Statement st = con.createStatement();

        String sql2 = "Select * from pc";
        ResultSet result2 = st.executeQuery(sql2);

        while (result2.next()) {

            System.out.println(result2.getInt(1) + "--" + result2.getString(2) + "--" +
                    result2.getString(3) + "--" + result2.getString(4) + "--" +
                    result2.getInt(5));
        }
        System.out.println();

        //Soru-1: PreparedStatment kullanarak markası Asus olanın fiyatını 23000 olarak güncelleyin
        //1:Adım: Prepared statement query'sini oluştur
        String sql1 = "Update pc set fiyat=? where marka=?";

        //2.Adım:Prepared statement objesini oluştur.
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //3.Adım:set...() methodları ile ? işaretleri için değer gir
        pst1.setInt(1, 40000);
        pst1.setString(2, "Dell");

        //4.Adım:Execute Query yap.
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println("updateRowSayisi = " + updateRowSayisi);

        System.out.println();

        String sql3 = "Select * from pc";
        ResultSet result1 = st.executeQuery(sql3);

        while (result1.next()) {

            System.out.println(result1.getInt(1) + "--" + result1.getString(2) + "--" +
                    result1.getString(3) + "--" + result1.getString(4) + "--" +
                    result1.getInt(5));
        }

        //Soru-2: PreparedStatment kullanarak fiyatı 20000 den büyük olan
        // markaların ram ini 16gb  olarak güncelleyin

        //1:Adım: Prepared statement query'sini oluştur
        String sql4 = "Update pc set ram=? where fiyat>?";

        //2.Adım:Prepared statement objesini oluştur.
        PreparedStatement pst2 = con.prepareStatement(sql4);

        //3.Adım:set...() methodları ile ? işaretleri için değer gir
        pst2.setString(1, "16gb");
        pst2.setInt(2, 20000);

        //4.Adım:Execute Query yap.
        int updatesatirSayisi = pst2.executeUpdate();
        System.out.println("updatesatirSayisi = " + updatesatirSayisi);


        System.out.println();

        String sql5 = "Select * from pc";
        ResultSet result3 = st.executeQuery(sql5);

        while (result3.next()) {

            System.out.println(result3.getInt(1) + "--" + result3.getString(2) + "--" +
                    result3.getString(3) + "--" + result3.getString(4) + "--" +
                    result3.getInt(5));
        }
        System.out.println();

        //Soru3:Markası HP olannın fiyatını 20000 olarak güncelleyip
        //HP ye ait tüm bilgileri çağırın
          String str="Select * from pc Where marka='HP'";
        ResultSet reso =st.executeQuery(str);
        while (reso.next()){
            System.out.println(reso.getInt(1) + "==>" + reso.getString(2) + "==>" + reso.getString(3) + "==>" +
                    reso.getString(4) + "==>" + reso.getInt(5));
        }
        con.close();
        st.close();
        result1.close();
        result2.close();
        result3.close();
        reso.close();



    }


}

package jdbc;

import java.sql.*;

public class Alistirmalar09 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Ss20112013Ss.");
        Statement st = con.createStatement();
     //Soru-1:Foundation_date'i 1905 'den buyuk olnaların champions 'larını
     //20 olarak update eden Prepared Statement oluşturun

        String sql1 = "Update teams set champions=? Where foundation_date=?";
        PreparedStatement ps1=con.prepareStatement(sql1);

        ps1.setInt(1,25);
        ps1.setInt(2,1905);

         int degisenSatirSayisi=ps1.executeUpdate();

        System.out.println("degisenSatirSayisi = " + degisenSatirSayisi);
        System.out.println("**************************");



        String sql2="Select * from teams Order by foundation_date ";
        ResultSet result1=st.executeQuery(sql2);

        while (result1.next()){

            System.out.println(result1.getInt(1) + "==>" + result1.getString(2) + "==>" +
                    result1.getString(3) + "==>" + result1.getInt(4));
        }


        System.out.println("******************************");
         //Soru-2:colour Yellow and Red olanının champions unu 5 artıran Prepared Statement oluştur

         String sql3="Update teams set champions=? Where colours=?";
        PreparedStatement ps2=con.prepareStatement(sql3);
        ps2.setInt(1,25);
        ps2.setString(2,"Yellow and Red");
                ps2.executeUpdate();

        String sql4="Select * from teams Order by champions desc";
        ResultSet result2=st.executeQuery(sql4);

        while (result2.next()){

            System.out.println(result2.getInt(1) + "==>" + result2.getString(2) + "==>" +
                    result2.getString(3) + "==>" + result2.getInt(4));
        }




























    }



}

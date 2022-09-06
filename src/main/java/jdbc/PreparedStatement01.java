package jdbc;

import java.sql.*;

public class PreparedStatement01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Ss20112013Ss.");
        Statement st = con.createStatement();

        //1. Örnek: Prepared statement kullanarak company adı IBM olan
        // number_of_employees değerini 9999 olarak güncelleyin.

        //1:Adım: Prepared statement query'sini oluştur
        String sql1="Update companies\n" +
                "Set number_of_employees = ?\n" +
                "where company = ? ";

        //2.Adım:Prepared statement objesini oluştur.
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //3.Adım:set...() methodları ile ? işaretleri için değer gir
        pst1.setInt(1,9999);
        pst1.setString(2,"IBM");

        //4.Adım:Execute Query yap.
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println(updateRowSayisi+" satır güncellendi.");

        String sql2 =" Select * From companies";
        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()){

            System.out.println(result1.getInt(1) + "--"
                    + result1.getString(2) + "--" +
                    result1.getInt(3));
        }
        System.out.println("***************************");
        read_data(con,"companies");

    //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.
        String sql4 = "SELECT * FROM <?>";
    }
       // Bir tablonun istenilen datasını Prepared Satement ile çağırtmak için kullanılan method
    public static void read_data(Connection con,String tableName){

        try {

            String query =String.format("SELECT * FROM %s",tableName) ;//Format() methodu dinamik String oluşturmak içindir
                         Statement statement =con.createStatement();
                         ResultSet rs =statement.executeQuery(query);

                         while (rs.next()){

                             System.out.println(rs.getInt(1) + "--"
                                     + rs.getString(2) + "--" +
                                     rs.getInt(3));
                         }

        }catch (Exception e){
            System.out.println(e);
        }









    }



















}

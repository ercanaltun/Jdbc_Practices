package jdbc;

import java.sql.*;

public class Alistirmalar02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.Adım:Driver a kaydol
        Class.forName("org.postgresql.Driver");

        //2.Adım:Database bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Ss20112013Ss.");

        //3:Adım:Statment oluştur
        Statement st =con.createStatement();

        //Question 1: family table 'daki name leri age'e göre sıralayınız
        String sql2="Select name from family order by age";
        ResultSet result1=st.executeQuery(sql2);

        while (result1.next()){

            System.out.println(result1.getString("name"));
        }
        System.out.println();

       //Question 2:family table daki kübra ismini amine kubra olarak değiştirerek
       // ona ait tum bilgileri çağır

        String sql3="Update family  set name='Amine Kubra' where name='Kübra' ";
        st.execute(sql3);
        String sql4="Select * from family where name='Amine Kubra'";
        st.executeQuery(sql4);
        ResultSet result2=  st.executeQuery(sql4);

        while (result2.next()){

            System.out.println(result2.getString("name")
                    + " " + result2.getString("status") + " "
                    + result2.getInt("age"));
        }
        System.out.println();

        //Question 3:family table 'a job record ekleyin ve
        // family table'ını age göre büyükten küçüğe sıaralayınız
          String sql5="Alter table family add job varchar(20)";
          st.execute(sql5);
          String sql6="Select * from family order by age desc";
          st.executeQuery(sql6);
          ResultSet result3=st.executeQuery(sql6);

          while (result3.next()){

              System.out.println(result3.getString("name") + " " + result3.getString("status")
                      + " " + result3.getInt("age") + " " + result3.getString("job"));
          }
        System.out.println();

         String job1="Update family set job='QA' Where name='Ercan'";
          st.execute(job1);
        String job2="Update family set job='English Teacher' Where name='Amine Kubra'";
        st.execute(job2);
        String job3="Update family set job='Student' Where name='Salih'";
        st.execute(job3);
        String job4="Update family set job='Student' Where name='Selim'";
        st.execute(job4);

        String sql7="Select * from family order by age desc";
        ResultSet result4=st.executeQuery(sql7);

        while (result4.next()){

            System.out.println(result4.getString("name") + " " + result4.getString("status")
                    + " " + result4.getInt("age") + " " + result4.getString("job"));
        }







    }
}

package jdbc;

import java.sql.*;

public class CallableStatement01 {

    /*
    Java'da methodlar return  sahibi olsa da void olsa da
     methd olarak adlandırılır
    Sql de ise data return ediyorsa "function" denir.return yapmıyorsa
    buna "prodecure" diye adlandırılır
     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Ss20112013Ss.");
        Statement st = con.createStatement();

         //1. Örnek: İki parametre ile çalışıp bu
        // parametreleri toplayarak return yapan bir fonksiyon oluşturun.

        //1.Adım : Fonksiyon kodunu yaz.
            String sql1="Create Or Replace Function toplamaF(x Numeric, y Numeric)\n" +
                "Returns Numeric\n" +
                "Language plpgsql\n" +
                "As\n" +
                "$$\n" +
                "Begin\n" +
                "\n" +
                "\n" +
                "Return x+y;\n" +
                "\n" +
                "\n" +
                "\n" +
                "End\n" +
                "$$";

        //2.Adım:Fonksiyonu çalıştır.
            st.execute(sql1);

        //3.Adım:Fonksiyonu çağır.
            CallableStatement cst1 =con.prepareCall("{?=call toplamaF(?,?)}");

        //4.Adım:Return için registerOutParameter () methodunu,
        //parametreler için set() methodlarından uygun olanları kullan
        cst1.registerOutParameter(1,Types.NUMERIC);
        cst1.setInt(2,15);
        cst1.setInt(3,25);


        //5.Adım :Çalıştırmak için execute() methodunu kullanmalıyız
        cst1.execute();

        //6.Adım:Sonucu çağırmak için return data tipine göre "get" methodlarından uygun olanları kullan
        System.out.println(cst1.getBigDecimal(1));



        //2. Örnek: Koninin hacmini hesaplayan bir function yazın.
        String sql2="Create Or Replace Function koniHacmi(r Numeric, h Numeric)\n" +
                "Returns Numeric\n" +
                "Language plpgsql\n" +
                "As\n" +
                "$$\n" +
                "Begin\n" +
                "\n" +
                "\n" +
                "Return 3.14*r*r*h/3;\n" +
                "\n" +
                "\n" +
                "\n" +
                "End\n" +
                "$$";

        //2.Adım:Fonksiyonu çalıştır.
        st.execute(sql2);

        //3.Adım:Fonksiyonu çağır.
        CallableStatement cst2 =con.prepareCall("{?=call koniHacmi(?,?)}");

        //4.Adım:Return için registerOutParameter () methodunu,
        //parametreler için set() methodlarından uygun olanları kullan
        cst2.registerOutParameter(1,Types.NUMERIC);
        cst2.setInt(2,3);
        cst2.setInt(3,5);


        //5.Adım :Çalıştırmak için execute() methodunu kullanmalıyız
        cst2.execute();

        //6.Adım:Sonucu çağırmak için return data tipine göre "get" methodlarından uygun olanları kullan
        System.out.println(cst2.getBigDecimal(1));

    }


}

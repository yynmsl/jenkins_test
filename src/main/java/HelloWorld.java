import java.sql.*;

public class HelloWorld {


    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        Connection conn = null;
        String sql;

        String conn_str = "jdbc:mysql://172.17.0.1:3306/config?"
                + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            System.out.println("成功加载MySQL驱动程序");

            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(conn_str);
            Statement stmt = conn.createStatement();
            sql = "show tables ;";
            ResultSet result = stmt.executeQuery(sql);
            if (result != null) {
                while (result.next()) {
                    System.out.println(result.getString(1) + "\t");
                }
            }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }


    }

}



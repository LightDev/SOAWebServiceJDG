package rsi_jdg_ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class DataConnection {

    public DataConnection(String scheme, String db) {
        System.out.println("Connecting...");
        this.scheme = scheme;
        this.connect(db);
    }

    private Connection connect(String db) {
        String url = "jdbc:derby://localhost:1527/";
        String dbName = db;
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String userName = "nlight";
        String password = "a";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database");
            //conn.setSchema("NLIGHT");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    private Connection connect2() {
        String url = "jdbc:derby://localhost:1527/";
        String dbName = "osoba";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String userName = "nlight";
        String password = "a";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database");
            //conn.setSchema("NLIGHT");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public JDG[] select(String tableName) {
        java.sql.ResultSet rs = null;
//        ArrayList<JDG> list = new ArrayList<JDG>();
        JDG list[] = null;
        //        String list = "";
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT count(*) FROM " + scheme + "." + tableName + "");
//            rs = st.executeQuery("SELECT count(*) FROM " + scheme + ".\"" + tableName + "\"");
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            System.out.println("COUNT(*)=" + count);
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM " + scheme + "." + tableName + "");
//            rs = st.executeQuery("SELECT * FROM " + scheme + ".\"" + tableName + "\"");
            int i = 0;

            list = new JDG[count];
            while (rs.next()) {
                list[i] = new JDG(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        (rs.getString(9).equals("T")) ? true : false);
                i++;
            }
            System.out.println("Rows selected");
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
//    public String select(String tableName) {
//        java.sql.ResultSet rs = null;
//        String list = "";
//        try {
//            st = conn.createStatement();
//            rs = st.executeQuery("SELECT * FROM " + scheme + ".\"" + tableName + "\"");
//            while (rs.next()) {
//                list += rs.getInt(1) + ": "
//                        + rs.getString(2) + ": "
//                        + rs.getString(3) + "<br />";
//            }
//            System.out.println("Rows selected");
//        } catch (SQLException ex) {
//            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }

    public void insert(String tableName, String values) {
        try {
            st = conn.createStatement();
            st.executeUpdate("INSERT INTO " + scheme + "." + tableName + " VALUES((select count(1)+1 from " + scheme + "." + tableName + ")," + values + ")");
//            st.executeUpdate("INSERT INTO " + scheme + ".\"" + tableName + "\" VALUES((select count(1)+1 from " + scheme + ".\"" + tableName + "\")," + values + ")");
            System.out.println("Row inserted");



        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Connection conn, Statement st, String setOfValues) {
        try {
            st = conn.createStatement();
            st.executeUpdate("UPDATE " + scheme + ".\"jdg_users\" SET " + setOfValues + "");
            System.out.println("Row updated");



        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Connection conn, Statement st, String tableName, String values) {
        try {
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM " + scheme + ".\"" + tableName + "\" WHERE " + values + "");
            System.out.println("Row deleted");


        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            conn.close();
            System.out.println("Disconnected from database");


        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public void close(Connection conn) {
//        try {
//            conn.close();
//            System.out.println("Disconnected from database");
//        } catch (SQLException ex) {
//            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private Connection conn = null;
    private Statement st = null;
    private String scheme;
}

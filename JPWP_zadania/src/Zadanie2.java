import java.sql.*;
import java.util.ArrayList;



public class Zadanie2 {

    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(
                    "jdbc:mysql://remotemysql.com:3306/L4d12xkX63",
                    "L4d12xkX63",
                    "gIfVrkZMNy");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static Connection getConnection(){
        return conn;
    }

    //Zwraca imię o danym id z bazy
    public  static String getName(int id) throws SQLException {
        String  name = null;
        String query = "SELECT name FROM tabela10 WHERE id = " + String.valueOf(id);
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                return rs.getString("name");
            }
            stmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
    // Umożliwia dodanie całego rekordu do tabeli.
    public static void addRecord(String name, String surname, String age) throws SQLException{
        String query = "INSERT INTO tabela10 VALUES (\"" + name + "\", \"" + surname + "\" , \"" + age + "\")";
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);

    }
    // Umożliwia usunięcie całego rekordu o danym id z tabeli.
    public static void deleteRecord(int id) throws SQLException{
        String query = "DELETE FROM tabela10 WHERE id=" + id;
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);

    }
    // Umożliwia edycje całego rekordu o podanym id w tabeli.
    public static void editRecord(int id, String newName, String newSurname, String newAge) throws SQLException{
        String query = "UPDATE tabela10 SET name=\""+newName+"\", surname=\""+newSurname+"\", age=\""+newAge+"\" WHERE id =" + id;
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);

    }
    // Zwraca prawdę, gdy podane imię wystepuje w tabeli
    public static boolean isThisSameName(String name) throws SQLException{
        String query = "SELECT name FROM tabela10 WHERE name =" + name;
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) return true;
         else return false;
    }

    // Zwraca Arraylistę wszytskich imion w tabeli
    public static ArrayList<String> getNames() throws SQLException {
        ArrayList<String> names = new ArrayList<>();
        Connection conn = getConnection();
        String query = "SELECT name FROM tabela10";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            names.add(rs.getString("name"));
        } return names;
    }

    public static void main(String[] args) throws SQLException {
        String query = "SELECT name FROM tabela10 WHERE id = 2";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                System.out.println(rs.getString("name"));
            }
            stmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
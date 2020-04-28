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
    public  static String getName(int id){
        String  name = null;
        Connection conn = getConnection();

        return name;
    }
    // Umożliwia dodanie całego rekordu do tabeli.
    public static void addRecord(String name, String surname, String age){
        Connection conn = getConnection();

    }
    // Umożliwia usunięcie całego rekordu o danym id z tabeli.
    public static void deleteRecord(int id){
        Connection conn = getConnection();

    }
    // Umożliwia edycje całego rekordu o podanym id w tabeli.
    public static void editRecord(int id, String newName, String newSurname, String newAge){
        Connection conn = getConnection();

    }
    // Zwraca prawdę, gdy podane imię wystepuje w tabeli
    public static boolean isThisSameName(String name){

        return false;
    }

    // Zwraca Arraylistę wszytskich imion w tabeli
    public static ArrayList<String> getNames(){
        Connection conn = getConnection();
        ArrayList<String> names = new ArrayList<>();

        return names;
    }


    public static void main(String[] args) {
        String query = "SELECT name FROM tabela* WHERE id = 2";
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

package GalamseyProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**Class allows for objects to be added to the database
 * 
 *  @version 1.0.0
 */
public class Database {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/galamsey?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection ( ) throws SQLException, ClassNotFoundException {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/galamsey?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            return con;
    }


    //Add parameters for the input for observation
    /**Adds observatory to database
     * 
     * @param name
     * @param country
     * @param year
     * @param area
     * @throws SQLException 
     */
    public void addObservatory(String name, String country, Integer year, Double area) throws SQLException {

        preparedStatement = connection.prepareStatement("insert into observatory values " +
                "('"+name+"','"+country+"',"+year+","+area+")");
        preparedStatement.executeUpdate();
        
        System.out.println("Inserted into Observatory succesfully");

    }





    /**Adds galamsey vegetation data to database
     * 
     * @param vegcolor
     * @param colvalue
     * @param position
     * @param yearofevent
     * @throws SQLException 
     */
    public void addGalamsey( String vegcolor, int colvalue,String position, int yearofevent, String obs) throws SQLException {
        preparedStatement = connection.prepareStatement("insert into galamsey_tbl (Vegcolor,colorVal,position,yearOfEvent,ObsName) values" +
                "('"+vegcolor+"','"+colvalue+"','"+position+"',"+yearofevent+",'" + obs + "')");
        preparedStatement.executeUpdate();
        System.out.println("Inserted into Galamsey Successfully");

    }




}

package dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

public final class DBManager {
    private static DBManager dbManager;
    private Connection connection;

    private DBManager(){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insti", "root","");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static synchronized DBManager getInstance(){
        if(dbManager==null){
           dbManager=new DBManager();
        }
        return dbManager;
    }
    protected Object clone()throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
    public void ajouterPersonne(Personne personne) throws SQLException {
        PreparedStatement preparedStatement=null;
       try {
           preparedStatement=connection.prepareStatement("INSERT INTO personnes VALUES(null, ?, ?, ?, ?, ?)");
           preparedStatement.setString(1,personne.getNom());
           preparedStatement.setString(2,personne.getPrenoms());
           preparedStatement.setString(3,personne.getAdresse());
           preparedStatement.setString(4,personne.getTel());
           preparedStatement.setInt(5,personne.getAge());
           preparedStatement.addBatch();
           preparedStatement.executeUpdate();
           preparedStatement.close();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
    public List<Personne> getPersonnes() {
        List<Personne> personnes = new ArrayList<>();
        try {
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM personnes");
            while (resultSet.next()) {
                Personne personne = new Personne();
                // TODO: 28/03/2023
                personne.setId(resultSet.getInt("id"));
                personne.setNom(resultSet.getString("nom"));
                personne.setPrenoms(resultSet.getString("prenoms"));
                personne.setAdresse(resultSet.getString("adresse"));
                personne.setTel(resultSet.getString("telephone"));
                personne.setAge(resultSet.getInt("age"));
                personnes.add(personne);
            }
//            resultSet.close();
//            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personnes;
    }
    public void close(){
        if(connection!=null){
            try{
                connection.close();
                dbManager=null;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

}

/*
* Dans cette classe Java, nous voulons initialiser l'utilisation de la base de donnée locale de l'utilisateur en
* connectant à PostgreSQL et saisissant le nom de la base de donnée ainsi que le mot de passe de celle ci.
* */

package classes;

public class Credentials {
    /*
    * MAKE SURE TO CHANGE THE FOLLOWING VALUE WITH YOUR OWN DATABASES SETUP
    * */
    public static final String DATABASE_URL = "jdbc:postgresql://localhost/todo_list";
    public static final String DATABASE_USER = "postgres";
    public static final String DATABASE_PASSWORD = "MotDePasse";
}

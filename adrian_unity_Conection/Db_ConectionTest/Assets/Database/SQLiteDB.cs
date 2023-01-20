using UnityEngine;
using System.Data;
using Unity.VisualScripting.Dependencies.Sqlite;
using Mono.Data.Sqlite;
using System.IO;
//using Microsoft.Data.Sqlite;



public class SQLiteDB : MonoBehaviour
{
    public static SQLiteDB instance;
    private string dbName = "URI=file:DataBase.db";
    private void Awake()
    {
        instance = this;
    }
    void Start()
    {

        // Create database
        string connection = "URI=file:" + Application.persistentDataPath + "/" + "Database";

        // Open connection
        IDbConnection dbcon = new SqliteConnection(connection);
        dbcon.Open();

        // Create table
        IDbCommand dbcmd;
        dbcmd = dbcon.CreateCommand();
        string q_createTable = "CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY, name VARCAHR(50), password VARCAHR(50) )";

        dbcmd.CommandText = q_createTable;
        dbcmd.ExecuteReader();

        // Insert values in table
        IDbCommand cmnd = dbcon.CreateCommand();
        cmnd.CommandText = "INSERT INTO user (id, name, password) VALUES (0, 'test', 'pwd')";
        cmnd.ExecuteNonQuery();

        // Read and print all values in table
        IDbCommand cmnd_read = dbcon.CreateCommand();
        IDataReader reader;
        string query = "SELECT * FROM user";
        cmnd_read.CommandText = query;
        reader = cmnd_read.ExecuteReader();

        while (reader.Read())
        {
            Debug.Log("id: " + reader[0].ToString());
            Debug.Log("name: " + reader[1].ToString());
            Debug.Log("password: " + reader[2].ToString());
        }

        // Close connection
        dbcon.Close();


        //CreateTable();
        //Query("INSERT INTO user (name, password) VALUES ('Jonny', '123456');");
        //Query("SELECT * FROM user;");
    }

    private void CreateTable()
    {
        using (var connection = new SqliteConnection(dbName))
        {
            connection.Open();

            using (var command = connection.CreateCommand())
            {
                string sqlcreation = "";


                sqlcreation += "CREATE TABLE IF NOT EXISTS user(";
                sqlcreation += "id INTEGER NOT NULL ";
                sqlcreation += "PRIMARY KEY AUTOINCREMENT,";
                sqlcreation += "name     VARCHAR(50) NOT NULL,";
                sqlcreation += "password VARCHAR(50) NOT NULL";
                sqlcreation += ");";

                command.CommandText = sqlcreation;
                command.ExecuteNonQuery();
            }

            connection.Close();
        }
    }


    public void Query(string q)
    {
        using (var connection = new SqliteConnection(dbName))
        {
            connection.Open();

            using (var command = connection.CreateCommand())
            {
                command.CommandText = q;
                using (IDataReader reader = command.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Debug.Log("name: " + reader["name"] + " password: " + reader["password"]);

                    }
                }
            }

            connection.Close();
        }
    }
}





//https://medium.com/@rizasif92/sqlite-and-unity-how-to-do-it-right-31991712190
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Mono.Data.Sqlite;
using Mono.Data;
using System.Data;

public class InsertInto : MonoBehaviour
{

    public static InsertInto instance;
    private string dbName = "URI=file:DataBase.db";

    public string user;
    private string puntuazioa;
    private string data;


    private void Awake()
    {
        instance = this;
    }

    // Start is called before the first frame update
    void Start()
    {
        CreateTable_user();
        Query_user("INSERT INTO user (name, password) VALUES ('Pedro', '654321');");
        Query_user("SELECT * FROM user;");

        //tabla partida
        CreateTable_partida();


        //Query_partida2("a", 1, "aa");

        //Query_partida("INSERT INTO partida (user, puntuazioa, data) VALUES ('adrian', 45001, '13/01/2023');");
        //Query_partida("INSERT INTO partida (user, puntuazioa, data) VALUES ('alain', 984, '26/12/2022');");
        //Query_partida("INSERT INTO partida (user, puntuazioa, data) VALUES ('joseba', 3349, '17/08/2022');");
        //Query_partida("INSERT INTO partida (user, puntuazioa, data) VALUES ('haritz', 2996, '09/11/2022');");
        Query_partida("SELECT * FROM partida;");

    }

    // Update is called once per frame
    void Update()
    {

    }

    public InsertInto()
    {
        
    }

    public InsertInto(string user, string puntuazioa, string data)
    {
        this.user = user;
        this.puntuazioa = puntuazioa;
        this.data = data;
    }

    public string getUser()
    {
        return this.user;
    }

    public string getPuntuazioa()
    {
        return this.puntuazioa;
    }

    public string getData()
    {
        return this.user;
    }


    public void setUser(string user)
    {
        this.user = user;
    }

    public void setPuntuazioa(string puntuazioa)
    {
        this.puntuazioa = puntuazioa;
    }

    public void setData(string data)
    {
        this.data = data;
    }


    //public void InserIntoDB()
    //{
    //    string conn = SetDataBaseClass.SetDataBase(DataBaseName + ".db");
    //    IDbConnection dbcon;
    //}


    public void CreateTable_user()
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


    public void CreateTable_partida()
    {
        using (var connection = new SqliteConnection(dbName))
        {
            connection.Open();

            using (var command = connection.CreateCommand())
            {
                string sqlcreation = "";


                sqlcreation += "CREATE TABLE IF NOT EXISTS partida(";
                sqlcreation += "id INTEGER NOT NULL ";
                sqlcreation += "PRIMARY KEY AUTOINCREMENT,";
                sqlcreation += "user     char(32) NOT NULL,";
                sqlcreation += "puntuazioa char(32) NOT NULL";
                sqlcreation += "data char(32) NOT NULL";
                sqlcreation += ");";

                command.CommandText = sqlcreation;
                command.ExecuteNonQuery();
            }

            connection.Close();
        }
    }


    public void Query_user(string q)
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


    public void Query_partida2(string user, float puntuazioa, string data)
    {
        //, string user, float puntuazioa, string data
        //INSERT INTO partida (user, puntuazioa, data) VALUES ('adrian', 45001, '13/01/2023');

        string q = "INSERT INTO partida (user, puntuazioa, data) VALUES ('" + user + "', " + puntuazioa + ", '" + data + "'";

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
                        Debug.Log("id: " + reader["id"] + " user: " + reader["user"] + " puntuazioa: " + reader["puntuazioa"] + " data: " + reader["data"]);

                    }
                }
            }

            connection.Close();
        }
    }

    public void Query_partida(string q)
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
                        Debug.Log("id: " + reader["id"] + " user: " + reader["user"] + " puntuazioa: " + reader["puntuazioa"] + " data: " + reader["data"]);

                    }
                }
            }

            connection.Close();
        }
    }






}

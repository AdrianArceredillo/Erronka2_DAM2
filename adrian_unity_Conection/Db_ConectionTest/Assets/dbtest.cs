using UnityEngine;
using Mono.Data.Sqlite;
using System.Data;
using System;

public class dbtest : MonoBehaviour
{

    private void Start()
    {
        ReadDatabase();
    }


    void ReadDatabase()
    {
        string conn = "URI=file:" + Application.dataPath + "/testdb.db"; //Path to database.
        IDbConnection dbconn;
        dbconn = (IDbConnection)new SqliteConnection(conn);
        dbconn.Open(); //Open connection to the database.
        IDbCommand dbcmd = dbconn.CreateCommand();
        string sqlQuery = "SELECT id, user, puntuazioa, data " + "FROM partida";
        dbcmd.CommandText = sqlQuery;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            int id = reader.GetInt32(0);
            string user = reader.GetString(1);
            int puntuazioa = reader.GetInt32(2);
            string data = reader.GetString(3);

            Debug.Log("Partida[" +
                "Id = " + id +
                ", user = " + user +
                ", puntuazioa = " + puntuazioa +
                ", data = " + data + "]");
        }
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        dbconn.Close();
        dbconn = null;
    }

}



//https://www.youtube.com/watch?v=ONi0M4PyXE0

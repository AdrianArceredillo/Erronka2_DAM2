using Mono.Data.Sqlite;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using UnityEditor.UIElements;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class conn_00 : MonoBehaviour
{
    //private string conn = "URI=file:Db/testdb.db";
    public GameObject obst;
    public Text texto_User;
    public Text texto_Puntuazioa;
    public Text texto_Data;


    //public conn_00(string name, Int32 puntuazioa, string data)
    //{
    //    insertNewPartida(name, puntuazioa, data); //Partida berria(erabiltzailea, puntuazioa)
    //}

    // called when the cube hits the floor
    void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag == obst.tag)
        {
            //Debug.Log("Prueba del loggg");

            
            StateNameController.usuario = texto_User.text;
            SceneManager.LoadScene("FinishGameScene");

            //insertNewPartida();
            ReadDatabase();
        }
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


    void insertNewPartida()
    {

        string conn = "URI=file:" + Application.dataPath + "/testdb.db";
        IDbConnection dbconn;
        dbconn = (IDbConnection)new SqliteConnection(conn);
        dbconn.Open(); //Open connection to the database.
        IDbCommand dbcmd = dbconn.CreateCommand();


        string sql = "INSERT INTO partida (id, user, puntuazioa, data) VALUES (null, @param1,@param2,@param3);";
        dbcmd.CommandText = sql;
        dbcmd.Parameters.Add(new SqliteParameter("@param1", texto_User.text));
        //dbcmd.Parameters.Add(new SqliteParameter("@param2", Int32.Parse(texto_Puntuazioa.text)));
        dbcmd.Parameters.Add(new SqliteParameter("@param2", 2));
        dbcmd.Parameters.Add(new SqliteParameter("@param3", texto_Data.text));
        dbcmd.ExecuteNonQuery();
        dbcmd.Dispose();


        dbcmd.CommandText = sql;
        //IDataReader reader = dbcmd.ExecuteReader();


        //reader.Close();
        //reader = null;
        //dbcmd.Dispose();
        //dbcmd = null;
        //dbconn.Close();
        //dbconn = null;




    }

}

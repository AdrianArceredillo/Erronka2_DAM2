using Mono.Data.Sqlite;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class Conn_SQLite : MonoBehaviour
{
    //datos a guardar en la base de datos
    public Text nombreJugador;//nombre del jugador
    public Text partidaPuntuacion;//puntuación de la partida
    public Text partidaFecha;//fecha de la partida

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }

    public void add_Partida()
    {
        string conn = "URI=file:" + Application.dataPath + "/erronka2.db";

        IDbConnection dbconn;
        dbconn = (IDbConnection)new SqliteConnection(conn);
        dbconn.Open(); //Open connection to the database.
        IDbCommand dbcmd = dbconn.CreateCommand();
        string sql = "INSERT INTO partida (id, user, puntuazioa, data) VALUES (null, @param1,@param2,@param3);";
        dbcmd.CommandText = sql;

        //Debug.Log("User: " + StateResumenPartida.jugador);
        //Debug.Log("Punt: " + StateResumenPartida.puntuacion);
        //Debug.Log("Data: " + partidaFecha.text);

        dbcmd.Parameters.Add(new SqliteParameter("@param1", StateResumenPartida.jugador));
        dbcmd.Parameters.Add(new SqliteParameter("@param2", StateResumenPartida.puntuacion));
        dbcmd.Parameters.Add(new SqliteParameter("@param3", partidaFecha.text));
        dbcmd.ExecuteNonQuery();
        dbcmd.Dispose();

        dbcmd.CommandText = sql;

        SceneManager.LoadScene("MainMenu");

    }




    void read_partidak()
    {
        string conn = "URI=file:" + Application.dataPath + "/erronka2.db";
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

using Mono.Data.Sqlite;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using UnityEngine;
using UnityEngine.UI;

public class SavePartida : MonoBehaviour
{

    public Text texto_Usuario;
    public Text texto_Puntuazioa;
    public Text texto_Data;


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

        string conn = "URI=file:" + Application.dataPath + "/testdb.db";
        IDbConnection dbconn;
        dbconn = (IDbConnection)new SqliteConnection(conn);
        dbconn.Open(); //Open connection to the database.
        IDbCommand dbcmd = dbconn.CreateCommand();


        string sql = "INSERT INTO partida (id, user, puntuazioa, data) VALUES (null, @param1,@param2,@param3);";
        dbcmd.CommandText = sql;

        Debug.Log("User: " + texto_Usuario.text);
        Debug.Log("Punt: " + Int32.Parse(texto_Puntuazioa.text));
        Debug.Log("Data: " + texto_Data.text);

        dbcmd.Parameters.Add(new SqliteParameter("@param1", texto_Usuario.text));
        //dbcmd.Parameters.Add(new SqliteParameter("@param2", Int32.Parse(texto_Puntuazioa.text)));
        dbcmd.Parameters.Add(new SqliteParameter("@param2", Int32.Parse(texto_Puntuazioa.text)));
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

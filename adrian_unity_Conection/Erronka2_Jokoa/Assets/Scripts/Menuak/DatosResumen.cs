using System;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.CompilerServices;
using UnityEditor.UIElements;
using UnityEngine;
using UnityEngine.UI;

public class DatosResumen : MonoBehaviour
{

    //public Text txt_jugador;//usuario recibido
    //public Text txt_puntuacion;//puntuación recibida

    public Text infoJugador;//visualizar nombre de usuario recibido
    public Text infoPuntuacion;//visualizar puntuación recibida
    public Text infoFechaPartida;//visualizar puntuación recibida

    //private int puntuacion_Dato;
    //private String jugador_Dato;



    private DateTime current_date;//fecha actual

    // Start is called before the first frame update
    void Start()
    {
        //current_date = DateTime.Now;//fecha actual -> fecha en la que se ha jugado la partida
        //String fecha_str = current_date.ToString("yyyy-MM-dd");
        //obtener_datos_partida(txt_jugador, txt_puntuacion);//recibir y guardar los datos -> jugador y puntuación


        obtener_jugador();
        //infoJugador.text = StateResumenPartida.jugador.ToString().Trim();
        //if (StateResumenPartida.jugador.Length >= 1)
        //{
        //    infoJugador.text = StateResumenPartida.jugador.ToString().Trim();
        //}
        //else
        //{
        //    infoJugador.text = "Desconocido...";
        //}


        obtener_puntuacion();
        //String lectura_puntuacion;
        //try
        //{
        //    lectura_puntuacion = StateResumenPartida.puntuacion.ToString().Trim();
        //}
        //catch (Exception e)
        //{
        //    lectura_puntuacion = "0";
        //    Debug.Log("Algo ha salido mal...");
        //}

        //infoPuntuacion.text = lectura_puntuacion.Trim();


        obtener_fecha();

    }

    // Update is called once per frame
    void Update()
    {

    }


    private void obtener_datos_partida(Text leer_jugador, Text leer_puntuacion)
    {
        //String str_player = leer_jugador.text;  //obtener dato jugador
        //jugador_Dato = str_player;//guardar dato - nombre del jugador

        //int valor_puntuacion;
        //try
        //{
        //    //valor_puntuacion = Convert.ToInt32(str_player);
        //    valor_puntuacion = Int32.Parse(leer_puntuacion.text.Trim());//convertir dato (puntuación)
        //    puntuacion_Dato = valor_puntuacion;//guardar dato - puntuación de la partida
        //}
        //catch (Exception e)
        //{

        //}

    }


    private void obtener_jugador()
    {
        if (StateResumenPartida.jugador.Length >= 1)
        {
            infoJugador.text = StateResumenPartida.jugador.ToString().Trim();
        }
        else
        {
            infoJugador.text = "Desconocido";
        }
    }

    private void obtener_puntuacion()
    {
        if (StateResumenPartida.puntuacion >= 1)
        {
            infoPuntuacion.text = StateResumenPartida.puntuacion.ToString().Trim() + " pts.";
            infoPuntuacion.color = Color.green;
        }
        else if (StateResumenPartida.puntuacion == 0)
        {
            infoPuntuacion.text = StateResumenPartida.puntuacion.ToString().Trim() + " pts.";
            infoPuntuacion.color = Color.white;
        }
        else if (StateResumenPartida.puntuacion < 0)
        {
            infoPuntuacion.text = StateResumenPartida.puntuacion.ToString().Trim() + " pts.";
            infoPuntuacion.color = Color.red;
        }
        else
        {
            infoPuntuacion.text = "Score not found...";
            infoPuntuacion.color = Color.red;
        }
    }

    private void obtener_fecha()
    {
        current_date = DateTime.Now;//fecha actual -> fecha en la que se ha jugado la partida
        String fecha_str = current_date.ToString("yyyy-MM-dd");

        infoFechaPartida.text = fecha_str.Trim();
    }

}

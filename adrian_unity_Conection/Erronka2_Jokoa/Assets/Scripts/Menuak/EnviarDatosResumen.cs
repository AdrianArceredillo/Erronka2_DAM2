using System;
using System.Collections;
using System.Collections.Generic;
using System.Globalization;
using UnityEngine;
using UnityEngine.UI;

public class EnviarDatosResumen : MonoBehaviour
{

    public Text txt_jugador;        //recibir dato - nombre del jugador de la partida
    public Text txt_puntuacion;     //recibir dato - puntuación obtenida en la partida

    // Start is called before the first frame update
    void Start()
    {
        //enviar - nombre del jugador
        StateResumenPartida.jugador = txt_jugador.text;

        //enviar - puntuación de la partida
        try
        {
            //int ptos = Int32.Parse(txt_puntuacion.text.Trim());
            //StateResumenPartida.puntuacion = ptos;

            float ptos_value = float.Parse(txt_puntuacion.text.Trim(), CultureInfo.InvariantCulture.NumberFormat);
            StateResumenPartida.puntuacion = ptos_value;
        }
        catch
        {

        }
    }

    // Update is called once per frame
    void Update()
    {

    }
}

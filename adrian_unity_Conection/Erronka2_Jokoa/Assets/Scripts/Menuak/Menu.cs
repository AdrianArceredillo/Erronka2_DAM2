using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class Menu : MonoBehaviour
{
    [SerializeField] private GameObject botonContinuar; //bot�n que activa el men� de pausa de los k
    [SerializeField] private GameObject menuResumen;    //elemento que ser� el men�
    [SerializeField] private GameObject finalPartida_notificacion;    //mensaje de final de partida

    [SerializeField] private GameObject imagen_Mancha;          //imagen - mancha sangre

    [SerializeField] private GameObject personaje_Camina;       //personaje caminando
    [SerializeField] private GameObject personaje_Disparando;   //personaje disparando

    private bool juegoPausado = false;

    [SerializeField] private GameObject texto_Fondo;    //texto fondo de men� (logo juego)


    public Text txt_jugador;        //txt leer
    public Text txt_puntuacion;     //txt leer

    public Text txt_jugador_resumen;        //txt escribir
    public Text txt_puntuacion_resumen;     //txt escribir


    private void Update()
    {
        //if (Input.GetKeyDown(KeyCode.Escape))   //activar men� al pulsar la tecla Escape
        //{
        //    texto_Fondo.SetActive(false);

        //    if (juegoPausado)
        //    {
        //        Reanudar();
        //    }
        //    else
        //    {
        //        ResumenPartida();
        //    }
        //}
    }

    //funci�n que establecer� "pausa" al juego
    public void ResumenPartida()
    {
        juegoPausado = true;
        Time.timeScale = 0f;

        imagen_Mancha.SetActive(false);     //ocultar imagen - mancha sangre

        personaje_Camina.SetActive(false);
        personaje_Disparando.SetActive(false);

        finalPartida_notificacion.SetActive(false);
        botonContinuar.SetActive(false);    //deshabilitar el bot�n de pausa
        menuResumen.SetActive(true);      //activar y visualizar el men� de pausa


        StateResumenPartida.jugador = txt_jugador.text;
        try
        {
            int ptos = Int32.Parse(txt_puntuacion.text.Trim());
            StateResumenPartida.puntuacion = ptos;
        }
        catch
        {
            StateResumenPartida.puntuacion = 0;
        }

    }

    //funci�n para reanudar la partida
    public void Reanudar()
    {
        juegoPausado = false;
        Time.timeScale = 1f;
        botonContinuar.SetActive(true);     //habilitar el bot�n pausa
        menuResumen.SetActive(false);     //ocultar el men�

        texto_Fondo.SetActive(true);
    }

    //guardar los datos de la partida y regresar al men� principal
    public void guardar_partida()
    {
        //guardar partida


        //regresar al men� despu�s de guardar la partida
        SceneManager.LoadScene("MainMenu");
    }

    //resetear la partida
    public void reiniciar_partida()
    {
        juegoPausado = false;
        Time.timeScale = 1f;

        SceneManager.LoadScene(SceneManager.GetActiveScene().name);
    }

    //volver al men� principal
    public void return_mainMenu()
    {
        Time.timeScale = 1f;

        Debug.Log("Volviendo al MEN� PRINCIPAL");
        SceneManager.LoadScene("MainMenu");
    }

    //detener la ejecuci�n completa del juego
    public void CerrarJuego()
    {
        /*
        Detiene la ejecuci�n de todo el proyecto de Unity
        */
#if UNITY_EDITOR
        UnityEditor.EditorApplication.isPlaying = false;
#else
    Application.Quit();
#endif

        texto_Fondo.SetActive(true);
        Application.Quit();
        Debug.Log("Game is exiting");
    }

}

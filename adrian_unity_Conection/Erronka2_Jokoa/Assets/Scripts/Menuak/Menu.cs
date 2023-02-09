using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class Menu : MonoBehaviour
{
    [SerializeField] private GameObject botonContinuar; //botón que activa el menú de pausa de los k
    [SerializeField] private GameObject menuResumen;    //elemento que será el menú
    [SerializeField] private GameObject finalPartida_notificacion;    //mensaje de final de partida

    [SerializeField] private GameObject imagen_Mancha;          //imagen - mancha sangre

    [SerializeField] private GameObject personaje_Camina;       //personaje caminando
    [SerializeField] private GameObject personaje_Disparando;   //personaje disparando

    private bool juegoPausado = false;

    [SerializeField] private GameObject texto_Fondo;    //texto fondo de menú (logo juego)


    public Text txt_jugador;        //txt leer
    public Text txt_puntuacion;     //txt leer

    public Text txt_jugador_resumen;        //txt escribir
    public Text txt_puntuacion_resumen;     //txt escribir


    private void Update()
    {
        //if (Input.GetKeyDown(KeyCode.Escape))   //activar menú al pulsar la tecla Escape
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

    //función que establecerá "pausa" al juego
    public void ResumenPartida()
    {
        juegoPausado = true;
        Time.timeScale = 0f;

        imagen_Mancha.SetActive(false);     //ocultar imagen - mancha sangre

        personaje_Camina.SetActive(false);
        personaje_Disparando.SetActive(false);

        finalPartida_notificacion.SetActive(false);
        botonContinuar.SetActive(false);    //deshabilitar el botón de pausa
        menuResumen.SetActive(true);      //activar y visualizar el menú de pausa


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

    //función para reanudar la partida
    public void Reanudar()
    {
        juegoPausado = false;
        Time.timeScale = 1f;
        botonContinuar.SetActive(true);     //habilitar el botón pausa
        menuResumen.SetActive(false);     //ocultar el menú

        texto_Fondo.SetActive(true);
    }

    //guardar los datos de la partida y regresar al menú principal
    public void guardar_partida()
    {
        //guardar partida


        //regresar al menú después de guardar la partida
        SceneManager.LoadScene("MainMenu");
    }

    //resetear la partida
    public void reiniciar_partida()
    {
        juegoPausado = false;
        Time.timeScale = 1f;

        SceneManager.LoadScene(SceneManager.GetActiveScene().name);
    }

    //volver al menú principal
    public void return_mainMenu()
    {
        Time.timeScale = 1f;

        Debug.Log("Volviendo al MENÚ PRINCIPAL");
        SceneManager.LoadScene("MainMenu");
    }

    //detener la ejecución completa del juego
    public void CerrarJuego()
    {
        /*
        Detiene la ejecución de todo el proyecto de Unity
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

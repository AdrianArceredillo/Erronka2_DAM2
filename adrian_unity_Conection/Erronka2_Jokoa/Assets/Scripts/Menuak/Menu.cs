using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

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

    private void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape))   //activar menú al pulsar la tecla Escape
        {
            texto_Fondo.SetActive(false);

            if (juegoPausado)
            {
                Reanudar();
            }
            else
            {
                ResumenPartida();
            }
        }
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

    /*
     Función para resetear la partida y empezar de nuevo:
        - cuando esto ocurra, otro script que tendrá esta escena, reseteará 
          la puntuación de la partida
     */
    public void Reiniciar()
    {
        juegoPausado = false;
        Time.timeScale = 1f;

        //cargar la escena actual para simular el reinicio de la partida
        SceneManager.LoadScene(SceneManager.GetActiveScene().name);
        texto_Fondo.SetActive(true);
    }

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

    public void VolverMenuMain()
    {
        SceneManager.LoadScene("MainMenu");
    }

}

using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class MainMenuController : MonoBehaviour
{
    public void jokoa_ireki(Text user_Jugador)
    {
        if (user_Jugador.text == "")
        {
            user_Jugador.text = "unknown :(";
            user_Jugador.color = Color.red;
        }
        else
        {
            //StateNameController.usuario = "Player: " + user_Jugador.text;
            StateNameController.usuario = user_Jugador.text;
            SceneManager.LoadScene("JokoaScene");
        }
    }

    public void jokoa_itxi()
    {
        /*
        Detiene la ejecución de todo el proyecto de Unity
        */
#if UNITY_EDITOR
        UnityEditor.EditorApplication.isPlaying = false;
#else
    Application.Quit();
#endif

        Application.Quit();
        Debug.Log("Game is exiting");
    }

}

using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class MainMenuController : MonoBehaviour
{

    public void loadGame(Text user_Jugador)
    {
        StateNameController.usuario = user_Jugador.text;
        SceneManager.LoadScene("Third");
    }

    //tutorial video
    //public void LoadGame(string input)
    //{
    //    StateNameController.usuario = input;
    //    SceneManager.LoadScene("Third");
    //}
}



//https://www.youtube.com/watch?v=pMXJv9zzkGg
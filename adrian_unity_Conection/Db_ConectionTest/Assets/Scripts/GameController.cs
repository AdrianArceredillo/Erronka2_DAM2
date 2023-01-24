using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class GameController : MonoBehaviour
{

    public Text usuarioText;

    private void Start()
    {
        usuarioText.text = StateNameController.usuario;
    }


    public void returnBack(Text last_Player)
    {
        StateNameController.usuario = last_Player.text;
        SceneManager.LoadScene("StartScene");
    }
}


//https://www.youtube.com/watch?v=pMXJv9zzkGg
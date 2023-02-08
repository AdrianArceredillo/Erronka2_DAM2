using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class SceneSwitcher : MonoBehaviour
{
    //cargar la siguiente escena que se haya compilado
    public void playGame()
    {
        SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex + 1);
    }

    //public void returnToGame()
    //{
    //    SceneManager.LoadScene("GameScene");
    //}

    //public void exitGame()
    //{
    //    SceneManager.LoadScene("StartScene");
    //}
}

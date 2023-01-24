using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class EndGame_Detect : MonoBehaviour
{

    public Text texto_User;
    public Text texto_Puntuazioa;
    public Text texto_Data;

    void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "ground")
        {
            StateNameController.usuario = texto_User.text;
            StateNameController.score = texto_Puntuazioa.text;
            StateNameController.date = texto_Data.text;
            SceneManager.LoadScene("FinishGameScene");
        }
    }
}

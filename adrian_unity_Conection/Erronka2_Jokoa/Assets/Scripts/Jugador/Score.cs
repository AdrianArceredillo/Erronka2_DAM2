using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Score : MonoBehaviour
{
    public Text MyScoreText;    //texto que se actualizará en base a la puntuación
    private int ScoreNum;       //puntuación del jugador

    void Start()
    {
        ScoreNum = 0;
        MyScoreText.text = ScoreNum.ToString();
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        //if (collision.transform.tag == "enemigo")
        //{
        //    int puntuacion_Partida = Int32.Parse(MyScoreText.text);
        //    puntuacion_Partida = puntuacion_Partida + 100;
        //    MyScoreText.text = puntuacion_Partida.ToString();

        //    int curren_Points = Int32.Parse(MyScoreText.text);
        //    if (curren_Points > 0)
        //    {
        //        MyScoreText.color = Color.green;
        //    }
        //    else
        //    {
        //        MyScoreText.color = Color.red;
        //    }
        //}

        if (collision.transform.tag == "Player")
        {
            int puntuacion_Partida = Int32.Parse(MyScoreText.text);
            puntuacion_Partida = puntuacion_Partida - 100;
            MyScoreText.text = puntuacion_Partida.ToString();

            int curren_Points = Int32.Parse(MyScoreText.text);
            if (curren_Points > 0)
            {
                MyScoreText.color = Color.green;
            }
            else
            {
                MyScoreText.color = Color.red;
            }
        }

        if (collision.transform.tag == "Player_Disparando")
        {
            int puntuacion_Partida = Int32.Parse(MyScoreText.text);
            puntuacion_Partida = puntuacion_Partida + 100;
            MyScoreText.text = puntuacion_Partida.ToString();

            int curren_Points = Int32.Parse(MyScoreText.text);
            if (curren_Points > 0)
            {
                MyScoreText.color = Color.green;
            }
            else
            {
                MyScoreText.color = Color.red;
            }
        }
    }



    private void OnTriggerEnter2D(Collider2D MyBall)
    {
        if (MyBall.tag == "peloaaaata")
        {
            ScoreNum += 100;
            MyScoreText.text = ScoreNum.ToString();
            MyScoreText.color = Color.green;    //cambiar colr del dato
        }
    }
}

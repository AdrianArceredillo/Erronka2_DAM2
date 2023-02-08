using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Score : MonoBehaviour
{
    public Text MyScoreText;    //texto que se actualizará en base a la puntuación
    public Text PlayerText;     //nombre del jugador
    private int ScoreNum;       //puntuación del jugador

    public int lives;           //número de vidas de la partida
    public GameObject heart_1;
    public GameObject heart_2;
    public GameObject heart_3;
    //public GameObject img_Live4;
    //public GameObject img_Live5;

    public Image bloodEffect_image;     //imagen efecto de sangrado
    public Image bloodStain_image;      //imagen mancha de sangre

    private float r;
    private float g;
    private float b;
    private float a;

    public Text lblNombre;  //lbl nombre del jugador
    public Text lblScore;   //lbl puntuación de la partida
    public Text lblLives;   //lbl vidas restantes

    [SerializeField] private GameObject personaje_Camina;       //personaje caminando
    [SerializeField] private GameObject personaje_Disparando;   //personaje disparando


    [SerializeField] private GameObject finalPartida_notificacion;      //mensaje de final de partida
    [SerializeField] private GameObject menuResumen;                    //elemento que será el menú

    void Start()
    {
        ScoreNum = 0;
        MyScoreText.text = ScoreNum.ToString();
        lives = 3;

        ResetColor_BloodEffect();   //reset efecto sangrado


        //r = bloodEffect_image.color.r;
        //g = bloodEffect_image.color.g;
        //b = bloodEffect_image.color.b;
        ////a = bloodEffect_image.color.a;
        //a = 0f;

        Reset_BloodStain();         //reset mancha sangre

        //bloodStain_image.gameObject.SetActive(false);


        //Color color_stain_inicio = bloodStain_image.color;
        //color_stain_inicio.a = 0f;
        //bloodStain_image.color = color_stain_inicio;


        ResetLabels();      //reset apariencia labels

        //lblNombre.color = Color.red;
        //lblScore.color = Color.red;
        //lblLives.color = Color.red;

        //finalPartida_notificacion.SetActive(false);
        menuResumen.SetActive(false);
        finalPartida_notificacion.SetActive(false);

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

            //a += 0.1f;
            //a = Mathf.Clamp(a, 0, 1f);
            //ChangeColor();

            //restar vidas
            if (lives == 3)
            {
                lives--;
                //visualizar_vidas_partida(true, true, false);
                visualizar_vidas_partida_2(heart_3, false);

                a = 0.1f;
                a = Mathf.Clamp(a, 0, 1f);
                ChangeColor_BloodEffect();

            }
            else if (lives == 2)
            {
                lives--;
                //visualizar_vidas_partida(true, false, false);
                visualizar_vidas_partida_2(heart_2, false);

                a = 0.5f;
                a = Mathf.Clamp(a, 0, 1f);
                ChangeColor_BloodEffect();

            }
            else if (lives == 1)
            {
                //cambiar colores


                lives--;
                //visualizar_vidas_partida(false, false, false);
                visualizar_vidas_partida_2(heart_1, false);

                a = 0.85f;
                a = Mathf.Clamp(a, 0, 1f);
                ChangeColor_BloodEffect();

                Color color_stain = bloodStain_image.color;
                color_stain.a = 90f;
                bloodStain_image.color = color_stain;



                bloodStain_image.gameObject.SetActive(true);

                personaje_Camina.SetActive(false);      //bloquear movimiento - andar
                personaje_Disparando.SetActive(false);  //bloquear movimiento - disparar

                finalPartida_notificacion.SetActive(true);


                //ChangeColor_LabelsPartida();


                //Invoke(nameof(jokoa_itxi), 3.0f);   //finalizar la partida
                Debug.Log("La partida ha terminado...");
            }


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
            else if (curren_Points == 0)
            {
                MyScoreText.color = Color.white;
            }
            else
            {
                MyScoreText.color = Color.red;
            }
        }
    }

    private void visualizar_vidas_partida(bool h1, bool h2, bool h3)
    {
        heart_1.gameObject.SetActive(h1);
        heart_2.gameObject.SetActive(h2);
        heart_3.gameObject.SetActive(h3);
    }

    private void visualizar_vidas_partida_2(GameObject heart, bool estado_H)
    {
        heart.gameObject.SetActive(estado_H);
    }


    #region "Cambios apariencia"

    private void ChangeColor_BloodEffect()
    {
        Color c = new Color(r, g, b, a);
        bloodEffect_image.color = c;
    }

    #endregion





    #region "Resets"

    private void ResetColor_BloodEffect()
    {
        r = bloodEffect_image.color.r;
        g = bloodEffect_image.color.g;
        b = bloodEffect_image.color.b;
        //a = bloodEffect_image.color.a;
        a = 0f;
    }
    private void Reset_BloodStain()
    {
        //desactivar imagen - mancha sangre
        bloodStain_image.gameObject.SetActive(false);

        //resetear transpariencia imagen - mancha sangre
        Color color_stain_inicio = bloodStain_image.color;
        color_stain_inicio.a = 0f;
        bloodStain_image.color = color_stain_inicio;
    }
    private void ResetLabels()
    {
        //etiquetas información (labels)
        lblNombre.color = Color.red;
        lblScore.color = Color.red;
        lblLives.color = Color.red;

        //datos a guardar de la partida
        MyScoreText.color = Color.white;
        PlayerText.color = Color.white;
    }

    #endregion






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

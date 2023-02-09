using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Combate : MonoBehaviour
{

    public float velocidad;

    //configuración de las monedas
    public GameObject Enemigo;
    public GameObject Enemigo_Movimiento;
    //public GameObject bola_Repotando;
    public float maxX, minX;    //límites en el eje X
    public float maxY, minY;    //límites en el eje Y
    private bool haChocado;     //detectar si ha colisionado

    Rigidbody2D rb;             //componente Rigidbody
    Rigidbody2D rb_mov;             //componente Rigidbody


    private int num_Vidas = 5;  //número de vidas de la partida
    
    // Start is called before the first frame update
    void Start()
    {
        //rb = GetComponent<Rigidbody2D>();
        rb = Enemigo.gameObject.GetComponent<Rigidbody2D>();
        rb_mov = Enemigo_Movimiento.gameObject.GetComponent<Rigidbody2D>();

        //rb.mass = 0.01f;            //establecer una masa concreta en el inicio
        //rb.gravityScale = 0.0f;     //establecer un valor para la gravedad
        haChocado = false;
    }

    // Update is called once per frame
    void Update()
    {
        
    }


    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.transform.tag == "enemigo")
        {
            num_Vidas--;        //restar una vida
            Debug.Log("Núm. vidas: " + num_Vidas);

            if (num_Vidas != 0)
            {
                Enemigo_Movimiento.gameObject.SetActive(false);
                Rigidbody2D rb = Enemigo.GetComponent<Rigidbody2D>();
                rb.velocity = Vector3.zero;
                rb.transform.position = new Vector3(UnityEngine.Random.Range(minX, maxX), UnityEngine.Random.Range(maxY, minY), 0f);
                Enemigo_Movimiento.gameObject.transform.position = rb.transform.position;
                //rb.transform.position = new Vector2(14f, 0.56f);
            }
            Debug.Log("La partida vuelve a EMPEZAR! ");

            

            return;
        }

        if (collision.transform.tag == "enemigo_mov")
        {
            num_Vidas--;        //restar una vida
            Debug.Log("Núm. vidas: " + num_Vidas);


            if (num_Vidas != 0)
            {

                //Enemigo.gameObject.SetActive(true);
                Enemigo_Movimiento.gameObject.SetActive(false);


                Rigidbody2D rb = Enemigo.GetComponent<Rigidbody2D>();
                rb.velocity = Vector3.zero;
                rb.transform.position = new Vector3(UnityEngine.Random.Range(minX, maxX), UnityEngine.Random.Range(maxY, minY), 0f);
                Enemigo_Movimiento.gameObject.transform.position = Enemigo.gameObject.GetComponent<Rigidbody2D>().transform.position;
            }

            return;
        }
    }

}


//desplazar enemigo 1: https://www.youtube.com/watch?v=XqSIHjLofCk
//desplazar enemigo 2: https://www.youtube.com/watch?v=fh4H1bPKGfo
using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Combate : MonoBehaviour
{

    public float velocidad;

    //configuración de las monedas
    public GameObject Enemigo;
    //public GameObject bola_Repotando;
    public float maxX, minX;    //límites en el eje X
    public float maxY, minY;    //límites en el eje Y
    private bool haChocado;     //detectar si ha colisionado
    Rigidbody2D rb;             //componente Rigidbody


    private int num_Vidas = 5;  //número de vidas de la partida

    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody2D>();

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

        if (collision.transform.tag == "enemigoooo")
        {
            Debug.Log("Ha chocado ....");

            //Invoke(nameof(actualizar_Vidas), 2.5f);

            haChocado = true;
            rb.mass = 5.0f;
            rb.gravityScale = 20.0f;

            Enemigo.GetComponent<BoxCollider2D>().isTrigger = true;    //desactivar Collider de las monedas
            return;
        }

        if (collision.transform.tag == "enemigo")
        {
            num_Vidas--;        //restar una vida
            Debug.Log("Núm. vidas: " + num_Vidas);

            if (num_Vidas != 0)
            {
                Rigidbody2D rb = Enemigo.GetComponent<Rigidbody2D>();
                rb.velocity = Vector3.zero;
                rb.transform.position = new Vector3(UnityEngine.Random.Range(minX, maxX), UnityEngine.Random.Range(maxY, minY), 0f);
            }
            Debug.Log("La partida vuelve a EMPEZAR! ");

            

            return;
        }
    }



}

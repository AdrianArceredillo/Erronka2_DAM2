using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FlipCharacter : MonoBehaviour
{

    public float speed;
    public Rigidbody2D normal;              //rigidbody2d jugador normal
    public GameObject disparando;           //jugador disparando
    //public GameObject lanzandoGranadas;     //jugador lanzando granadas
    //public GameObject humo_Granada;         //humo de la granada

    bool facingRight = true;

    // Start is called before the first frame update
    void Start()
    {
        normal = GetComponent<Rigidbody2D>();
        //disparando = GetComponent<SpriteRenderer>();
    }

    // Update is called once per frame
    void Update()
    {
        float move = Input.GetAxisRaw("Horizontal");
        normal.velocity = new Vector2(move * speed, normal.velocity.y);

        disparando.gameObject.transform.position =
            normal.gameObject.GetComponent<Rigidbody2D>().transform.position;

        //lanzandoGranadas
        //lanzandoGranadas.gameObject.transform.position =
        //    normal.gameObject.GetComponent<Rigidbody2D>().transform.position;

        //humo granada
        //humo_Granada.gameObject.transform.position =
        //    normal.gameObject.GetComponent<Rigidbody2D>().transform.position;


        if (move < 0 && facingRight)    //si al pulsar Izq. está mirando a la derecha, mirar IZQUIERDA
        {
            flip();
        }
        else if (move > 0 && !facingRight)    //si al pulsar Der. está mirando a la izquierda, mirar DERECHA
        {
            flip();
        }

    }

    void flip()
    {
        facingRight = !facingRight; //cambiar el estado de la variable facingRight
        disparando.transform.Rotate(0f, 180f, 0f);
        //lanzandoGranadas.transform.Rotate(0f, 180f, 0f);
        //humo_Granada.transform.Rotate(0f, 180f, 0f);
    }




}

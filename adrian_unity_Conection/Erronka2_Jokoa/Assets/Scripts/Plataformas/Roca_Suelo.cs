using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Roca_Suelo : MonoBehaviour
{
    public GameObject personaje;            //gameobject del jugador
    public GameObject zombie;               //gameobject zombie
    public GameObject movimiento_Zombie;    //animación del zombie (caminando)

    Rigidbody2D rb_Movimiento_Zombie;       //rigidbody del zombie (edificio)
    Rigidbody2D rb_Personaje;               //rigidbody del jugador

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        //asignarle a la animación del zombie, la misma posición que el zombie quieto
        rb_Movimiento_Zombie = zombie.GetComponent<Rigidbody2D>();
        //obtener la posición del jugador
        rb_Personaje = personaje.GetComponent<Rigidbody2D>();



        //float move = Input.GetAxisRaw("Horizontal");
        //rb_Movimiento_Zombie.velocity = new Vector2(move * 5f, rb_Movimiento_Zombie.velocity.y);


        rb_Movimiento_Zombie.gameObject.transform.position =
            zombie.gameObject.GetComponent<Rigidbody2D>().transform.position;

        //rb_Movimiento_Zombie = personaje.GetComponent<Rigidbody2D>();

    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.transform.tag == "Player")
        {
            zombie.gameObject.SetActive(false);  //desactivar personaje

            //zombie.gameObject.GetComponent<Rigidbody2D>().transform.position = personaje.gameObject.GetComponent<Rigidbody2D>().transform.position;


            //animación de disparos en la misma posición que está el personaje
            movimiento_Zombie.gameObject.transform.position = zombie.gameObject.GetComponent<Rigidbody2D>().transform.position;


            movimiento_Zombie.gameObject.SetActive(true);
            //movimiento_Zombie.gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(-100f * Time.deltaTime, 0));
            movimiento_Zombie.gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(-400f * Time.deltaTime, 0));
            //personaje.gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(100f * Time.deltaTime, 0));


            //Invoke(nameof(caminar_Zombie), 3.0f);
        }
    }
    private void OnCollisionExit2D(Collision2D collision)
    {
        if (collision.transform.tag == "Player")
        {
            //zombie.gameObject.SetActive(false);  //desactivar personaje

            //zombie.gameObject.GetComponent<Rigidbody2D>().transform.position = personaje.gameObject.GetComponent<Rigidbody2D>().transform.position;


            //animación de disparos en la misma posición que está el personaje
            //movimiento_Zombie.gameObject.transform.position = zombie.gameObject.GetComponent<Rigidbody2D>().transform.position;

            //movimiento_Zombie.gameObject.SetActive(true);
            //movimiento_Zombie.gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(400f * Time.deltaTime, 0));


            movimiento_Zombie.gameObject.SetActive(false);
            zombie.gameObject.SetActive(true);

            //Invoke(nameof(caminar_Zombie), 3.0f);
        }
    }


    void caminar_Zombie()
    {
        //desactivar movimiento zombie
        movimiento_Zombie.gameObject.SetActive(false);
        //activar zombie quieto
        zombie.gameObject.SetActive(true);
    }
}

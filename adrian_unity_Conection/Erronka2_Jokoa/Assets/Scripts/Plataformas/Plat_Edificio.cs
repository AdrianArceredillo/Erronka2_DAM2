using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Plat_Edificio : MonoBehaviour
{

    public GameObject personaje;            //gameobject del jugador
    public GameObject zombie;               //gameobject zombie
    public GameObject movimiento_Zombie;    //animaci?n del zombie (caminando)

    Rigidbody2D rb_Movimiento_Zombie;       //rigidbody del zombie (edificio)
    Rigidbody2D rb_Personaje;               //rigidbody del jugador

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        //asignarle a la animaci?n del zombie, la misma posici?n que el zombie quieto
        rb_Movimiento_Zombie = zombie.GetComponent<Rigidbody2D>();
        //obtener la posici?n del jugador
        rb_Personaje = personaje.GetComponent<Rigidbody2D>();



        //float move = Input.GetAxisRaw("Horizontal");
        //rb_Movimiento_Zombie.velocity = new Vector2(move * 5f, rb_Movimiento_Zombie.velocity.y);


        rb_Movimiento_Zombie.gameObject.transform.position =
            zombie.gameObject.GetComponent<Rigidbody2D>().transform.position;

        //rb_Movimiento_Zombie = personaje.GetComponent<Rigidbody2D>();

    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        //if (collision.transform.tag == "Player_Disparando")
        //{
        //    zombie.gameObject.SetActive(false);  //desactivar personaje

        //    //animaci?n de disparos en la misma posici?n que est? el personaje
        //    movimiento_Zombie.gameObject.transform.position = zombie.gameObject.GetComponent<Rigidbody2D>().transform.position;

        //    movimiento_Zombie.gameObject.SetActive(true);
        //    movimiento_Zombie.gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(-400f * Time.deltaTime, 0));

        //    Invoke(nameof(caminar_Zombie), 3.0f);
        //}
    }


    void caminar_Zombie()
    {
        //desactivar movimiento zombie
        movimiento_Zombie.gameObject.SetActive(false);
        movimiento_Zombie.gameObject.transform.position = zombie.gameObject.GetComponent<Rigidbody2D>().transform.position;
        //activar zombie quieto
        zombie.gameObject.SetActive(true);
    }


}

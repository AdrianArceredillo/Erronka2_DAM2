using System.Collections;
using System.Collections.Generic;
//using System.Diagnostics;
using UnityEngine;

public class Zombie : MonoBehaviour
{

    public GameObject personaje;            //gameobject del jugador
    public GameObject zombie;               //gameobject zombie
    public GameObject movimiento_Zombie;    //animación del zombie (caminando)


    Rigidbody2D rb_Movimiento_Zombie;       //rigidbody del zombie (edificio)
    Rigidbody2D rb_Personaje;               //rigidbody del jugador

    //[SerializeField] private PolygonCollider2D playerCollider;
    //[SerializeField] private BoxCollider2D zombieCollider;

    // Start is called before the first frame update
    void Start()
    {
        movimiento_Zombie.gameObject.SetActive(true);
        movimiento_Zombie.gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(-400f * Time.deltaTime, 0));
    }

    // Update is called once per frame
    void Update()
    {
        detectarMovimientoPlayer();

        //asignarle a la animación del zombie, la misma posición que el zombie quieto
        rb_Movimiento_Zombie = zombie.GetComponent<Rigidbody2D>();
        //obtener la posición del jugador
        rb_Personaje = personaje.GetComponent<Rigidbody2D>();

        //float move = Input.GetAxisRaw("Horizontal");
        //rb_Movimiento_Zombie.velocity = new Vector2(move * 5f, rb_Movimiento_Zombie.velocity.y);


        rb_Movimiento_Zombie.gameObject.transform.position =
            zombie.gameObject.GetComponent<Rigidbody2D>().transform.position;

        //rb_Movimiento_Zombie = personaje.GetComponent<Rigidbody2D>();

        //detectar posición jugador
        if (
            //comprobar eje Y
            gameObject.transform.position.y >= -0.5f &&
            gameObject.transform.position.y <= 1.5f &&
            //comprobar eje X
            gameObject.transform.position.x >= 0f &&
            gameObject.transform.position.x <= 18.5f
            )
        {
        }

    }

    public void detectarMovimientoPlayer()
    {
        if (Input.GetKey(KeyCode.Z))
        {
            zombie.gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(-25f * Time.deltaTime, 0));
            //gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(-25f * Time.deltaTime, 0));
        }

        //zombie camina hacia el personaje del jugador
        if (Input.GetKeyDown(KeyCode.Q))
        {
            zombie.gameObject.SetActive(false);  //desactivar zombie quieto
            //animación de disparos en la misma posición que está el personaje
            movimiento_Zombie.gameObject.transform.position = zombie.gameObject.GetComponent<Rigidbody2D>().transform.position;


            movimiento_Zombie.gameObject.transform.position = new Vector2(-100f * Time.deltaTime, 0);

            //while (movimiento_Zombie.gameObject.transform.position.x < rb_Personaje.gameObject.transform.position.x)
            //{
            //    movimiento_Zombie.gameObject.SetActive(true);

            //    //desplazar el zombie (anim. caminando)
            //    movimiento_Zombie.gameObject.transform.position = new Vector3(
            //        movimiento_Zombie.gameObject.transform.position.x * 5f * Time.deltaTime,
            //        movimiento_Zombie.gameObject.transform.position.y,
            //        movimiento_Zombie.gameObject.transform.position.z
            //    );


            //    Invoke(nameof(caminar_Zombie), 5.0f);
            //}
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

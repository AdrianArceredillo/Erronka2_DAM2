using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimientoJugador : MonoBehaviour
{

    public GameObject personaje;
    public GameObject disparando;
    public GameObject granadas;
    public GameObject granada_Humo;

    Rigidbody2D rb_Disparando;
    Rigidbody2D rb_LanzandoGranadas;
    Rigidbody2D rb_Granada_Humo;

    public GameObject oneWayPlat;    //plataforma unidireccional
    [SerializeField] private PolygonCollider2D playerCollider;

    bool facingRight = true;

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        movimientosPlayer();

        rb_Disparando = personaje.GetComponent<Rigidbody2D>();
        rb_LanzandoGranadas = personaje.GetComponent<Rigidbody2D>();
        rb_Granada_Humo = personaje.GetComponent<Rigidbody2D>();

        float move = Input.GetAxisRaw("Horizontal");
        rb_Disparando.velocity = new Vector2(move * 5f, rb_Disparando.velocity.y);
        rb_LanzandoGranadas.velocity = new Vector2(move * 5f, rb_LanzandoGranadas.velocity.y);
        rb_Granada_Humo.velocity = new Vector2(move * 5f, rb_Granada_Humo.velocity.y);

        rb_Disparando.gameObject.transform.position =
            personaje.gameObject.GetComponent<Rigidbody2D>().transform.position;

        rb_LanzandoGranadas.gameObject.transform.position =
            personaje.gameObject.GetComponent<Rigidbody2D>().transform.position;

        rb_Granada_Humo.gameObject.transform.position =
            personaje.gameObject.GetComponent<Rigidbody2D>().transform.position;

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
        //rb_Disparando.transform.Rotate(0f, 180f, 0f);
        rb_LanzandoGranadas.transform.Rotate(0f, 180f, 0f);
    }


    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.transform.tag == "ground")
        {

        }
        else if (collision.transform.tag == "plataforma_1")
        {

        }
        else if (collision.transform.tag == "otro")
        {
            gameObject.GetComponent<Rigidbody2D>().transform.position = new Vector3(-45.8f, 24.7f, 0);
            //Application.Quit();
        }

    }


    public void movimientosPlayer()
    {
        //KeyCodes for the whole keyboard -> https://docs.unity3d.com/ScriptReference/KeyCode.html


        if (Input.GetKey(KeyCode.A))
        {
            gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(-25f * Time.deltaTime, 0));
        }

        if (Input.GetKey(KeyCode.D))
        {
            gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(25f * Time.deltaTime, 0));
        }

        if (Input.GetKeyDown(KeyCode.W))
        {
            gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(0, 10f));
        }

        if (Input.GetKeyDown(KeyCode.S))
        {
            if (oneWayPlat != null)
            {
                StartCoroutine(DisableCollision());
            }
        }


        //disparar
        if (Input.GetKeyDown(KeyCode.F))
        {
            //disparo.gameObject.SetActive(true);
            //Invoke(nameof(estado_Disparando),0.0f);

            personaje.gameObject.SetActive(false);  //desactivar personaje
            //animación de disparos en la misma posición que está el personaje
            disparando.gameObject.transform.position = personaje.gameObject.GetComponent<Rigidbody2D>().transform.position;

            disparando.gameObject.SetActive(true);
            Invoke(nameof(disp), 1.0f);
        }

        //lanzar_Granadas
        if (Input.GetKeyDown(KeyCode.R))
        {

            personaje.gameObject.SetActive(false);  //desactivar personaje
            //animación de lanzar granada en la misma posición que está el personaje
            granadas.gameObject.transform.position = personaje.gameObject.GetComponent<Rigidbody2D>().transform.position;
            granada_Humo.gameObject.transform.position = new Vector3(
                            personaje.gameObject.GetComponent<Rigidbody2D>().transform.position.x + 4.0f,
                            personaje.gameObject.GetComponent<Rigidbody2D>().transform.position.y,
                            personaje.gameObject.GetComponent<Rigidbody2D>().transform.position.z
                            );

            granadas.gameObject.SetActive(true);
            granada_Humo.gameObject.SetActive(true);
            Invoke(nameof(lanzamientoGranadas), 1.0f);
        }

    }


    void disp()
    {
        //desactivar disparos
        disparando.gameObject.SetActive(false);
        //activar personaje
        personaje.gameObject.SetActive(true);
    }

    void lanzamientoGranadas()
    {
        //activar explosión de la granada
        

        //desactivar lanzamiento granadas
        granadas.gameObject.SetActive(false);

        Invoke(nameof(explosionGranada_Humo), 1.0f);
        //granada_Humo.gameObject.SetActive(false);
        //activar personaje
        //personaje.gameObject.SetActive(true);

        //explosionGranada_Humo

    }


    void explosionGranada_Humo()
    {
        //desactivar lanzamiento granadas
        granadas.gameObject.SetActive(false);
        //desac
        granada_Humo.gameObject.SetActive(false);
        //activar personaje
        personaje.gameObject.SetActive(true);
    }

    IEnumerator estado_Disparando()
    {
        //Print the time of when the function is first called.
        Debug.Log("Disparando... " + Time.time);
        disparando.gameObject.SetActive(true);

        //yield on a new YieldInstruction that waits for 5 seconds.
        yield return new WaitForSeconds(2);

        //After we have waited 5 seconds print the time again.
        Debug.Log("Alto el fuego! " + Time.time);
        disparando.gameObject.SetActive(false);
    }

    private IEnumerator DisableCollision()
    {
        BoxCollider2D platformCollider = oneWayPlat.GetComponent<BoxCollider2D>();

        Physics2D.IgnoreCollision(playerCollider, platformCollider);
        yield return new WaitForSeconds(0.25f);
        Physics2D.IgnoreCollision(playerCollider, platformCollider, false);
    }

}





//free assets: https://craftpix.net/freebies/page/5/


//video interesante: https://www.youtube.com/watch?v=LNLVOjbrQj4https://www.youtube.com/watch?v=LNLVOjbrQj4
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimientoJugador : MonoBehaviour
{

    public GameObject personaje;
    public GameObject disparando;

    Rigidbody2D rb_Disparando;

    public GameObject oneWayPlat;    //plataforma unidireccional
    //[SerializeField] private PolygonCollider2D playerCollider;
    [SerializeField] private BoxCollider2D playerCollider;

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

        float move = Input.GetAxisRaw("Horizontal");
        rb_Disparando.velocity = new Vector2(move * 5f, rb_Disparando.velocity.y);

        rb_Disparando.gameObject.transform.position =
            personaje.gameObject.GetComponent<Rigidbody2D>().transform.position;

        if (move < 0 && facingRight)    //si al pulsar Izq. est� mirando a la derecha, mirar IZQUIERDA
        {
            flip();
        }
        else if (move > 0 && !facingRight)    //si al pulsar Der. est� mirando a la izquierda, mirar DERECHA
        {
            flip();
        }

        if (Input.GetKeyDown(KeyCode.S))
        {
            if (oneWayPlat != null)
            {
                StartCoroutine(DisableCollision());
            }
        }

    }

    void flip()
    {
        facingRight = !facingRight; //cambiar el estado de la variable facingRight
        rb_Disparando.transform.Rotate(0f, 180f, 0f);
    }


    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.transform.tag == "ground")
        {

        }
        else if (collision.transform.tag == "OneWayPlatform")
        {
            oneWayPlat = collision.gameObject;
        }
        else if (collision.transform.tag == "otro")
        {
            gameObject.GetComponent<Rigidbody2D>().transform.position = new Vector3(-45.8f, 24.7f, 0);
            //Application.Quit();
        }

    }

    private void OnCollisionExit2D(Collision2D collision)
    {
        if (collision.transform.tag == "ground")
        {

        }
        else if (collision.transform.tag == "OneWayPlatform")
        {
            oneWayPlat = null;
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

        //if (Input.GetKeyDown(KeyCode.W))
        if (Input.GetKeyDown(KeyCode.W))
        {
            gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(0, 8f));
        }

        //if (Input.GetKeyDown(KeyCode.S))
        //{
        //    if (oneWayPlat != null)
        //    {
        //        StartCoroutine(DisableCollision());
        //    }
        //}


        //disparar
        if (Input.GetKeyDown(KeyCode.F))
        {
            personaje.gameObject.SetActive(false);  //desactivar personaje
            //animaci�n de disparos en la misma posici�n que est� el personaje
            disparando.gameObject.transform.position = personaje.gameObject.GetComponent<Rigidbody2D>().transform.position;

            disparando.gameObject.SetActive(true);
            Invoke(nameof(disp), 1.0f);
        }

        //lanzar_Granadas
        if (Input.GetKeyDown(KeyCode.R))
        {
            //activar alg�n escudo o alg�n tipo de habilidad


            //personaje.gameObject.SetActive(false);  //desactivar personaje
        }

    }


    void disp()
    {
        //desactivar disparos
        disparando.gameObject.SetActive(false);
        //activar personaje
        personaje.gameObject.SetActive(true);
    }


    IEnumerator estado_Disparando()
    {
        Debug.Log("Disparando... " + Time.time);
        disparando.gameObject.SetActive(true);

        yield return new WaitForSeconds(2);

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
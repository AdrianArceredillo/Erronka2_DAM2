using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class MovimientoJugador : MonoBehaviour
{
    
    public GameObject personaje;
    public GameObject disparando;

    Rigidbody2D rb_Disparando;

    //public GameObject oneWayPlat;    //plataforma unidireccional
    private GameObject oneWayPlat;    //plataforma unidireccional
    private GameObject oneWayFence;
    private GameObject oneWayPlat_Fence;

    //[SerializeField] private PolygonCollider2D playerCollider;
    [SerializeField] private BoxCollider2D playerCollider;

    bool facingRight = true;
    public Text puntuacion;         //texto que indica la puntuación

    // Start is called before the first frame update
    void Start()
    {
        puntuacion.text = "0";
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

        if (move < 0 && facingRight)    //si al pulsar Izq. está mirando a la derecha, mirar IZQUIERDA
        {
            flip();
        }
        else if (move > 0 && !facingRight)    //si al pulsar Der. está mirando a la izquierda, mirar DERECHA
        {
            flip();
        }

        if (Input.GetKeyDown(KeyCode.S))
        {
            if (oneWayPlat != null)
            {
                StartCoroutine(DisableCollision());
            }

            if (oneWayFence != null)
            {
                StartCoroutine(DisableCollisionF());
            }

            if (oneWayPlat_Fence != null)
            {
                StartCoroutine(DisableCollision_PF());
            }
            //oneWayPlat_Fence

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
        else if (collision.transform.tag == "fence")
        {
            //oneWayPlat = collision.gameObject;
            oneWayFence = collision.gameObject;

        }
        else if (collision.transform.tag == "plat_fence")
        {
            //oneWayPlat = collision.gameObject;
            oneWayPlat_Fence = collision.gameObject;

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
        else if (collision.transform.tag == "fence")
        {
            oneWayFence = null;
        }
        else if (collision.transform.tag == "plat_fence")
        {
            oneWayPlat_Fence = null;
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
            gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(0, 15f));
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
            //animación de disparos en la misma posición que está el personaje
            disparando.gameObject.transform.position = personaje.gameObject.GetComponent<Rigidbody2D>().transform.position;

            disparando.gameObject.SetActive(true);
            Invoke(nameof(disp), 1.0f);
        }

        //lanzar_Granadas
        if (Input.GetKeyDown(KeyCode.R))
        {
            //activar algún escudo o algún tipo de habilidad


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

    private IEnumerator DisableCollisionF()
    {
        PolygonCollider2D fenceCollider = oneWayFence.GetComponent<PolygonCollider2D>();

        Physics2D.IgnoreCollision(playerCollider, fenceCollider);
        yield return new WaitForSeconds(0.25f);
        Physics2D.IgnoreCollision(playerCollider, fenceCollider, false);
    }

    private IEnumerator DisableCollision_PF()
    {
        PolygonCollider2D plat_fenceCollider = oneWayPlat_Fence.GetComponent<PolygonCollider2D>();

        Physics2D.IgnoreCollision(playerCollider, plat_fenceCollider);
        yield return new WaitForSeconds(0.25f);
        Physics2D.IgnoreCollision(playerCollider, plat_fenceCollider, false);
    }

}





//free assets: https://craftpix.net/freebies/page/5/


//video interesante: https://www.youtube.com/watch?v=LNLVOjbrQj4https://www.youtube.com/watch?v=LNLVOjbrQj4
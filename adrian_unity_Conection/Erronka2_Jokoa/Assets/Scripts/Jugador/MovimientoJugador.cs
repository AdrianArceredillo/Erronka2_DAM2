using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimientoJugador : MonoBehaviour
{

    public GameObject disparo;
    public GameObject personaje;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        movimientosPlayer();
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


        //Input.GetKeyDown(KeyCode.W)
        if (Input.GetKey(KeyCode.A))
        {
            gameObject.GetComponent<Rigidbody2D>().AddForce(new Vector2(-25f * Time.deltaTime, 0));
            //gameObject.GetComponent<Rigidbody2D>().transform.position = new Vector2(gameObject.transform.position.x - 20f * Time.deltaTime, 5);
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

        }


        //disparar
        if (Input.GetKeyDown(KeyCode.F))
        {
            //disparo.gameObject.SetActive(true);
            //Invoke(nameof(estado_Disparando),0.0f);



            personaje.gameObject.SetActive(false);  //desactivar personaje
            //animación de disparos en la misma posición que está el personaje
            disparo.gameObject.transform.position = personaje.gameObject.GetComponent<Rigidbody2D>().transform.position;

            disparo.gameObject.SetActive(true);
            Invoke(nameof(disp),1.0f);
        }
    }


    void disp()
    {
        //desactivar disparos
        disparo.gameObject.SetActive(false);
        //activar personaje
        personaje.gameObject.SetActive(true);
    }

    IEnumerator estado_Disparando()
    {
        //Print the time of when the function is first called.
        Debug.Log("Disparando... " + Time.time);
        disparo.gameObject.SetActive(true);

        //yield on a new YieldInstruction that waits for 5 seconds.
        yield return new WaitForSeconds(2);

        //After we have waited 5 seconds print the time again.
        Debug.Log("Alto el fuego! " + Time.time);
        disparo.gameObject.SetActive(false);
    }

}



//free assets: https://craftpix.net/freebies/page/5/
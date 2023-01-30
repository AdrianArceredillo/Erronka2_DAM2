using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimientoJugador : MonoBehaviour
{
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

    }


}

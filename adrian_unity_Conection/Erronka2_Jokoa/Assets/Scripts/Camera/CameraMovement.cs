using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraMovement : MonoBehaviour
{

    public GameObject Personaje; //objeto que seguirá la cámara

    void Update()
    {
        if (Personaje == null)
        {
            return;
        }
        //la camara siga siempre al jugador tanto por X como por Y
        Vector3 position = transform.position;
        position.x = Personaje.transform.position.x; // sigue al jugador por el eje x
        //position.y = Personaje.transform.position.y; // sigue al jugador por el eje y
        transform.position = position;
    }
}



//https://www.youtube.com/watch?v=nBZuslCbWbU
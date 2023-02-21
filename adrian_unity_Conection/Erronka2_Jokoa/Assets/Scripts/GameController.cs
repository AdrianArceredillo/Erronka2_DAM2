using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class GameController : MonoBehaviour
{
    public Text usuarioText;    //leer texto y posteriormente enviarlo a la siguiente escena
    public Text textoPlaceholder; //texto del placeholder


    private void Start()
    {
        //guardar el contenido que hemos leído -> nombre del jugador
        usuarioText.text = StateNameController.usuario;
    }

    /*
    Comprobar que cuando el usuario pulse el botón para ir al juego, se 
    haya especificado un nombre de usuario/jugador.
    */
    public void comprobarUsuario()
    {
        if (usuarioText.text == "")
        {
            usuarioText.color = Color.red;
            textoPlaceholder.color = Color.red;
        }
        else
        {
            usuarioText.text = StateNameController.usuario;
        }
    }

}

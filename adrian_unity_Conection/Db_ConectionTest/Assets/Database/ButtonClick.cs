using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;



public class ButtonClick : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        Button button = gameObject.GetComponent<Button>();
        //button.onClick.AddListener(Click);
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    
    public void Click(InsertInto insertInto) //public void Click(string user, int puntuazioa, string data)
    {
        Debug.Log("The button is clicked! ");        
        InsertInto partida_nueva = new InsertInto(
            insertInto.getUser(), 
            insertInto.getPuntuazioa(), 
            insertInto.getData()
            );  //InsertInto partida_nueva = new InsertInto(user, puntuazioa, data);

    }


    public void prueba_RecogerDatosTexto(string user, float puntuazioa, string data)
    {

    }


}

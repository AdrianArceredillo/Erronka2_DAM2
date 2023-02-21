using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class BloodEffect : MonoBehaviour
{

    public Image bloodEffect_image;     //imagen efecto de sangrado

    private float r;
    private float g;
    private float b;
    private float a;

    void Start()
    {
        r = bloodEffect_image.color.r;
        g = bloodEffect_image.color.g;
        b = bloodEffect_image.color.b;
        a = bloodEffect_image.color.a;
    }

    void Update()
    {
        
    }


    private void ChangeColor()
    {
        Color c = new Color(r, g, b, a);
        bloodEffect_image.color = c;
    }

}

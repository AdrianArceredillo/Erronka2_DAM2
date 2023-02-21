using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Environment : MonoBehaviour
{

    //public GameObject front;
    public GameObject center;
    public GameObject back;

    public float environmentVelocity = 15.0f;

    public float centerFactor;
    public float backFactor;

    //public Transform start;
    //public Transform end;

    public List<GameObject> props;



    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        //ManageMovement();
        ManageParallax();
        //ManageSpawnCircle();
    }


    //void ManageMovement()
    //{
    //    front.transform.position = new Vector3(
    //        front.transform.position.x - environmentVelocity * Time.deltaTime,
    //        front.transform.position.y,
    //        front.transform.position.z);
    //}


    void ManageParallax()
    {
        //center
        center.transform.position = new Vector3(
            center.transform.position.x - (environmentVelocity * centerFactor) * Time.deltaTime,
            center.transform.position.y,
            center.transform.position.z);
        //back
        back.transform.position = new Vector3(
            back.transform.position.x - (environmentVelocity * backFactor) * Time.deltaTime,
            back.transform.position.y,
            back.transform.position.z);
    }


    //void ManageSpawnCircle()
    //{
    //    foreach (GameObject prop in props)
    //    {
    //        if (prop.transform.position.x <= end.position.x)
    //        {
    //            prop.transform.position = new Vector3
    //                (start.position.x, 
    //                prop.transform.position.y, 
    //                prop.transform.position.z);
    //        }
    //    }
    //}




}

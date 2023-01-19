package com.dambi.restapi.pojoak;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "langileak")
public class Langileak {

    List<Langilea> langileak;

    public List<Langilea> getLangileak() {
        return this.langileak;
    }

    /**
     * element that is going to be marshaled in the xml
     */
    @XmlElement(name = "Langilea")
    public void setLangileak(List<Langilea> langileak) {
        this.langileak = langileak;
    }

    /**
     * This method is not used by jaxb, just used for business reasons. In the case
     * that this class
     * would be generated using xml schemas definitions, this method has to be added
     * to the
     * generated class or to some helper or util one
     * 
     * @param Langilea
     */
    public void add(Langilea langilea) {
        if (this.langileak == null) {
            this.langileak = new ArrayList<Langilea>();
        }
        this.langileak.add(langilea);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Langilea langileBakoitza : this.langileak) {
            str.append(langileBakoitza.toString());
        }
        return str.toString();
    }
}

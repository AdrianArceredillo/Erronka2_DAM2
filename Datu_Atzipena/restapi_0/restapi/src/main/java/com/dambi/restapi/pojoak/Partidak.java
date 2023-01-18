package com.dambi.restapi.pojoak;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Partidak")
public class Partidak {

    List<Partida> partidak;

    public List<Partida> getPartidak() {
        return this.partidak;
    }

    /**
     * element that is going to be marshaled in the xml
     */
    @XmlElement(name = "Partida")
    public void setPartidak(List<Partida> partidak) {
        this.partidak = partidak;
    }

    /**
     * This method is not used by jaxb, just used for business reasons. In the case
     * that this class
     * would be generated using xml schemas definitions, this method has to be added
     * to the
     * generated class or to some helper or util one
     * 
     * @param Partida
     */
    public void add(Partida partida) {
        if (this.partidak == null) {
            this.partidak = new ArrayList<Partida>();
        }
        this.partidak.add(partida);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Partida partidaBakoitza : this.partidak) {
            str.append(partidaBakoitza.toString());
        }
        return str.toString();
    }
}

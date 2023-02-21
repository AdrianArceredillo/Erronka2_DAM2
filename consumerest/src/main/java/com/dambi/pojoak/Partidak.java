package com.dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Partidak")
public class Partidak {

    List<Partida> partidak;

    public List<Partida> getPartidak() {
        return partidak;
    }

    @XmlElement(name = "Partida")
    public void setPartidak(List<Partida> partidak) {
        this.partidak = partidak;
    }

    public void add(Partida partida) {
        if (this.partidak == null) {
            this.partidak = new ArrayList<Partida>();
        }
        this.partidak.add(partida);

    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Partida p : this.partidak) {
            str.append(p.toString());
            str.append("\n");
        }
        return str.toString();
    }

}
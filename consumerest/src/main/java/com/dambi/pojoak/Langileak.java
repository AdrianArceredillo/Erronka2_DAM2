package com.dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Langileak")
public class Langileak {

    List<Langilea> langileak;

    public List<Langilea> getLangileak() {
        return langileak;
    }

    @XmlElement(name = "Langilea")
    public void setLangileak(List<Langilea> langileak) {
        this.langileak = langileak;
    }

    public void add(Langilea langilea) {
        if (this.langileak == null) {
            this.langileak = new ArrayList<Langilea>();
        }
        this.langileak.add(langilea);

    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Langilea l : this.langileak) {
            str.append(l.toString());
            str.append("\n");
        }
        return str.toString();
    }

}
package tup.lciii.modelo;

import tup.lciii.modelo.enums.Combinacion;
import tup.lciii.modelo.enums.Palo;

public class Carta {
    private final Palo palo;
    private final int numero;
    private Combinacion combinacion;


    public Carta(int numero, Palo palo) {
        this.palo = palo;
        this.numero = numero;
        this.combinacion = Combinacion.NO_COMBINADA;
    }

    public Palo getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }

    public Combinacion getCombinacion() {
        return combinacion;
    }

    public void setCombinacion(Combinacion combinacion) {
        this.combinacion = combinacion;
    }

    public void descombinarCarta() {
        this.combinacion = Combinacion.NO_COMBINADA;
    }

    public String combinacionToString(Combinacion combinacion) {
        switch (combinacion) {
            case ESCALERA:
                return "\u001B[32m" + "C Esc";
            case NUMEROS_IGUALES:
                return "\u001B[32m" + "C N°s";
            case NO_COMBINADA:
                return "\u001B[31m" + "NC";
            default:
                return "Error en el tipo de combinacion";
        }
    }
}
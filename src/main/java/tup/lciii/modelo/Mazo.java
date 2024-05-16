package tup.lciii.modelo;

import tup.lciii.modelo.enums.Palo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private final ArrayList<Carta> mazo;

    public Mazo() {
        this.mazo = new ArrayList<>();
    }

    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    /**
     * Obtiene el número de cartas actualmente en el mazo.
     *
     * @return El tamaño del mazo, es decir, el número de cartas.
     */
    public int getMazoLength() {
        return mazo.size();
    }

    /**
     * Agrega una carta al mazo.
     *
     * @param carta La carta que se va a agregar al mazo.
     */
    public void agregarCarta(Carta carta) {
        mazo.add(carta);
    }

    /**
     * Genera un mazo de cartas completo, con todas las combinaciones posibles
     * de valores y palos.
     */
    public void generarMazo() {
        for (Palo palo : Palo.values()) {
            for (int i = 1; i <= 12; i++) {
                mazo.add(new Carta(i, palo));
            }
        }
    }

    /**
     * Obtiene una nueva carta del mazo y la elimina del mismo.
     */
    public Carta getProximaCarta() {
        return mazo.remove(0);
    }

    /**
     * Mezcla las cartas en el mazo de manera aleatoria.
     * @see java.util.Collections#shuffle(List)
     */
    public void mezclarMazo() {
        Collections.shuffle(mazo);
    }

    /**
     * Reparte siete cartas al jugador especificado.
     *
     * @param jugador El jugador al cual se le repartirán las cartas.
     */

    public void repartirCartas(Jugador jugador) {
        //TODO
    }

    /**
     * Descombinar todas las cartas en el mazo.
     * Esto implica restablecer el estado de todas las cartas en el mazo a su estado original.
     * @see Carta#descombinarCarta()
     */
    public void descombinarTodasLasCartas() {
        //TODO
    }
}

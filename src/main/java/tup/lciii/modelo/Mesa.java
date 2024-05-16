package tup.lciii.modelo;

import java.util.ArrayList;

public class Mesa {
    private final ArrayList<Carta> mesa;

    public Mesa() {
        this.mesa = new ArrayList<>();
    }

    public ArrayList<Carta> getMesa() {
        return mesa;
    }

    public Carta getUltimaCartaMesa() {
        return mesa.get(mesa.size() - 1);
    }

    /**
     * Este método agrega una carta a la mesa.
     *
     * @param carta La carta que se desea agregar a la mesa.
     */
    public void agregarCartaALaMesa(Carta carta) {
        mesa.add(carta);
    }

    /**
     * Este método coloca una carta inicial en la mesa, sacándola del mazo.
     *
     * @param mazo El mazo del cual se tomará la carta inicial.
     */
    public void cartaInicialMesa(Mazo mazo) {
        int indice = (int) (Math.random() * mazo.getMazoLength());
        mesa.add(mazo.getMazo().get(indice));
        mazo.getMazo().remove(indice);
    }

    /**
     * Este método elimina la última carta de la mesa.
     */
    public void quitarCartaDeLaMesa() {
        //TODO
    }

    /**
     * Este método devuelve todas las cartas de la mesa al mazo, dejando la mesa vacía.
     * @see Mazo#agregarCarta(Carta)
     * @param mazo El mazo al cual se devolverán las cartas.
     */

    public void vaciarMesa(Mazo mazo) {
        for (Carta carta : mesa) {
            mazo.agregarCarta(carta);
        }
        mesa.clear();
    }
}
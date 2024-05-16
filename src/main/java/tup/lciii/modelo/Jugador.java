package tup.lciii.modelo;

import tup.lciii.modelo.enums.Estado;

public class Jugador {
    private final String nombre;
    private boolean esTurno;
    private final Mano mano;
    private int puntos;
    private Estado estado;

    public Jugador(String nombre, boolean esTurno) {
        this.nombre = nombre;
        this.esTurno = esTurno;
        this.mano = new Mano();
        this.puntos = 0;
        this.estado = Estado.JUGANDO;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getEsTurno() {
        return esTurno;
    }

    public Mano getMano() {
        return mano;
    }

    public int getPuntos() {
        return puntos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEsTurno(boolean esTurno) {
        this.esTurno = esTurno;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Este método permite a un jugador tomar una carta al azar del mazo y agregarla a su mano.
     *
     * @param mazo El mazo del juego del cual se tomará la carta.
     * @return true si se pudo tomar una carta del mazo con éxito, false si el mazo está vacío.
     */
    public Boolean agarrarCartaDelMazo(Mazo mazo) {
        if (!mazo.getMazo().isEmpty()) {
            mano.agregarCarta(mazo.getProximaCarta());
        } else {
            return false;
        }
        return true;
    }

    /**
     * Este método permite a un jugador tomar la última carta de la mesa y agregarla a su mano.
     *
     * @param mesa La mesa del juego de la cual se tomará la carta.
     */
    public void agarrarCartaDeLaMesa(Mesa mesa) {
        mano.agregarCarta(mesa.getMesa().get(mesa.getMesa().size() - 1));
        mesa.quitarCartaDeLaMesa();
    }
}

package tup.lciii.modelo;

import tup.lciii.modelo.enums.Estado;
import tup.lciii.modelo.enums.Palo;

import java.util.ArrayList;

public class Juego {
    private final Mazo mazo;
    private final ArrayList<Jugador> jugadores;
    private final Mesa mesa;

    private final int cantidadJugadores;

    public Juego() {
        this.mazo = new Mazo();
        this.jugadores = new ArrayList<>();
        this.mesa = new Mesa();
        this.cantidadJugadores = 2;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public int getPuntajeMaximo() {
        //TODO
    }

    /**
     * Inicia los jugadores del juego con los nombres proporcionados.
     * Uno de los jugadores tiene que inicializarse con esTurno en true.
     * @param nombresDeJugadores Una lista de nombres de jugadores.
     */
    public void iniciarJugadores(ArrayList<String> nombresDeJugadores) {
        for (String nombre : nombresDeJugadores) {
            if (jugadores.isEmpty()) {
                jugadores.add(new Jugador(nombre, true));
            } else {
                jugadores.add(new Jugador(nombre, false));
            }
        }
    }

    public void iniciarMazo() {
        mazo.generarMazo();
    }

    public void iniciarMesa() {
        mesa.cartaInicialMesa(mazo);
    }

    /**
     * Mezcla el mazo de cartas y reparte las cartas a cada jugador.
     */
    public void mezclarMazoYrepartirCartas() {
        mazo.mezclarMazo();
        for (Jugador jugador : jugadores) {
            mazo.repartirCartas(jugador);
        }
    }

    /**
     * Revisa y devuelve el jugador que tiene el turno activo.
     *
     * @param jugadores Una lista de jugadores.
     * @return El jugador que tiene el turno activo.
     */
    public Jugador revisarTurno(ArrayList<Jugador> jugadores) {
        //TODO
    }

    /**
     * Revisa y devuelve el jugador que no tiene el turno activo.
     *
     * @param jugadores Una lista de jugadores.
     * @return El jugador que no tiene el turno activo, o null si todos los jugadores tienen el turno activo.
     */
    public Jugador revisarNoTurno(ArrayList<Jugador> jugadores) {
        Jugador noTurnoJugador = null;
        for (Jugador jugador : jugadores) {
            if (!jugador.getEsTurno()) {
                noTurnoJugador = jugador;
            }
        }
        return noTurnoJugador;
    }

    /**
     * Revisa si hay un ganador o si algún jugador ha alcanzado el puntaje máximo.
     *
     * @param jugadores Una lista de jugadores.
     * @return true si hay un ganador o si algún jugador ha alcanzado el puntaje máximo, false de lo contrario.
     */
    public Boolean revisarGanador(ArrayList<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            if (jugador.getEstado() == Estado.GANADOR) {
                return true;
            }
            if (jugador.getPuntos() >= this.getPuntajeMaximo()) {
                jugador.setEstado(Estado.PERDEDOR);
                return true;
            }
        }
        return false;
    }

    /**
     * Revisa si el jugador actual puede "cortar" durante su turno.
     *
     * @param jugadorActual El jugador cuya capacidad para cortar se está revisando.
     *                      Para cortar el valor de la carta que le queda debe ser menor a 5.
     * @return true si el jugador puede cortar, false de lo contrario.
     */
    public Boolean revisarSiCorta(Jugador jugadorActual) {
        boolean corta = false;
        Mano mano = jugadorActual.getMano();

        ArrayList<Carta> noCombinaciones = mano.getNoCombinaciones();

        if (noCombinaciones.size() <= 1) {
            if (noCombinaciones.isEmpty()) {
                corta = true;
            } else {
                if (noCombinaciones.get(0).getNumero() < 5) {
                    corta = true;
                }
            }
        }
        return corta;
    }

    /**
     * Obtiene al jugador que ha ganado el juego.
     *
     * @return El jugador que ha ganado el juego, o null si no hay un ganador.
     */
    public Jugador obtenerGanador() {
        for (Jugador jugador : jugadores) {
            if (jugador.getEstado() == Estado.GANADOR) {
                return jugador;
            }
        }
        return null;
    }

    public Boolean validarMenuJuegoOSalgo(String opcion) {
        return opcion.equals("1") || opcion.equals("2");
    }

    public Boolean validarMenuOpcionesDeLevantado(String opcion) {
        return opcion.equals("1") || opcion.equals("2");
    }

    public Boolean validarMenuBucleDeCombinaciones(String opcion) {
        return opcion.equals("2");
    }

    public Boolean validarMenuOpcionCortar(String opcion) {
        return opcion.equals("0");
    }

    public Boolean validarMenuCantidadDeCartasPorCombinar(int numero) {
        return numero >= 3 && numero <= 7;
    }

    /**
     * Valida y devuelve la carta ingresada por el jugador actual.
     *
     * @param jugadorActual El jugador que está ingresando la carta.
     * @param carta         La cadena que representa la carta ingresada por el jugador (por ejemplo, "7O" para siete de oro).
     * @return La carta validada si es válida y está presente en la mano del jugador, o null si la carta es inválida o no está en la mano del jugador.
     */
    public Carta validarIngresoCarta(Jugador jugadorActual, String carta) {
        if (carta.length() == 2 || carta.length() == 3) {
            String numeroString;
            String paloString;
            if (carta.length() == 3) {
                numeroString = carta.substring(0, 2);
                paloString = carta.substring(2, 3).toUpperCase();
            } else {
                numeroString = carta.substring(0, 1);
                paloString = carta.substring(1, 2).toUpperCase();
            }

            try {
                int numero = Integer.parseInt(numeroString);

                if (numero <= 12) {
                    switch (paloString) {
                        case "O":
                            paloString = "ORO";
                            break;
                        case "C":
                            paloString = "COPA";
                            break;
                        case "E":
                            paloString = "ESPADA";
                            break;
                        case "B":
                            paloString = "BASTO";
                            break;
                        default:
                            return null;
                    }
                    Palo palo = Palo.valueOf(paloString);

                    return jugadorActual.getMano().buscarCartaEnMano(numero, palo);
                } else {
                    return null;
                }
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
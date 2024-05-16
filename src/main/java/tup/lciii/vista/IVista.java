package tup.lciii.vista;

import tup.lciii.modelo.Carta;
import tup.lciii.modelo.Jugador;
import tup.lciii.modelo.Mano;
import tup.lciii.modelo.Mesa;

import java.util.ArrayList;

public interface IVista {
    String mostrarMenuJuegoOSalgo();

    void mostrarMesa(Mesa mesa);

    void mostrarJugadores(ArrayList<Jugador> jugadores);

    void mostrarCarta(Carta carta);

    String mostrarCartaString(Carta carta);

    void mostrarTurnoDe(Jugador jugador);

    void mostrarMano(Jugador jugadorActual, Mano mano, String titulo);

    String mostrarOpcionesDeLevantado();

    String mostrarMenuBucleDeCombinaciones();

    String mostrarMenuCombinaciones(Jugador jugadorActual);

    void mostrarMensajeNoCombinaciones();

    void mostrarMensajeCombinacionEscalera();

    void mostrarMensajeCombinacionNumerosIguales();

    void mostrarMensajeNoEsEscalera();

    void mostrarMensajeNoEsNumerosIguales();

    String inputCarta(Jugador jugadorActual);

    int inputNumeroDeCartas();

    void opcionInvalida();

    void mostrarMensajeDejeUnaCarta();

    String mostrarMenuCortar();

    void mostrarMensajeNoHayCartasEnElMazo();

    ArrayList<String> mostrarMensajeCantidadJugadores(int cantidadJugadores);

    void mostrarMensajeInfoPerder();

    void mostrarPuntajes(ArrayList<Jugador> jugadores);

    void mostrarGanador(Jugador jugador);

    void mostrarMensajeNuevaRonda();
}

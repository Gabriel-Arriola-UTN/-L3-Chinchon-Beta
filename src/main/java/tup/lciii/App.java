package tup.lciii;

import tup.lciii.controlador.Controlador;
import tup.lciii.modelo.Juego;
import tup.lciii.vista.VistaConsola;

public class App {
    public static void main(String[] args) {
        System.out.println(">>>>> 1er Parcial LCIII - TUP - 2024 <<<<<");

        VistaConsola vista = new VistaConsola();
        Juego juego = new Juego();
        Controlador controlador = new Controlador(vista, juego);

        controlador.cicloDeJuego();
    }
}


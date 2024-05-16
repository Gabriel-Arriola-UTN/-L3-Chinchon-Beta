package tup.lciii.modelo;

import tup.lciii.modelo.enums.Combinacion;
import tup.lciii.modelo.enums.Estado;
import tup.lciii.modelo.enums.Palo;

import java.util.ArrayList;

public class Mano {
    private ArrayList<Carta> mano;
    private final ArrayList<ArrayList<Carta>> combinacionesEscalera;
    private final ArrayList<ArrayList<Carta>> combinacionesNumerosIguales;

    public Mano() {
        mano = new ArrayList<>();
        combinacionesEscalera = new ArrayList<>();
        combinacionesNumerosIguales = new ArrayList<>();
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public ArrayList<ArrayList<Carta>> getCombinacionesEscalera() {
        return combinacionesEscalera;
    }

    public ArrayList<ArrayList<Carta>> getCombinacionesNumerosIguales() {
        return combinacionesNumerosIguales;
    }

    public ArrayList<Carta> getNoCombinaciones() {
        ArrayList<Carta> noCombinaciones = new ArrayList<>();
        for (Carta carta : mano) {
            if (carta.getCombinacion() == Combinacion.NO_COMBINADA) {
                noCombinaciones.add(carta);
            }
        }
        return noCombinaciones;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public void agregarCarta(Carta carta) {
        mano.add(carta);
    }

    /**
     * Este método establece las combinaciones de cartas como una escalera y las agrega a la lista de combinaciones de escalera.
     *
     * @param combinacion La combinación de cartas que se desea establecer como una escalera.
     */
    public void setCombinacionesEscalera(ArrayList<Carta> combinacion) {
        for (Carta carta : combinacion) {
            carta.setCombinacion(Combinacion.ESCALERA);
        }
        this.combinacionesEscalera.add(combinacion);
    }

    public void setCombinacionesNumerosIguales(ArrayList<Carta> combinacion) {
        for (Carta carta : combinacion) {
            carta.setCombinacion(Combinacion.NUMEROS_IGUALES);
        }
        this.combinacionesNumerosIguales.add(combinacion);
    }

    /**
     * Este método permite al jugador jugar una carta, eliminándola de su mano y, si corresponde, de las combinaciones existentes.
     *
     * @param cartaPorJugar La carta que el jugador desea jugar.
     */
    public void jugarCarta(Carta cartaPorJugar) {
        if (cartaPorJugar.getCombinacion() == Combinacion.ESCALERA) {
            for (ArrayList<Carta> combinacion : combinacionesEscalera) {
                combinacion.remove(cartaPorJugar);
            }
        }
        if (cartaPorJugar.getCombinacion() == Combinacion.NUMEROS_IGUALES) {
            for (ArrayList<Carta> combinacion : combinacionesNumerosIguales) {
                combinacion.remove(cartaPorJugar);
            }
        }
        cartaPorJugar.setCombinacion(Combinacion.NO_COMBINADA);
        mano.remove(cartaPorJugar);
    }

    public void revisarSiSeDescombino() {
        ArrayList<ArrayList<Carta>> combinacionesEscalera = getCombinacionesEscalera();
        ArrayList<ArrayList<Carta>> combinacionesNumerosIguales = getCombinacionesNumerosIguales();

        //Si el largo de combinacionesEscalera.size < 3, poner en NO_COMBINADA
        for (ArrayList<Carta> combinacion : combinacionesEscalera) {
            if (combinacion.size() < 3) {
                for (Carta carta : combinacion) {
                    carta.descombinarCarta();
                }
            }
        }
        //Si el largo de combinacionesNumerosIguales.size < 3, poner en NO_COMBINADA
        for (ArrayList<Carta> combinacion : combinacionesNumerosIguales) {
            if (combinacion.size() < 3) {
                for (Carta carta : combinacion) {
                    carta.descombinarCarta();
                }
            }
        }
    }

    /**
     * Este método busca una carta específica en la mano del jugador.
     *
     * @param numero El número de la carta que se busca.
     * @param palo   El palo de la carta que se busca.
     * @return La carta encontrada, o null si la carta no está en la mano del jugador.
     */
    public Carta buscarCartaEnMano(int numero, Palo palo) {
        //TODO
    }

    /**
     * Este método verifica si la mano dada representa un Chinchón, es decir, si todas las cartas forman una escalera
     * (teniendo en cuenta su palo).
     *
     * @param mano La mano del jugador que se desea verificar.
     * @return true si la mano representa un Chinchón, false de lo contrario.
     */
    public Boolean esChinchon(Mano mano) {
        mano.ordenarPorPaloYNumero(mano);
        return this.combinacionEscalera(mano.getMano());
    }

    /**
     * Este método verifica si las cartas dadas forman una combinación de escalera del mismo palo.
     *
     * @param cartasPorCombinar La lista de cartas que se desea verificar para una posible escalera.
     * @return true si las cartas forman una escalera del mismo palo, false de lo contrario o si hay menos de 3 cartas.
     */
    public Boolean combinacionEscalera(ArrayList<Carta> cartasPorCombinar) {
        if (cartasPorCombinar.size() >= 3) {
            boolean escalera = true;
            Carta cartaInicial = cartasPorCombinar.get(0);
            Palo palo = cartaInicial.getPalo();
            for (int i = 1; i < cartasPorCombinar.size(); i++) {
                if (cartasPorCombinar.get(i).getPalo() != palo) {
                    escalera = false;
                }
                if (cartasPorCombinar.get(i).getNumero() != cartaInicial.getNumero() + 1) {
                    escalera = false;
                }
                cartaInicial = cartasPorCombinar.get(i);
            }
            return escalera;
        }
        return false;
    }

    /**
     * Este método verifica si las cartas dadas forman una combinación de números iguales.
     *
     * @param cartasPorCombinar La lista de cartas que se desea verificar para una posible combinación de números iguales.
     * @return true si las cartas tienen los mismos números, false de lo contrario o si hay más de 4 cartas.
     */
    public Boolean combinacionNumerosIguales(ArrayList<Carta> cartasPorCombinar) {
        if (cartasPorCombinar.size() <= 4) {
            boolean numerosIguales = true;
            Carta cartaInicial = cartasPorCombinar.get(0);
            for (Carta carta : cartasPorCombinar) {
                if (carta.getNumero() != cartaInicial.getNumero()) {
                    numerosIguales = false;
                    cartaInicial = carta;
                }
            }
            return numerosIguales;
        }
        return false;
    }

    /**
     * Este método ordena las cartas en la mano del jugador primero por palo y luego por número.
     *
     * @param mano La mano del jugador que se desea ordenar.
     */
    public void ordenarPorPaloYNumero(Mano mano) {
        ArrayList<Carta> manoOrdenada = new ArrayList<>();
        for (Palo palo : Palo.values()) {
            for (int i = 1; i <= 12; i++) {
                for (Carta carta : mano.getMano()) {
                    if (carta.getNumero() == i && carta.getPalo() == palo) {
                        manoOrdenada.add(carta);
                    }
                }
            }
        }
        mano.setMano(manoOrdenada);
    }

    /**
     * Este método devuelve todas las cartas de la mano del jugador al mazo, dejando la mano vacía.
     *
     * @param mazo El mazo al cual se devolverán las cartas.
     */
    public void vaciarMano(Mazo mazo) {
        for (Carta carta : mano) {
            mazo.agregarCarta(carta);
        }
        mano.clear();
    }

    /**
     * Este método establece el puntaje del jugador basado en las combinaciones de cartas en su mano y en la mesa.
     *
     * @param jugador El jugador al cual se le establecerá el puntaje.
     */
    public void setearPuntaje(Jugador jugador) {
        int lengthCombinaciones = this.getCombinacionesEscalera().size() + this.getCombinacionesNumerosIguales().size();
        boolean combinacionesDeATres = false;
        boolean combinacionesDeACuatro = false;
        if (lengthCombinaciones == 2) {
            for (ArrayList<Carta> combinacion : this.getCombinacionesEscalera()) {
                if (combinacion.size() == 3) {
                    combinacionesDeATres = true;
                }
                if (combinacion.size() == 4) {
                    combinacionesDeACuatro = true;
                }
            }
            for (ArrayList<Carta> combinacion : this.getCombinacionesNumerosIguales()) {
                if (combinacion.size() == 3) {
                    combinacionesDeATres = true;
                }
                if (combinacion.size() == 4) {
                    combinacionesDeACuatro = true;
                }
            }
        }
        if (combinacionesDeATres && combinacionesDeACuatro) {
            jugador.setPuntos(jugador.getPuntos() - 10);
        } else if (this.esChinchon(this)) {
            jugador.setEstado(Estado.GANADOR);
        } else {
            for (Carta carta : mano) {
                if (carta.getCombinacion() == Combinacion.NO_COMBINADA) {
                    jugador.setPuntos(jugador.getPuntos() + carta.getNumero());
                }
            }
        }
    }
}

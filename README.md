
# Parcial 1 - "CHINCHON"

Se pide construir una aplicación de consolas en Java que permita a una persona jugar al tradicional juego chinchon.

Cada jugador recibe siete cartas al inicio y el resto se coloca boca abajo en el centro como mazo. El jugador puede 
robar una carta del mazo o tomar la última carta descartada por el jugador anterior. 
El turno termina descartando una carta.

Las combinaciones válidas incluyen:

    Chinchón: consiste en tener todas las cartas en la mano formando combinacion de una escalera completa.
    Escalera: secuencia de tres o más cartas del mismo palo.
    Trío: tres cartas del mismo valor pero de palos diferentes.

El juego continúa hasta que un jugador forma todas sus cartas en combinaciones válidas y decide cortar,
o hasta que se agotan las cartas del mazo. En ese momento, 
se cuentan los puntos de las cartas restantes en la mano de los jugadores, y gana quien tenga menos puntos.

### Flujo del juego
1. La aplicación debe iniciar con un mensaje de bienvenida y pedir si uno quiere salir o jugar.
2. La aplicacion debe pedir el nombre de los dos jugadores.
3. La aplicacion debe mostrar por consola la mano del jugador numero 1 y preguntarle si debe agarrar carta del mazo o mesa.
4. La aplicacion debe mostrar por consola la mano del jugador y preguntarle si desea o no hacer una combinacion.
5. La aplicacion debe cambiar de turno hacia el jugador 2 repitiendo los pasos 4 y 5.
6. La partida termina cuando uno de los jugadores contiene al menos 6 cartas combinadas y desea cortar.
7. Una vez hecho el corte, se suman los puntos para cada jugador y empieza una nueva partida.


## Diagrama
![chinchon.jpg](docs%2Fchinchon.jpg)

## Evaluacion
### La firma del metodo no debe ser cambiada. Es decir, los parametros que recibe y el tipo de dato que devuelve deben mantenerse.
1. Resolver lógica dentro de método quitarCartaDeLaMesa.
2. Resolver lógica dentro de método repartirCartas.
3. Resolver lógica dentro de método buscarCartaEnMano.
4. Resolver lógica dentro de método descombinarTodasLasCartas.
5. Agregar atributo puntajeMaximo en la clase juego e inicializarlo con el valor 100.
6. Resolver lógica dentro de método getPuntajeMaximo.
7. Resolver lógica dentro de método revisarTurno.
8. Realizar unitests de buscarCartaEnMano, quitarCartaDeLaMesa, descombinarTodasLasCartas.

## Ayudas  y recomendaciones
1. Verificar que importemos de import org.junit.jupiter.api en los casos de @Test y Assertions
2. Los tests deben hacerse dentro del paquete src/test/java/tup/lciii/modelo
3. Haciendo crtl + shift + f podemos buscar en todo el proyecto tanto por lo metodos anteriormente explicados, como por TODO.


| Consigna | Puntaje | 
|----------|---------|
| 1        | 10 pts  |
| 2        | 10 pts  |
| 3        | 10 pts  | 
| 4        | 10 pts  | 
| 5        | 10 pts  | 
| 6        | 10 pts  | 
| 7        | 10 pts  | 
| 8        | 30 pts  | 

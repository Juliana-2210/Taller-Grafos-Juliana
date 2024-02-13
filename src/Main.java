public class Main {
    public static void main(String[] args) {
        RedAguaPotable red = new RedAguaPotable();

        Nodo fuente = new Nodo("FuenteDeSuministro");
        Nodo tuberias = new Nodo("Tuberias");
        Nodo valvulas = new Nodo("Valvulas");
        Nodo bombas = new Nodo("Bombas");
        Nodo tanques = new Nodo("Tanques");
        Nodo hogaresNegocios = new Nodo("HogaresYNegocios");

        red.agregarConexion(fuente, tuberias, new Conexion(5));
        red.agregarConexion(tuberias, valvulas, new Conexion(10));
        red.agregarConexion(valvulas, bombas, new Conexion(7));
        red.agregarConexion(bombas, tanques, new Conexion(3));
        red.agregarConexion(tanques, hogaresNegocios, new Conexion(8));

        double distanciaMasCorta = red.calcularRutaMasCorta(fuente, hogaresNegocios);
        System.out.println("La ruta más corta tiene una distancia de: " + distanciaMasCorta+ "Metros");
    }
}
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedAguaPotable {
    private Map<Nodo, Map<Nodo, Conexion>> grafo;

    public RedAguaPotable() {
        grafo = new HashMap<>();
    }

    public void agregarNodo(Nodo nodo) {
        if (!grafo.containsKey(nodo)) {
            grafo.put(nodo, new HashMap<>());
        }
    }

    public void agregarConexion(Nodo nodoOrigen, Nodo nodoDestino, Conexion conexion) {
        agregarNodo(nodoOrigen);
        agregarNodo(nodoDestino);
        grafo.get(nodoOrigen).put(nodoDestino, conexion);
    }

    public double calcularRutaMasCorta(Nodo origen, Nodo destino) {
        Map<Nodo, Double> distancias = new HashMap<>();
        Set<Nodo> visitados = new HashSet<>();

        for (Nodo nodo : grafo.keySet()) {
            distancias.put(nodo, Double.MAX_VALUE);
        }

        distancias.put(origen, 0.0);

        while (true) {
            Nodo nodoActual = null;
            double distanciaMinima = Double.MAX_VALUE;
            for (Nodo nodo : grafo.keySet()) {
                if (!visitados.contains(nodo) && distancias.get(nodo) < distanciaMinima) {
                    nodoActual = nodo;
                    distanciaMinima = distancias.get(nodo);
                }
            }

            if (nodoActual == null) break;

            visitados.add(nodoActual);

            for (Map.Entry<Nodo, Conexion> vecino : grafo.get(nodoActual).entrySet()) {
                double distanciaActual = distancias.get(nodoActual);
                double distanciaNueva = distanciaActual + vecino.getValue().peso;
                if (distanciaNueva < distancias.get(vecino.getKey())) {
                    distancias.put(vecino.getKey(), distanciaNueva);
                }
            }
        }

        return distancias.get(destino);
    }
}

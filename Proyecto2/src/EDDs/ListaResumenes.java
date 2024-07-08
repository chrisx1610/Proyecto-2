/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDDs;

public class ListaResumenes {

    public NodoLista primero;
    public NodoLista ultimo;
    public int tamano;
    public String clave;

    public ListaResumenes() {
        primero = ultimo = null;
        tamano = 0;
        clave = "";
    }

    public void añadirResumen(String titulo, String autores, String resumen, String claves) {
        Resumen nuevoResumen = new Resumen(titulo, autores, resumen, claves);
        NodoLista nuevo = new NodoLista(nuevoResumen);
        if (this.primero == null) {
            this.primero = this.ultimo = nuevo;
        } else {
            this.ultimo.siguiente = nuevo;
            this.ultimo = nuevo;
        }
        this.tamano += 1;
    }

    public Resumen buscarResumen(String titulo) {
        if (this.primero != null) {
            if (this.primero.getDato().getTitulo().toUpperCase().equals(titulo.toUpperCase())) {
                return this.primero.getDato();
            }
            NodoLista aux = this.primero;
            while (aux != null && !aux.getDato().getTitulo().toUpperCase().equals(titulo.toUpperCase())) {
                aux = aux.getSiguiente();
            }
            if (aux != null) {
                return aux.getDato();
            }

        }
        return null;
    }

    public String verTitulos() {
        String titulos = "";
        if (this.primero != null) {
            NodoLista aux = this.primero;
            while (aux != null) {
                titulos += aux.getDato().getTitulo() + ";";
                aux = aux.getSiguiente();
            }
        }
        return titulos;
    }
}

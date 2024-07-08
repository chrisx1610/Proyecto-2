/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDDs;

public class NodoLista {
    public Resumen dato;
    public NodoLista siguiente;

    public NodoLista(Resumen dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Resumen getDato() {
        return dato;
    }

    public void setDato(Resumen dato) {
        this.dato = dato;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
    
}

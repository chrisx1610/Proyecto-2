/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDDs;

import javax.swing.JOptionPane;

public class HashTable {

    public ListaResumenes[] resumenes;
    public int tamano;
    public int cont_resumenes;

    public HashTable() {
        this.tamano = 100;
        this.cont_resumenes = 0;
        this.resumenes = new ListaResumenes[this.tamano];
        for (int i = 0; i < this.tamano; i++) {
            this.resumenes[i] = new ListaResumenes();
        }
    }

    public int hash(String palabra) {
        int hash = 5381;
        for (char c : palabra.toCharArray()) {
            hash = (((hash << 5) + hash) + c)%7;
        }
        return hash % this.tamano;
    }

    public void insertar(String titulo, String autores, String resumen, String claves, String palabra) {
        int hash = this.hash(palabra.toUpperCase());
        ListaResumenes lista = this.resumenes[hash];
        if (palabra.toUpperCase().equals(titulo.toUpperCase()) &&  lista.buscarResumen(titulo) != null) {
//            System.out.println(titulo);
            return;
        }
//        System.out.println("y1i8y");
        if (lista.clave.equals("") || lista.clave.toUpperCase().equals(palabra.toUpperCase())) {
//            System.out.println(palabra);
            lista.añadirResumen(titulo, autores, resumen, claves);
            lista.clave = palabra;
        } else {
            if (!palabra.toUpperCase().equals(titulo.toUpperCase())) {
//                System.out.println(palabra);
                while (!this.resumenes[hash].clave.equals(palabra.toUpperCase()) && !this.resumenes[hash].clave.equals("")) {
                    hash += 1;
                    if (hash == this.tamano) {
                        hash = 0;
                    }
                }
                if(this.resumenes[hash].clave.equals("")){
                    this.resumenes[hash].clave = palabra;
                }
            }
//            System.out.println(palabra);
            this.resumenes[hash].añadirResumen(titulo, autores, resumen, claves);

        }
    }

    public ListaResumenes buscar(String palabra) {
        int hash = this.hash(palabra.toUpperCase());
        ListaResumenes lista = this.resumenes[hash];
        if (lista.buscarResumen(palabra.toUpperCase()) != null || lista.clave.toUpperCase().equals(palabra.toUpperCase())) {
            return lista;
        } else {
            int i = 0;
            while (!this.resumenes[hash].clave.toUpperCase().equals(palabra.toUpperCase())) {
                hash += 1;
                if (hash == this.tamano) {
                    hash = 0;
                }
                if(i == this.tamano + 1){
                    JOptionPane.showMessageDialog(null, "PALABRA CLAVE NO ENCONTRADA");
                    return null;
                }
                i++;
            }

            return this.resumenes[hash];
        }
    }

    public String mostrarClaves() {
        String mostrar = "";
        for (int i = 0; i < this.resumenes.length; i++) {
            if (!this.resumenes[i].clave.equals("")) {
                mostrar += this.resumenes[i].clave + ";";
            }
        }
        return mostrar;
    }
}

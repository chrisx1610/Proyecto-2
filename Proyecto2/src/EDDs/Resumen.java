/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDDs;

public class Resumen {

    String titulo;
    String autores;
    String resumen;
    String claves;

    public Resumen(String titulo, String autores, String resumen, String claves) {
        this.titulo = titulo;
        this.autores = autores;
        this.resumen = resumen;
        this.claves = claves;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getClaves() {
        return claves;
    }

    public void setClaves(String claves) {
        this.claves = claves;
    }

    public String analizarResumen() {
        String analisisResumen = "Titulo: " + this.titulo + "\nAutores: ";
        this.autores =this.autores.replaceAll(".$", "");
        String[] a = this.autores.split(";");
        for (int i = 0; i < a.length; i++) {
            analisisResumen += a[i] + "\n";
        }
        
        String[] b = this.claves.split(", ");
        for (int i = 0; i < b.length; i++) {
            int nro_veces = 0;
            int indice_letraPC = 0;
            for (int j = 0; j < this.resumen.length(); j++) {
                String letra = String.valueOf(b[i].charAt(indice_letraPC)).toLowerCase();
                String letraResumen = String.valueOf(resumen.charAt(j)).toLowerCase();
                if (!letra.equals(letraResumen)) {
                    indice_letraPC = 0;
                }
                if (letraResumen.equals(letra)) {
                    indice_letraPC += 1;
                }
                if (indice_letraPC == b[i].length()) {
                    nro_veces += 1;
                    indice_letraPC = 0;
                }

            }
            analisisResumen += b[i] + ": " + nro_veces + " apariciones\n";
        }
        return analisisResumen;
    }
}

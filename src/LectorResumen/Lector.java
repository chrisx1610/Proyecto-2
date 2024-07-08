/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LectorResumen;

import EDDs.HashTable;
import EDDs.Resumen;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lector {

    public HashTable titulos;
    public HashTable autores;
    public HashTable palabras;

    public Lector(HashTable titulos, HashTable autores, HashTable palabras) {
        this.titulos = titulos;
        this.autores = autores;
        this.palabras = palabras;
    }

    public void leerResumen(String path) {
        String linea;
        String title = "";
        String autors = "";
        String summary = "";
        String keys = "";
        int lecture_mode = 1;
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) {
                    if (linea.toLowerCase().equals("autores")) {
                        lecture_mode = 2;
                    } else if (linea.toLowerCase().equals("resumen")) {
                        lecture_mode = 3;
                    } else if (linea.toLowerCase().contains("palabras claves: ")) {
                        if (String.valueOf(linea.charAt(linea.length() - 1)).equals(".") || String.valueOf(linea.charAt(linea.length() - 1)).equals(".")) {
                            keys += linea.toLowerCase().replace("palabras claves: ", "").replaceAll(".$", "");
                        } else {
                            keys += linea.toLowerCase().replace("palabras claves: ", "");
                        }
                    } else if (lecture_mode == 1) {
                        title += linea;
                    } else if (lecture_mode == 2) {
                        autors += linea.replace("-", " ") + ";";
                    } else if (lecture_mode == 3) {
                        summary += linea + " ";
                    }
                }
            }
//            System.out.println("a");
            this.titulos.insertar(title, autors, summary, keys, title);
            autors = autors.replaceAll(".$", "");
            String[] a = autors.split(";");
//                        System.out.println(a.length);

            for (int i = 0; i < a.length; i++) {
                this.autores.insertar(title, autors, keys, linea, a[i]);
            }
//            System.out.println("b");
//            keys = keys.replaceAll("^.", "");
            String[] b = keys.split(", ");
//            System.out.println(b.length);
            for (int i = 0; i < b.length; i++) {
                this.palabras.insertar(title, autors, keys, linea, b[i]);
            }
//            System.out.println(this.autores.mostrarClaves());
            br.close();

//            JOptionPane.showMessageDialog(null, "Se ha leido el archivo");
        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    public String buscarTXT() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Texto", "txt");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        File ruta = new File("e:/carpeta/");
        fileChooser.setCurrentDirectory(ruta);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String dir = String.valueOf(file).replace("\\", "//");
            return dir;
        }
        return "";
    }
}

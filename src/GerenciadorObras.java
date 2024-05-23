import java.io.*;
import java.util.ArrayList;

public abstract class GerenciadorObras {

    private static final String ARQUIVO = "obras.txt";

    public static void salvarObra(ObraDeArte obra) throws IOException {
        try (FileWriter fw = new FileWriter(ARQUIVO, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(obra + "\n");
        }
    }

    public static ArrayList<ObraDeArte> listarObras() throws IOException, Exception {
        ArrayList<ObraDeArte> listaObras = new ArrayList<>();
        try (FileReader fr = new FileReader(ARQUIVO);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                ObraDeArte obra = ObraDeArte.fromString(linha);
                listaObras.add(obra);
            }
        }

        if (listaObras.isEmpty()) {
            throw new Exception("\nNão há obras cadastradas");
        }

        return listaObras;
    }

    public static ObraDeArte buscarObra(String titulo) throws Exception {
        ArrayList<ObraDeArte> listaObras = listarObras();
        for (ObraDeArte tempObra : listaObras) {
            if (tempObra.getTitulo().equalsIgnoreCase(titulo)) {
                return tempObra;
            }
        }
        throw new Exception("\nObra com o título '" + titulo + "' não localizada!");
    }

    public static void apagarObra(String titulo) throws Exception {
        ArrayList<ObraDeArte> listaObras = listarObras();
        boolean encontrou = false;
        for (ObraDeArte temp : listaObras) {
            if (temp.getTitulo().equalsIgnoreCase(titulo)) {
                listaObras.remove(temp);
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            throw new Exception("\nObra com o título '" + titulo + "' não localizada!");
        }

        try (FileWriter fw = new FileWriter(ARQUIVO);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (ObraDeArte obra : listaObras) {
                bw.write(obra + "\n");
            }
        }
    }

    public static void atualizarObra(String titulo, ObraDeArte obraAtualizada) throws Exception {
        ArrayList<ObraDeArte> listaObras = listarObras();
        boolean encontrou = false;
        for (int i = 0; i < listaObras.size(); i++) {
            if (listaObras.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                listaObras.set(i, obraAtualizada);
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            throw new Exception("\nObra com o título '" + titulo + "' não localizada!");
        }

        try (FileWriter fw = new FileWriter(ARQUIVO);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (ObraDeArte obra : listaObras) {
                bw.write(obra + "\n");
            }
        }
    }
}

import java.io.IOException;

public class Sistema {

    private static void exibirMenu() {
        System.out.println("\nGERENCIADOR DE OBRAS DE ARTE");
        System.out.println("1) Cadastrar");
        System.out.println("2) Buscar");
        System.out.println("3) Listar todas");
        System.out.println("4) Apagar");
        System.out.println("5) Atualizar");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
    }

    private static void verificarOpcao(int op) {
        switch (op) {
            case 1:
                salvarObra();
                break;
            case 2:
                buscarObra();
                break;
            case 3:
                listarTodas();
                break;
            case 4:
                apagarObra();
                break;
            case 5:
                atualizarObra();
                break;
            case 0: 
                System.out.println("\nO Programa foi finalizado...");
                break;
            default:
                System.out.println("\nOpção inválida. Digite novamente:");
                break;
        }
    }

    private static void salvarObra() {
        System.out.println("\nNova Obra:");
        String titulo = Console.lerString("Informe o título: ");
        String artista = Console.lerString("Informe o artista: ");
        int anoDeCriacao = Console.lerInt("Informe o ano de criação: ");
        String tipo = Console.lerString("Informe o tipo de obra (pintura, escultura, etc.): ");
        String localizacao = Console.lerString("Informe a localização: ");
        
        ObraDeArte obra = new ObraDeArte(titulo, artista, anoDeCriacao, tipo, localizacao);

        try {
            GerenciadorObras.salvarObra(obra);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarObra() {
        System.out.println("\nBuscar Obra");
        String titulo = Console.lerString("Informe o título: ");

        try {
            ObraDeArte obra = GerenciadorObras.buscarObra(titulo);
            System.out.println("\nObra encontrada: " + obra);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarTodas() {
        System.out.println("\nObras Cadastradas:");
        try {
            for (ObraDeArte tempObra : GerenciadorObras.listarObras()) {
                System.out.println(tempObra);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void apagarObra() {
        System.out.println("\nApagar Obra");
        String titulo = Console.lerString("Informe o título da obra que deseja apagar: ");

        try {
            GerenciadorObras.apagarObra(titulo);
            System.out.println("\nObra excluída com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void atualizarObra() {
        System.out.println("\nAtualizar Obra");
        String titulo = Console.lerString("Informe o título da obra que deseja atualizar: ");

        try {
            ObraDeArte obraExistente = GerenciadorObras.buscarObra(titulo);
            System.out.println("\nDados atuais da obra: " + obraExistente);
            String novoTitulo = Console.lerString("Informe o novo título: ");
            String novoArtista = Console.lerString("Informe o novo artista: ");
            int novoAnoDeCriacao = Console.lerInt("Informe o novo ano de criação: ");
            String novoTipo = Console.lerString("Informe o novo tipo de obra: ");
            String novaLocalizacao = Console.lerString("Informe a nova localização: ");
            
            ObraDeArte obraAtualizada = new ObraDeArte(novoTitulo, novoArtista, novoAnoDeCriacao, novoTipo, novaLocalizacao);
            GerenciadorObras.atualizarObra(titulo, obraAtualizada);
            System.out.println("\nObra atualizada com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void executar() {
        int op;
        do {
            exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);
        } while(op != 0);
    }
}

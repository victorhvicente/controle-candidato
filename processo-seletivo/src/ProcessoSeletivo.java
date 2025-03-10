import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        List<String> selecionados = new ArrayList<>();
        selecionados = selecaoCandidatos();
        imprimirSelecionados(selecionados);
    
        for (String candidato : selecionados) {
            int tentativasLigacao = 0;
            boolean atendeu = false;
    
            System.out.println("\nTentando ligar para " + candidato + "...");
    
            do {
                atendeu = atender();
                tentativasLigacao++;
    
                if (!atendeu) {
                    System.out.println("Tentativa " + tentativasLigacao + ": Candidato não atendeu.");
                } else {
                    System.out.println("Tentativa " + tentativasLigacao + ": Contato realizado com sucesso.");
                }
            } while (tentativasLigacao < 3 && !atendeu);
    
            if (atendeu) {
                System.out.println("Conseguimos contato com " + candidato + "!");
            } else {
                System.out.println("Não conseguimos contato com " + candidato + " após 3 tentativas.");
            }
        }
    }
    

    public static boolean atender() {
        return ThreadLocalRandom.current().nextInt(3) == 1;
    }
    

    public static void imprimirSelecionados(List<String> listaCandidatos) {
        for (int i = 0; i < listaCandidatos.size(); i++) {
            System.out.println("Candidato " + listaCandidatos.get(i) + " | Posição: " + (i + 1));
        }
    }
    

    public static List<String> selecaoCandidatos(){

        String [] candidatos = {
            "Victor", "Hugo", "Vicente", "Bruce", "Peter", "Diana",
            "Hall Jordan", "Bruce Banner", "Coringa", "Pinguim", "Barry Allen"
        };

        List<String> selecionados = new ArrayList<>();
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000;
        

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = salarioAleatorio();

            System.out.println(String.format("O candidato %s solicitou um salário de R$ %.2f", candidato, salarioPretendido));
            System.out.println(" ");

            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidado " + candidato + " foi selecionado para vaga ");
                System.out.println(" ");

                selecionados.add(candidato);
                
                candidatosSelecionados++;
            }

            candidatoAtual++;
        }

        return selecionados;
    }

    public static double salarioAleatorio(){
        return ThreadLocalRandom.current().nextDouble(1800, 2500);
    }

}
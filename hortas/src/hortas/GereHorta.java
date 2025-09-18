package hortas;

import java.util.ArrayList;
import java.util.List;

public class GereHorta {
    private List<Horta> hortas;
    
    public GereHorta() {
        this.hortas = new ArrayList<>();
    }
    

    public void registarHorta(String nome, String localizacao) {
        Horta horta = new Horta(nome, localizacao);
        hortas.add(horta);
        System.out.println("Horta '" + nome + "' registada com sucesso!");
    }
    

    public void registarTalhao(String nomeHorta, int numeroTalhao, double area) {
        Horta horta = encontrarHorta(nomeHorta);
        if (horta != null) {
            Talhao talhao = new Talhao(numeroTalhao, area);
            horta.adicionarTalhao(talhao);
            System.out.println("Talhão " + numeroTalhao + " adicionado à horta '" + nomeHorta + "'");
        } else {
            System.out.println("Horta '" + nomeHorta + "' não encontrada!");
        }
    }
    

    public void registarPlantacao(String nomeHorta, int numeroTalhao, 
                                 LocalDate dataSementeira, String tipoCultura) {
        Horta horta = encontrarHorta(nomeHorta);
        if (horta != null) {
            Talhao talhao = encontrarTalhao(horta, numeroTalhao);
            if (talhao != null) {
                Plantacao plantacao = new Plantacao(dataSementeira, tipoCultura);
                talhao.adicionarPlantacao(plantacao);
                System.out.println("Plantação de " + tipoCultura + " registada no talhão " + numeroTalhao);
            } else {
                System.out.println("Talhão " + numeroTalhao + " não encontrado!");
            }
        } else {
            System.out.println("Horta '" + nomeHorta + "' não encontrada!");
        }
    }
    

    public void imprimirDetalhesPlantacoes(String nomeHorta) {
        Horta horta = encontrarHorta(nomeHorta);
        if (horta != null) {
            System.out.println("\n=== DETALHES DA HORTA: " + horta.getNome() + " ===");
            System.out.println("Localização: " + horta.getLocalizacao());
            System.out.println("Área total: " + horta.calcularAreaTotal() + "m²");
            System.out.println("Número de talhões: " + horta.getTalhoes().size());
            
            for (Talhao talhao : horta.getTalhoes()) {
                System.out.println("\nTalhão " + talhao.getNumeroIdentificador() + 
                                 " - " + talhao.getAreaMetrosQuadrados() + "m²");
                System.out.println("Plantações:");
                
                if (talhao.getPlantacoes().isEmpty()) {
                    System.out.println("  Nenhuma plantação registada");
                } else {
                    for (Plantacao plantacao : talhao.getPlantacoes()) {
                        System.out.println("  - " + plantacao.getTipoCultura() + 
                                         " (semeada em: " + plantacao.getDataSementeira() + ")");
                    }
                }
            }
        } else {
            System.out.println("Horta '" + nomeHorta + "' não encontrada!");
        }
    }
    

    public void imprimirAreaTotalHorta(String nomeHorta) {
        Horta horta = encontrarHorta(nomeHorta);
        if (horta != null) {
            System.out.println("Área total da horta '" + nomeHorta + "': " + 
                             horta.calcularAreaTotal() + "m²");
        } else {
            System.out.println("Horta '" + nomeHorta + "' não encontrada!");
        }
    }
    

    public void imprimirHortaMaiorArea() {
        if (hortas.isEmpty()) {
            System.out.println("Não existem hortas registadas!");
            return;
        }
        
        Horta maiorHorta = hortas.get(0);
        for (Horta horta : hortas) {
            if (horta.calcularAreaTotal() > maiorHorta.calcularAreaTotal()) {
                maiorHorta = horta;
            }
        }
        
        System.out.println("Horta com maior área: '" + maiorHorta.getNome() + 
                         "' com " + maiorHorta.calcularAreaTotal() + "m²");
    }
    
    public void imprimirHortasComCultura(String tipoCultura) {
        System.out.println("Hortas com cultura '" + tipoCultura + "':");
        boolean encontrou = false;
        
        for (Horta horta : hortas) {
            if (horta.temCultura(tipoCultura)) {
                System.out.println(" - " + horta.getNome());
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhuma horta encontrada com a cultura '" + tipoCultura + "'");
        }
    }
}
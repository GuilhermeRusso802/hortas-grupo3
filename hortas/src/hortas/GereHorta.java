package hortas;

import java.time.LocalDate;
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
            System.out.println("Área total: " + horta.areaTotal() + "m²");
            System.out.println("Número de talhões: " + horta.getTalhoes().size());
            
            for (Talhao talhao : horta.getTalhoes()) {
                System.out.println("\nTalhão " + talhao.getId() + 
                                 " - " + talhao.getArea() + "m²");
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
                             horta.areaTotal() + "m²");
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
            if (horta.areaTotal() > maiorHorta.areaTotal()) {
                maiorHorta = horta;
            }
        }
        
        System.out.println("Horta com maior área: '" + maiorHorta.getNome() + 
                         "' com " + maiorHorta.areaTotal() + "m²");
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
    
    private Horta encontrarHorta(String nomeHorta) {
        for (Horta horta : hortas) {
            if (horta.getNome().equalsIgnoreCase(nomeHorta)) {
                return horta;
            }
        }
        return null;
    }
    
    private Talhao encontrarTalhao(Horta horta, int numeroTalhao) {
        for (Talhao talhao : horta.getTalhoes()) {
            if (talhao.getId() == numeroTalhao) {
                return talhao;
            }
        }
        return null;
    }
    
    public void listarHortas() {
        System.out.println("\n=== LISTA DE HORTAS ===");
        if (hortas.isEmpty()) {
            System.out.println("Nenhuma horta registada");
        } else {
            for (int i = 0; i < hortas.size(); i++) {
                Horta horta = hortas.get(i);
                System.out.println((i + 1) + ". " + horta.getNome() + 
                                 " - " + horta.getLocalizacao() +
                                 " (" + horta.getTalhoes().size() + " talhões, " +
                                 horta.areaTotal() + "m²)");
            }
        }
    }
}
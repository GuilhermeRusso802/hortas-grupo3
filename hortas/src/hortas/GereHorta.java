package hortas;

public class GereHorta {
    private List<Horta> hortas;
    
    public GereHorta() {
        this.hortas = new ArrayList<>();
    }
    
    // 1. Registar hortas
    public void registarHorta(String nome, String localizacao) {
        Horta horta = new Horta(nome, localizacao);
        hortas.add(horta);
        System.out.println("Horta '" + nome + "' registada com sucesso!");
    }
    
    // 2. Registar os talhões de uma horta
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
    
    // 3. Registar as plantações de um talhão numa dada horta
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
    
    // 4. Imprimir os detalhes das plantações de uma dada horta
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
    
    // 5. Imprimir a área total de uma horta em metros quadrados
    public void imprimirAreaTotalHorta(String nomeHorta) {
        Horta horta = encontrarHorta(nomeHorta);
        if (horta != null) {
            System.out.println("Área total da horta '" + nomeHorta + "': " + 
                             horta.calcularAreaTotal() + "m²");
        } else {
            System.out.println("Horta '" + nomeHorta + "' não encontrada!");
        }
    }
    
    // 6. Imprimir o nome e a área da horta com maior área
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
    
    // 7. Imprimir o nome das hortas que têm plantadas um dado tipo de cultura
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
    
    // Métodos auxiliares
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
            if (talhao.getNumeroIdentificador() == numeroTalhao) {
                return talhao;
            }
        }
        return null;
    }
    
    // Método para listar todas as hortas
    public void listarHortas() {
        System.out.println("\n=== LISTA DE HORTAS ===");
        if (hortas.isEmpty()) {
            System.out.println("Nenhuma horta registada");
        } else {
            for (Horta horta : hortas) {
                System.out.println(horta);
            }
        }
    }
}
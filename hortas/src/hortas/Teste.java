package hortas;

public class Teste {
	public static void main(String[] args) {
        GereHorta sistema = new GereHorta();
        
        // Registar hortas
        sistema.registarHorta("Horta do Parque", "Parque Central");
        sistema.registarHorta("Horta Comunitária", "Bairro das Flores");
        
        // Registar talhões
        sistema.registarTalhao("Horta do Parque", 1, 50.0);
        sistema.registarTalhao("Horta do Parque", 2, 75.0);
        sistema.registarTalhao("Horta Comunitária", 1, 100.0);
        
        // Registar plantações
        sistema.registarPlantacao("Horta do Parque", 1, LocalDate.of(2024, 3, 15), "Alface");
        sistema.registarPlantacao("Horta do Parque", 1, LocalDate.of(2024, 3, 20), "Tomate");
        sistema.registarPlantacao("Horta do Parque", 2, LocalDate.of(2024, 4, 1), "Cenoura");
        sistema.registarPlantacao("Horta Comunitária", 1, LocalDate.of(2024, 3, 25), "Alface");
        
        // Testar funcionalidades
        sistema.listarHortas();
        sistema.imprimirDetalhesPlantacoes("Horta do Parque");
        sistema.imprimirAreaTotalHorta("Horta do Parque");
        sistema.imprimirHortaMaiorArea();
        sistema.imprimirHortasComCultura("Alface");
        sistema.imprimirHortasComCultura("Tomate");
    }
}

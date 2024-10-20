import domain.Estudante;
import service.FileService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();

        List<String> titulos = new ArrayList<>();
        titulos.add("ID");
        titulos.add("NOME");
        titulos.add("ANO");

        fileService.inserirCabecalho(titulos);

        List<Estudante> estudantes = new ArrayList<>();
        estudantes.add(new Estudante(128, "Aditya", "2nd year"));
        estudantes.add(new Estudante(129, "Narayana", "2nd year"));
        estudantes.add(new Estudante(130, "Mohan", "2nd year"));
        estudantes.add(new Estudante(131, "Radha", "2nd year"));
        estudantes.add(new Estudante(132, "Gopal", "2nd year"));

        fileService.inserirConteudo(estudantes);
        fileService.gerarArquivoExcel();
    }
}

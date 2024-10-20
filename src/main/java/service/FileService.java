package service;

import domain.Estudante;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileService {
    private XSSFWorkbook workbook;
    private XSSFSheet planilha;
    private Integer idLinha;

    public FileService() {
        workbook = new XSSFWorkbook();
        planilha = workbook.createSheet("Dados dos estudantes");
        idLinha = 0;
    }

    public void inserirCabecalho(List<String> titulo) {
        Cell celula;
        XSSFRow linha = planilha.createRow(idLinha++);
        for (int indice = 0; indice < titulo.size(); indice++) {
            celula = linha.createCell(indice);
            celula.setCellValue(titulo.get(indice));
        }
    }

    public void inserirConteudo(List<Estudante> estudantes) {
        Cell celula;
        XSSFRow linha;
        for (Estudante estudante : estudantes) {

            linha = planilha.createRow(idLinha++);

            celula = linha.createCell(0);
            celula.setCellValue(estudante.getId());

            celula = linha.createCell(1);
            celula.setCellValue(estudante.getName());

            celula = linha.createCell(2);
            celula.setCellValue(estudante.getYear());
        }
    }

    public void gerarArquivoExcel() {
        try {
            FileOutputStream out = new FileOutputStream("/home/xavier/Downloads/GFGsheet.xlsx");
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

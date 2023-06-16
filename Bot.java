import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import me.ramswaroop.jbot.core.slack.Bot;
import me.ramswaroop.jbot.core.slack.Controller;
import me.ramswaroop.jbot.core.slack.models.Event;
import me.ramswaroop.jbot.core.slack.models.Message;

public class ExcelBot extends Bot {

    // Controlador para eventos de mensagem direta, menção direta e menção ao bot
    @Controller(events = { "direct_message", "direct_mention", "mention" })
    public void onReceiveDM(Event event) {
        reply(event, getMenuMessage()); // Responde com o menu de opções
    }

    // Controlador para padrões de mensagem que correspondem a "menu", "opções" ou "options"
    @Controller(patterns = "(menu|opções|options)")
    public void showMenu(Event event) {
        reply(event, getMenuMessage()); // Responde com o menu de opções
    }

    // Controlador para o padrão de mensagem "ler excel"
    @Controller(patterns = "ler excel")
    public void readExcel(Event event) {
        String filePath = "caminho/do/arquivo.xlsx"; // Insira o caminho do arquivo Excel aqui
        String excelData = "";

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // Lê a primeira planilha do arquivo

            int rowCount = sheet.getLastRowNum();
            for (int i = 0; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                int columnCount = row.getLastCellNum();
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = row.getCell(j);
                    String cellValue = cell.getStringCellValue();
                    excelData += cellValue + "\t";
                }
                excelData += "\n";
            }

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        reply(event, new Message(excelData)); // Responde com o conteúdo do arquivo Excel lido
    }

    // Retorna uma mensagem contendo o menu de opções
    private Message getMenuMessage() {
        String menu = "Selecione uma opção:\n"
                + "1. Ler Excel\n"
                + "2. Outra Opção\n"
                + "3.Ver Preços\n"
                + "4.Ver Produtos\n"
                + "5. Sair";
        return new Message(menu);
    }
}

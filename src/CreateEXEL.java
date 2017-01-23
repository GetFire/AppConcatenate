import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by GetFire on 23.01.2017.
 */
public class CreateEXEL {
    public static void main(String[] args) {
        try {
            Workbook book = new HSSFWorkbook();
            Sheet sheet = book.createSheet("Examle of goods");
            Row row = sheet.createRow(0);
            Cell id = row.createCell(0);
            id.setCellValue("product_id");
            Cell model = row.createCell(1);
            model.setCellValue("Model");
            Cell name = row.createCell(2);
            name.setCellValue("Name");
            Cell rP = row.createCell(3);
            rP.setCellValue("Related product");
            sheet.autoSizeColumn(4);
            book.write(new FileOutputStream("D:\\practice\\Papa\\src\\test.xls"));
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

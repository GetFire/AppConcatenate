import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GetFire on 23.01.2017.
 */
public class TxtToExcel {
    public static void main(String[] args) {
        List<DataModel> listTxt = new ArrayList<>();
        String line;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Похожие модели");

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\practice\\Papa\\src\\Final3.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] s = line.split("\t");
                if (s.length == 4)
                    listTxt.add(new DataModel(s[0], s[1], s[2], s[3]));
                else
                    listTxt.add(new DataModel(s[0], s[1], s[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Product_ID");
        row.createCell(1).setCellValue("Model");
        row.createCell(2).setCellValue("Name");
        row.createCell(3).setCellValue("Related_product");

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);

        for (DataModel dataModel : listTxt) {
            createSheetHeader(sheet, ++rowNum, dataModel);
        }

        try {
            workbook.write(new FileOutputStream("D:\\practice\\Papa\\src\\Final3.xls"));
            System.out.println("Файл успешно создан");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void createSheetHeader(HSSFSheet sheet, int rowNum, DataModel dataModel) {
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(dataModel.getOne());
        row.createCell(1).setCellValue(dataModel.getTwo());
        row.createCell(2).setCellValue(dataModel.getThree());
        row.createCell(3).setCellValue(dataModel.getFour());
    }
}

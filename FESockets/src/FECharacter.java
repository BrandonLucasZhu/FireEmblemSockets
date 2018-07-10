import org.apache.poi.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class FECharacter {
	public static void main(String[] args) {
		/*File file = new File(".");
		for(String fileNames : file.list()) System.out.println(fileNames);
		*/
		try {
			FileInputStream file = new FileInputStream(new File("FEHero.xlsx"));
			
			//Create Workbook instance holding reference to .xlsx file
	        Workbook workbook = new XSSFWorkbook(file);
	        Sheet datatypeSheet = workbook.getSheetAt(0);
            //Iterator<Row> iterator = datatypeSheet.iterator();
	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	        
	        Row row = datatypeSheet.getRow(0);
	        Iterator iterator = row.cellIterator();
	        Map<String, String> stats = new HashMap<String, String>();
	        
	        
	        while(iterator.hasNext()){
	             Cell cell = (Cell)iterator.next();
	             stats.put(cell.getStringCellValue(), "na");
	        
	        }
	        
	        for (int i = 1; i <= datatypeSheet.getLastRowNum(); i++) {
	        	 Row row1 = datatypeSheet.getRow(i);
	        	 for (Cell cell: row1) {
	        	      
	        	        if(cell == null) {
	        	            continue;
	        	        }
	        	        
	        	        System.out.println(cell);
	        	    }
	        	
	            	
	            	
	            	/*if (cell!=null) {
	            	    switch (evaluator.evaluateFormulaCell(cell)) {
	            	        case Cell.CELL_TYPE_BOOLEAN:
	            	            System.out.println(cell.getBooleanCellValue());
	            	            break;
	            	        case Cell.CELL_TYPE_NUMERIC:
	            	            System.out.println(cell.getNumericCellValue());
	            	            break;
	            	        case Cell.CELL_TYPE_STRING:
	            	            System.out.println(cell.getStringCellValue());
	            	            break;
	            	        case Cell.CELL_TYPE_BLANK:
	            	            break;
	            	        case Cell.CELL_TYPE_ERROR:
	            	            System.out.println(cell.getErrorCellValue());
	            	            break;

	            	        // CELL_TYPE_FORMULA will never occur
	            	        case Cell.CELL_TYPE_FORMULA: 
	            	            break;
	            	    }
	            	*/    
	            	    
	        }
	         
	        
            
            /*
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }

                }
                System.out.println();

            }
	        */
	        
	        file.close();
			
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	        
	}
}
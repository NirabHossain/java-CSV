import edu.duke.*;
import org.apache.commons.csv.*;
public class Countries {
    public void listExporters(CSVParser parser, String expt1, String expt2){
        for(CSVRecord record: parser){
            String export= record.get("Value (dollars)");
            if(export.length()>16){
                String country=record.get("Country");
                System.out.println(country);
              
            }
            if(export.contains(expt1)){
//                String country=record.get("Country");
//                System.out.println(country);
//                cnt++;
            }
        }
    }
    public void whoCoffee(){
        FileResource fr=new FileResource("exports/exportdata.csv");
        CSVParser parser= fr.getCSVParser();
        listExporters(parser,"gold","diamond");
    }
}

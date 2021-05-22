import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class CSVMax {
    public CSVRecord hott(CSVParser parser){
        CSVRecord lar=null;
        int cnt=0;
        double total=0;
        for(CSVRecord curr: parser){
            //lar=LargeTwo(curr,lar);
            double temp=Double.parseDouble(curr.get("TemperatureF"));
            double hum=Double.parseDouble(curr.get("Humidity"));
            if(hum>=80){
                System.out.println(total+" "+cnt+" "+hum);            
                total+=temp;
                cnt++;
            }
        }
        System.out.println("Average temperature is: "+total/cnt);
        return lar;
    }
    
    public CSVRecord LargeTwo(CSVRecord curr, CSVRecord lar){
        if(lar==null)lar=curr;
        else{
                double temp=Double.parseDouble(curr.get("TemperatureF"));
                double L=Double.parseDouble(lar.get("TemperatureF"));
                if(L>temp)lar=curr;
        }
        return lar;
    }
    
    public void test(){
        FileResource fr= new FileResource("nc_weather/2013/weather-2013-09-02.csv");
        CSVRecord largest=hott(fr.getCSVParser());
        System.out.println(largest.get("TemperatureF")+" at "+largest.get("TimeEST"));
    }
    
    public CSVRecord hotmul(){
        CSVRecord lar=null;
        DirectoryResource dr= new DirectoryResource();
        for(File f: dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            CSVRecord curr = hott(fr.getCSVParser());
            lar=LargeTwo(curr,lar);
        }
        return lar;
    }
    
    
    
    public void testMul(){
        CSVRecord largest=hotmul();
        System.out.println(largest.get("TemperatureF")+" at "+largest.get("DateUTC"));
    }
    
    
}

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class MultipleFilesBabyBirth {
    
    public void hotmul(){
        CSVRecord lar=null;
        int sum=0,boys=0,girls=0,cnt=0,boyN=0,girlN=0;
        String name=" ";
        DirectoryResource dr= new DirectoryResource();
        
        for(File f: dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            cnt=0;
            
            for(CSVRecord rec: fr.getCSVParser(false)){
                
                if(rec.get(1).equals("F")){
                    cnt++;
                    if(rec.get(0).equals("Susan")){
                        System.out.println(f.getName()+": "+cnt);
                            sum+=cnt;
                            name=f.getName();
                    }
                }
            }
        }
            System.out.println("\n\n\nFinal value is: "+ sum/135.0+" "+name);

        }
    
}

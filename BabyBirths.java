import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {
    
    public void printNames(){
        FileResource fr= new FileResource();
        int sum=0,boys=0,girls=0,cnt=0;
        for(CSVRecord rec: fr.getCSVParser(false)){
                System.out.println("Name: "+rec.get(0)+" Gender: "+rec.get(1)+" Num Born: "+rec.get(2));
        }
        System.out.println("Total birth is: "+sum);
        System.out.println("Total boys is: "+boys);
        System.out.println("Total girls is: "+girls);
    }
    
    public void printAns(){
        FileResource fr= new FileResource("us_babynames_by_year/yob1990.csv");
        int sum=0,boys=0,girls=0,cnt=0,boyN=0,girlN=0;
        for(CSVRecord rec: fr.getCSVParser(false)){
                int num=Integer.parseInt(rec.get(2));
                cnt++;

                if(rec.get(1).equals("M")){
                    System.out.println(rec.get(0)+": "+num+" "+girls);
                    if(rec.get(0).equals("Drew")){
                        System.out.println(cnt);
                        break;
                    }
                    girls+=num;
                }
        }
    }
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Management {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub
	
		int total_money = 0;
		int total_days_passed = 0;
		
		ArrayList<IncomeSource> IncomeSource_array = new ArrayList<IncomeSource>();
		
		//Inially, read txt files and then assign necessary variables
		ArrayList<String> income_source_array_in_file = DosyaOku("savefile.txt");
		total_money = Integer.parseInt(income_source_array_in_file.get(0));
		total_days_passed = Integer.parseInt(income_source_array_in_file.get(1));
		
		for (int i = 2; i < income_source_array_in_file.size(); i++) {
			String[] temp = income_source_array_in_file.get(i).split(";");
			IncomeSource_array.add(new IncomeSource(temp[0], Integer.parseInt(temp[1])));
		}
		
		do {
			Thread.sleep(1 * 1 * 1000); //first one is the minute, second one seconds
			for (int i = 0; i < IncomeSource_array.size(); i++) {
				total_money += addMoney(IncomeSource_array.get(i));
			}
			refreshScreen();
			System.out.println("Money: " + total_money);
			total_days_passed++;
			System.out.println("Days passed: "+total_days_passed);
			
			//kayit
			ResetFile("savefile.txt");
			SaveToFile("savefile.txt", String.valueOf(total_money));
			SaveToFile("savefile.txt", String.valueOf(total_days_passed));
			
			for (int i = 0; i < IncomeSource_array.size(); i++) {
				String temp = IncomeSource_array.get(i).getName() + ";" + String.valueOf(IncomeSource_array.get(i).getMoney_to_add());
				SaveToFile("savefile.txt", temp);
				
			}
			
		} while (true);
	}
	
	
	public static int addMoney(IncomeSource src) {
		return src.getMoney_to_add();
	}
	
	public static void refreshScreen() {
		for (int i = 0; i < 20; i++) {
			System.out.println("");
		}
	}
	
public static ArrayList<String> DosyaOku(String txt_file) throws FileNotFoundException {
		
	    String IncomeSource = "";
	    ArrayList<String> IncomeSource_array = new ArrayList<String>();
	    
	    String path = System.getProperty("user.dir");
	    //System.out.println(path + "\\bin\\" + txt_file);
	    File dosya = new File(path + "\\bin\\" + txt_file);
	
	
	    if (!dosya.exists()) {
	        System.out.println("Sistem kaynak dosyasýný bulamadý!");
	        System.out.println("Uygulama kapanacak!");
	    }
		
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(dosya))) {
			try {
				while((IncomeSource = br.readLine()) != null ) {
					IncomeSource_array.add(IncomeSource);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

	    return IncomeSource_array;
			    			    
	}
	
	public static void CreateNewTXTFile(String txt_file){
		
		try {
			  String path = System.getProperty("user.dir");
			  //System.out.println(path + "\\bin\\" + txt_file);
			  File dosya = new File(path + "\\bin\\" +txt_file);
			  
		      if (dosya.createNewFile()) {
		        System.out.println("Dosya oluþturuldu: " + dosya.getName());
		      } else {
		        System.out.print("");
		      }
		    } catch (IOException e) {
		      System.out.println("Bir hata meydana geldi.");
		      e.printStackTrace();
		    }		  
	}
	
	public static void SaveToFile(String txt_file, String IncomeSource) {
		
		CreateNewTXTFile(txt_file);
		try {
			  String path = System.getProperty("user.dir");
			  
		      FileWriter myWriter = new FileWriter(path + "\\bin\\" +txt_file, true);
		      BufferedWriter br = new BufferedWriter(myWriter);
		      
		      br.write(IncomeSource);
		      br.write("\n");
		      
		      br.close();
		      myWriter.close();
		      
		      System.out.print("");
		    } catch (IOException e) {
		      System.out.println("Bir hata meydana geldi.");
		      e.printStackTrace();
		    }
	}
	public static void ResetFile(String txt_file) {
		
		try {
			  String path = System.getProperty("user.dir");
			  
		      FileWriter myWriter = new FileWriter(path + "\\bin\\" +txt_file, false);
		      BufferedWriter br = new BufferedWriter(myWriter);
		      
		      br.write("");
		      //br.write("\n");
		      
		      br.close();
		      myWriter.close();
		      
		      //System.out.println("Kayýtlar dosyaya baþarýlý bir þekilde yazýldý.");
		    } catch (IOException e) {
		      System.out.println("Bir hata meydana geldi.");
		      e.printStackTrace();
		    }
	}
}
package application.Model;
/*
 * Park class is the class that contains all methods
 * for running the program effectively it creates a park object
 * which will contain an HashMap of zone objects and arrayList of Dinosaur objects
 * @author Richard Michael Galindo
 * UTSA-cs3773-spring 2019
 * Lab6
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;
public class Park {
	
	private String name;
	private ArrayList<Dinosaur>list;
	private Map<Zone,ArrayList<Dinosaur>> Dmap;
	private File file;
	private File file2;
	public ArrayList<Dinosaur>dtemp;
	public Dinosaur temp;
	//@param name:String
		// park contructor that takes in a string name which will be the
		// the name of the of the park and a Hashmap of zones are created
		// as well as an arrayList for the Dinosaur objects
	public Park(String name) {
		this.name=name;
		this.list= new ArrayList();
		this.Dmap = new HashMap<Zone, ArrayList<Dinosaur>>();
		}
	/*@param D:Dinosaur, oldZone:String, newZone:String
	 * the relocate method will take in a dinosaur object the old zone and
	 * the new zone strings which will be used to removed teh 
	 * dinosaur from the olds zone and place into the new zone
		*/
	public void Relocate(Dinosaur D, String oldZone, String newZone) {
		
		for (Zone i : this.Dmap.keySet()) {
			if (i.getCode().equals(oldZone)){  
				dtemp= this.Dmap.get(i);
			for (int j =0; j<dtemp.size();j++) {
				temp = dtemp.get(j);
				if(temp.getName().equals(D.getName())) {
					
					temp = dtemp.remove(j);
					break;
				}
		   	}
		}
	}
		for(Zone i :this.Dmap.keySet()){
			if(i.getCode().equals(newZone)){
				dtemp= this.Dmap.get(i);
				D.setCode(i.getCode());
				dtemp.add(D);
				break;
			}
		}
		
	}
	/*@param D:Dinosaur
	 *simply adds a dinosaur to a specific zone based on the
	 *zone frame the user is in. 
	*/
	public void addDino(Dinosaur D) {
		for(Zone i : this.Dmap.keySet()) {
			if(i.getCode().equals(D.getCode())) {
				dtemp = this.Dmap.get(i);
				dtemp.add(D);
			}
		}
	}
	/*@param file:String
	 * passes in the string file name 
	 * and saves the date to that csv file
	 */
	public void Save(String file) {
		this.file = new File(file);
	
		try {
			FileWriter printer = new FileWriter(this.file);
			for(Zone i : this.Dmap.keySet()){
				dtemp = this.Dmap.get(i);
				for(int j=0; j< dtemp.size();j++) {
					temp =dtemp.get(j);
					printer.write(String.format("%s,%s,%s,%s\n", temp.getName(), temp.getSpecies(),temp.getbool(), temp.getCode()));
				}
			}
			printer.close();
			
		}catch(IOException e) {
			System.out.println("the file did not open i think");
		}
	}
	/*@param file:String, file2:String
	 * passes in the string file name, and a file2  
	 * opens both files and writes to thise files. 
	 */
	public void Load(String file, String file2) {
		 this.file = new File(file);
		 this.file2 = new File(file2);
		 
		 try 
		 {
			 Scanner scan = new Scanner(this.file);
			 while(scan.hasNext()) {
				 Zone zone = null;
				 String line = scan.nextLine();
				 String [] token=line.split(",");
				 zone = new Zone(token[0], token[1], token[2]);
				 
				 Scanner scan2 = new Scanner(this.file2);
				 ArrayList<Dinosaur>temp = new ArrayList();
			while(scan2.hasNext()){
				String line2 = scan2.nextLine();
				String [] token2=line2.split(",");
				Dinosaur dino = new Dinosaur(token2[0], token2[1], token2[2], token2[3]);
					 if(token2[3].equals(zone.getCode())) {
						 temp.add(dino);
					 }
				}
				this.Dmap.put(zone, temp);
			}
		}catch(FileNotFoundException e) {
			 // TODO auto generate cathc block
			 e.printStackTrace();
		 }
	}
	/*@param Code:String
		this will find a specific zone and return that zone
	 */
	public Zone findZone(String Code) {
		Zone temp=null;
		for(Zone i :this.Dmap.keySet()) {
			if(i.getCode().equals(Code)) {
				temp = i;
			}
		}
		return temp;
	}
	/*@param code:String
	this will find a specific list of Dinosaurs and return that List
 */
	public ArrayList<Dinosaur> findDinos(String code) {
			ArrayList<Dinosaur>temp2 = null;
			for(Zone temp : this.Dmap.keySet()) {
				if(temp.getCode().equals(code)) {
					temp2=this.Dmap.get(temp);
				}
			}
			return temp2;
		}
	//@return String, 
	//creates a string out of the data
	public String toString() {
		String data="";
		for(Zone i: this.Dmap.keySet()) {
			for(Dinosaur d: this.Dmap.get(i)) {
				System.out.println("key :" + i.getCode() + " value: " + d.getName());
			}
		}
		return data;
	}
}

package application.Model;
/*
 * the zone class is the class that is used
 * to create a zone object which will have an
 *  arralist of dinosaur objects
 *  @author Richard Michael Galindo fpw-305
 *  UTSA -cs3773 -Lab 2 - spring 2019 
 *  */
public class Zone {
	private String name;
	private String code;
	private String level;
	//Zone constructor takes in three parameters
	// and returns a zone object
	//@param: name:string Level:string code:string
	// @returns Zone 
	public Zone(String name, String Level, String code) {
		this.name= name;
		this.level = Level;
		this.code = code;
	}
	// @returns String the code of the zone
	public String getCode() {
		return this.code;
	}
	// @returns String the name of the zone
	public String getName() {
		return this.name;
	}
	// @returns String the level of the zone
	public String getLevel() {
		return this.level;
	}
	// @returns String 
	//converts to a string listing the dinosaurs in the arrayList
	public String toString() {
		String title = "";
		title = this.name+" "+this.code;
		return title;
	}
}

package application.Model;
/*
 * Dinosaur class returns a dinosaur object*/
public class Dinosaur {
	private String name;
	private String Species;
	private boolean bool;
	private String Code;
	private String diet;
	

	//constructor that takes in four paramters to create the Dinosaur object.
	//@param:name:String, spec:String, bool:String, code:String
	//the boolean value will dictate whether the dinosaur is a carnivor or not
	// and will be updated to a lliteral booolean in the contructor.
	public Dinosaur(String name, String spec, String bool, String Code){
		this.name = name;
		this.Species = spec;
		if(bool.equals("false")) {
			this.bool= false;
			this.diet ="Carnivore";
		}else {
			this.bool = true;
			this.diet = "Herbivore";
		}
		this.Code = Code;
	}
	//@return name:String the name of the dinosaur
	public String getName() {
		return this.name;
	}
	//@return Code:String the code of the dinosaur
	public String getCode() {
		return this.Code;
	}
	//@param type:String the Code of the dinosaur
	// by taking in a String parameter
	public void setCode(String code) {
		this.Code=code;
	}
	//@param bool:String the Food preference Carnivor/Herbavore of the dinosaur
	// by taking in a String parameter then converts to a boolean
	public void setFood(String bool) {
		
		if(bool.equals("false")) {
			this.bool = false;
		}else {
			this.bool=true;
		}
	}
	//@return getbool:String the boolean value of food of the dinosaur
	public String getbool() {
		String value = String.valueOf(this.bool);
		return value;
	}
	//@return Code:String the Species of the dinosaur
	public String getSpecies() {
		return this.Species;
	}
	
	// @return String the string value of the dinosaur object.
	public String toString() {
		String value ="";
		value = this.name+"-"+this.Species+"-"+this.diet;
		return value;
	}
}

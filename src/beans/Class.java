package beans;

import java.util.ArrayList;
import recoder.abstraction.Method;

public class Class {
	private String name;
	private ArrayList<beans.Method> methods;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<beans.Method> getMethods() {
		return methods;
	}
	public void setMethods(ArrayList<beans.Method> methods) {
		this.methods = methods;
	}
	public void addMethod(beans.Method m){
		methods.add(m);
	}
}

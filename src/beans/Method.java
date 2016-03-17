package beans;

import java.util.List;

import recoder.abstraction.ClassType;

public class Method {
	private String name;
	private List<recoder.abstraction.Method> methods;
	private String type;
	private String returnedType;
	private String parameters;
	private String variables;
	private List <ClassType> exceptions;
	
	public List<recoder.abstraction.Method> getMethods() {
		return methods;
	}
	public void setMethods(List<recoder.abstraction.Method> list) {
		this.methods = list;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReturnedType() {
		return returnedType;
	}
	public void setReturnedType(String returnedType) {
		this.returnedType = returnedType;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public String getVariables() {
		return variables;
	}
	public void setVariables(String variables) {
		this.variables = variables;
	}
	public void addMethods(recoder.abstraction.Method method){
		methods.add(method);
	}
	public List <ClassType> getExceptions() {
		return exceptions;
	}
	public void setExceptions(List <ClassType> exceptions) {
		this.exceptions = exceptions;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

package Recoder;

import java.util.List;

import recoder.CrossReferenceServiceConfiguration;
import recoder.ParserException;
import recoder.abstraction.ClassType;
import recoder.abstraction.Method;
import recoder.convenience.TreeWalker;
import recoder.io.PropertyNames;
import recoder.io.SourceFileRepository;
import recoder.java.CompilationUnit;
import recoder.java.ProgramElement;
import recoder.java.declaration.ClassDeclaration;
import recoder.java.declaration.MethodDeclaration;
import recoder.java.declaration.VariableSpecification;
import recoder.java.expression.operator.CopyAssignment;

public class Recoder {
	String output = "";
	public static List<CompilationUnit> serviceConfiguration (String srcPath) {
		//create a service configuration
		CrossReferenceServiceConfiguration crsc = new CrossReferenceServiceConfiguration();
		
		//set the path to source code ("src" folder). 
		//multiple source code paths, as well as paths to libraries, can be separated via ":" or ";".
		crsc.getProjectSettings().setProperty(PropertyNames.INPUT_PATH, srcPath);
		crsc.getProjectSettings().ensureSystemClassesAreInPath();
		
		//tell Recoder to parse all .java files it can find in the directory "src"
		SourceFileRepository sfr = crsc.getSourceFileRepository();
		List<CompilationUnit> cul = null;
		try {
			cul = sfr.getAllCompilationUnitsFromPath();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		crsc.getChangeHistory().updateModel();
		return cul;
	}
	public void outputTree(String path){
		//setting src path
		int cont = 0;
		//List<CompilationUnit> cul = serviceConfiguration("/home/alexandre/NetBeansProjects/TesteSimples/src/testesimples/"); 
		List<CompilationUnit> cul = serviceConfiguration(path);
		String arg = "";
		//traversing the abstract syntax trees of the parsed .java files
		for (CompilationUnit cunit : cul) {
			TreeWalker tw = new TreeWalker(cunit);
			while (tw.next()) {
				ProgramElement pe = tw.getProgramElement();
				//getting class information

				if (pe instanceof ClassDeclaration) {
					setOutput("\n------- Class -------");
					ClassDeclaration cls = (ClassDeclaration)pe;
					setOutput(cls.getFullName());
					arg = cls.getFullName();
					setOutput("\n------- Methods -------");
					List<Method> methods = cls.getMethods();
					List<? extends VariableSpecification> var = cls.getVariablesInScope();

					for (Method method : methods) {
						setOutput(method.getFullName());
						if(method.isPublic()){
							setOutput("Acesso: Public");
						}else{
							setOutput("Acesso: Default");
						}
						if(method.getReturnType() != null){
							setOutput("Tipo de retornado: " + method.getReturnType());
						}else{
							setOutput("Tipo de retorno: void");
						}
						List<recoder.abstraction.Type> paramis = method.getSignature();
						if(paramis.isEmpty()){
							setOutput("Método não recebe parametros");

						}else{
							setOutput("número de parâmetros " + paramis.size());
							cont = 0;
							for (recoder.abstraction.Type parami : paramis) {
								cont ++;
								setOutput(cont + " Parametro: "+ parami.getName());
							}
						}
						if (!var.isEmpty()){
							setOutput("Variáveis declaradas no escopo");
							for(VariableSpecification va : var){
								setOutput(va.getFullName());
							}
						}
						List<ClassType> ex = method.getExceptions();
						if(!ex.isEmpty()){
							setOutput("EX");
							for(ClassType e : ex){
								setOutput(e.getName());
							}
						}
						setOutput("\n------- ** -------");
					}
				}
				//getting method information
				if (pe instanceof MethodDeclaration) {
					TreeWalker tw2 = new TreeWalker(pe);
					while (tw2.next()) {
						ProgramElement pe2 = tw2.getProgramElement();
						if (pe2 instanceof CopyAssignment) {
							CopyAssignment ca = (CopyAssignment)pe2;
							String info = ca.getStartPosition().getLine()+ ": " + ca.toSource().trim();
							setOutput("\n--> Definition of " + ca.getFirstElement() + ":\n" + info);
						}
					}
				}
			}		   
		}
	}
	public void setOutput(String out){
		output += out;
	}
	public String getOutput(){
		return output;
	}
}

package Recoder;

import java.util.ArrayList;
import java.util.List;

import beans.Class;
import beans.Method;
import recoder.CrossReferenceServiceConfiguration;
import recoder.ParserException;
import recoder.convenience.TreeWalker;
import recoder.io.PropertyNames;
import recoder.io.SourceFileRepository;
import recoder.java.CompilationUnit;
import recoder.java.ProgramElement;
import recoder.java.declaration.ClassDeclaration;

public class JUnitGen{
	public String output = "";
	public Class  cls = null;
	public ArrayList<Method> method = null;
	public ClassDeclaration classDeclaration = null;
	//public List<CompilationUnit> cul;
	public CompilationUnit cul;
	public static CrossReferenceServiceConfiguration crsc;
	public JUnitGen(){
		cls = new Class();
		method = new ArrayList<Method>();
	}

	public static CompilationUnit serviceConfiguration (String srcPath) {
		//create a service configuration
		crsc = new CrossReferenceServiceConfiguration();

		//set the path to source code ("src" folder). 
		//multiple source code paths, as well as paths to libraries, can be separated via ":" or ";".
		crsc.getProjectSettings().setProperty(PropertyNames.INPUT_PATH, srcPath);
		crsc.getProjectSettings().ensureSystemClassesAreInPath();

		//tell Recoder to parse all .java files it can find in the directory "src"
		SourceFileRepository sfr = crsc.getSourceFileRepository();
		CompilationUnit cul = null;
		try {
			//cul = sfr.getAllCompilationUnitsFromPath();
			cul = sfr.getCompilationUnitFromFile(srcPath);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//crsc.getChangeHistory().updateModel();
		return cul;
	}

	public void setPath(String srcPath){
		cul = serviceConfiguration(srcPath);
	}

	public void analyzeIt(){
		//for(CompilationUnit cunit : cul){
			TreeWalker tw = new TreeWalker(cul);
			while(tw.next()){
				ProgramElement pe = tw.getProgramElement();
				//Set class name
				if (pe instanceof ClassDeclaration) {
					classDeclaration = (ClassDeclaration)pe;
					cls.setName(classDeclaration.getFullName());
				}
				List<recoder.abstraction.Method> methods = classDeclaration.getMethods();
				for(recoder.abstraction.Method method : methods){
					Method m = new Method();
					m.setName(method.getName());
					m.setParameters(method.getFullSignature());
					m.setReturnedType(method.getReturnType().toString());
					m.setType(method.getTypes().toString());
					m.setExceptions(method.getExceptions());
					cls.addMethod(m);
				}
			}
		//}
	}
	public String returnedObjects(){
		String msg = "Nome: ";
		msg += cls.getName();
		
		for(Method mthd : cls.getMethods()){
			msg += "\n Método: ";
			msg += "Nome: "+mthd.getName();
			msg += "Parametros: "+mthd.getParameters();
			msg += "Variaveis: "+mthd.getVariables();
		}
		return msg;
	}
}
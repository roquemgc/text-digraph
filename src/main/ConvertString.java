package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ConvertString {

private String recebeTextoDoTxt;
private String textoDoTxtMinusculo;
private List<String> textoSeparado = new ArrayList<String>();
private List<String> textoSeparadoOrdenado = new ArrayList<String>();
private List<String> proximasPalavrasDasPalavras = new ArrayList<String>();
private List<String> textoFinal = new ArrayList<String>();
 
	public ConvertString(String recebeTextoDoTxt){
			
		this.recebeTextoDoTxt = recebeTextoDoTxt;
	}

	public void RemovePontuationsString(){	
	
		textoDoTxtMinusculo = recebeTextoDoTxt.toLowerCase();
		
		//textoDoTxtMinusculo = textoDoTxtMinusculo.replaceAll("¬.,@#/|!?%$&*()+=-—_§;][}{ºª'\\" , "");
		
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( ">" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "<" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "¬" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "." , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "," , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "@" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "#" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "/" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "|" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "!" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "?" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "%" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "$" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "&" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "*" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "(" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( ")" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "+" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "=" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "-" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "—" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "_" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "§" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( ";" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "]" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "[" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "}" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "{" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "º" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "ª" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "'" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "\\" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "\"" , "");
		textoDoTxtMinusculo = textoDoTxtMinusculo.replace( "\n" , "");

	}
	
	public void GuardarNovoTextoDoTxtEmLista(){
		
		String[] textoNormalizado = textoDoTxtMinusculo.split(" ");
		
		textoSeparado = Arrays.asList(textoNormalizado);
		
	}
	
	public void OrdenarArraysComPalavrasDoTextoTxt(){
		
		textoSeparadoOrdenado = new ArrayList<String>(textoSeparado);
		
		Collections.sort(textoSeparadoOrdenado);
		
	}
	
	public void ElaborandoTextoFinal() {
		
		int guardaIndicePalavra = -1;
		
		for(int indicePrincipal = 0; indicePrincipal < textoSeparado.size(); indicePrincipal++) {
		
			for(int i = 0; i < textoSeparado.size(); i++){
					
				int index = 0;
					
				if (textoSeparadoOrdenado.get(indicePrincipal).equals(textoSeparado.get(i))){
						
				    index = i;
				    	
				    index = index + 1;
				    	
				    if (textoSeparado.size() > index && !textoSeparado.get(index).equals(textoSeparadoOrdenado.get(indicePrincipal))) {
						
				    	guardaIndicePalavra = indicePrincipal;
				    	
				    	proximasPalavrasDasPalavras.add(textoSeparado.get(index));
							
					}
				}				
					
			}
			
			if(guardaIndicePalavra != -1 && proximasPalavrasDasPalavras.size() != 0 && !proximasPalavrasDasPalavras.isEmpty() && proximasPalavrasDasPalavras != null) {
			
			textoFinal.add(textoSeparadoOrdenado.get(guardaIndicePalavra));
			
			textoFinal.add(", "); // teste
			
			Collections.sort(proximasPalavrasDasPalavras);
			
			textoFinal.addAll(proximasPalavrasDasPalavras);
			
			textoFinal.add("\n"); // teste
			
			}
				
			proximasPalavrasDasPalavras.clear();
			
		}
			
		for (String string : textoFinal) {
			
			System.out.printf(string);
				
		}
	}
	
}



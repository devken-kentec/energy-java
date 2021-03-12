package br.com.kentec.energy.utils;

public class Utilitarios {
	
	public String formataDataString(String data) {
		String ano = "";
		String mes = "";
		String dia = "";
		ano = data.substring(0, 4);
		mes = data.substring(5, 7);
		dia = data.substring(8, 10);
		String dataFormatada = dia +"/"+mes+"/"+ano;
		return dataFormatada;
	}
	
	
	public String formatarCpfString(String cpf) {
		String p1 = cpf.substring(0, 3);
		String p2 = cpf.substring(3, 6);
		String p3 = cpf.substring(6, 9);
		String p4 = cpf.substring(9, 11);
		String cpfFormatado = p1+"."+p2+"."+p3+"-"+p4;
		
		return cpfFormatado;
	}
}

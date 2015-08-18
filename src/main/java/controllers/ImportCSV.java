package controllers;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import models.Pessoa;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


@Stateless 
public class ImportCSV {
	
	@EJB
	private PessoaController pessoaController;
	
	public void leCsv() throws IOException{
		Reader in = new FileReader("path/to/file.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		for (CSVRecord record : records) {
		    String lastName = record.get("Last Name");
		    Pessoa pessoa = new Pessoa();
		    pessoa.setNome(lastName);
		    pessoaController.salvaPessoa(pessoa);
		}
	}

}

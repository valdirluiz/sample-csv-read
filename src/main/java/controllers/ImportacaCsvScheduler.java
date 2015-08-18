package controllers;

import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

 
import org.jboss.ejb3.annotation.TransactionTimeout;


@Singleton
public class ImportacaCsvScheduler {
	
	@EJB
	private ImportCSV importacaCSV;  
	
	
	@Schedule(dayOfWeek = "*", hour = "*", minute = "*", second="*/30", persistent = false)
	@TransactionTimeout(unit = TimeUnit.HOURS, value = 10)
	public void perform() {
		try {
			importacaCSV.leCsv();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

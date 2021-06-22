package kira.formation.auth.demo.logging.loggers;

import kira.formation.auth.demo.logging.Logger;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasicLogger extends Logger{

	private String who;
	
	@Override
	public void log(String level, String who, String message) {
		System.out.println("level="+level+" : "+who+" :"+ message);
	}

}

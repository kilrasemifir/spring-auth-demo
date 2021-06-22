package kira.formation.auth.demo.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kira.formation.auth.demo.logging.loggers.BasicLogger;
import kira.formation.auth.demo.logging.loggers.ElasticLogger;
import kira.formation.auth.demo.logging.repositories.LogMessageRepository;

@Component
public class LoggerFactory {

	@Autowired
	private LogMessageRepository repository;
	
	public static Logger getLogger(String who) {
		BasicLogger logger = new BasicLogger(who);
		return logger;
	};
	
	public Logger getElasticLogger(String who) {
		return new ElasticLogger(who, repository);
	}
}

package kira.formation.auth.demo.logging;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kira.formation.auth.demo.logging.repositories.LogMessageRepository;

import kira.formation.auth.demo.logging.documents.LogMessage;

@Service
public class LogService {

	@Autowired
	private LogMessageRepository repository;
	
	public Iterable<LogMessage> findAll(){
		return this.repository.findAll();
	}

	public List<LogMessage> findAllByLevel(String level) {
		return repository.findAllByLevel(level);
	}

	public List<LogMessage> findAllByWho(String who) {
		return repository.findAllByWho(who);
	}
	
}

package kira.formation.auth.demo.logging;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kira.formation.auth.demo.logging.documents.LogMessage;

@RestController
@RequestMapping("logs")
@CrossOrigin
public class LogController {

	@Autowired
	private LogService service;
	
	@GetMapping("")
	public Iterable<LogMessage> findAll(){
		return this.service.findAll();
	}

	@GetMapping("level/{level}")
	public List<LogMessage> findAllByLevel(@PathVariable String level) {
		return service.findAllByLevel(level);
	}

	@GetMapping("who/{who}")
	public List<LogMessage> findAllByWho(@PathVariable String who) {
		return service.findAllByWho(who);
	}
	
	
}

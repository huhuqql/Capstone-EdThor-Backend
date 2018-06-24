package org.cmu.edthor.capstone.controller;

import java.util.List;

import org.cmu.edthor.capstone.model.Record;
import org.cmu.edthor.capstone.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ws")
public class RecordController {

	@Autowired
	private RecordRepository recordRepository;

	@RequestMapping(path = "/records", method = RequestMethod.POST)
	public void addRecord(@RequestBody Record r) {
		this.recordRepository.save(r);
	}
	
	@RequestMapping(path = "/records", method = RequestMethod.GET)
	public List<Record> getAllRecords() {
		return this.recordRepository.findAll();
	}

	@RequestMapping(path = "/records/", method = RequestMethod.GET)
	public List<Record> findByStudentId(@RequestParam Integer studentId){
		return this.recordRepository.findByStudentId(studentId);
	}
}

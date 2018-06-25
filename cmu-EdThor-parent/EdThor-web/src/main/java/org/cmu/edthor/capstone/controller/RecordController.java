package org.cmu.edthor.capstone.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.cmu.edthor.capstone.model.Record;
import org.cmu.edthor.capstone.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.cmu.edthor.capstone.BKT;


@RestController
@RequestMapping("/ws")
public class RecordController {

	@Autowired
	private RecordRepository recordRepository;
	private BKT bkt;

	@RequestMapping(path = "/records", method = RequestMethod.POST)
	public ArrayList<ArrayList<Double>> addRecord(@RequestBody Record r) {
		if (r.getId() == null) {
			r.setId(new ObjectId().toString());
		}
		this.recordRepository.save(r);
		
		ArrayList<ArrayList<Double>> finalList = new ArrayList<ArrayList<Double>>();
		List<Record> tempRecords;
		Integer[] tempKc;
		tempRecords = findByStudentId(r.getStudentId());
		tempKc = r.getProblemKc();
		for(int i = 0; i < tempKc.length; i++) {
			List<Record> kcRecord = new ArrayList<Record>();
			for(int j = 0; j < tempRecords.size();j++) {
				Record tempR = tempRecords.get(j);
				if(tempKc[i] == tempR.getProblemKc()[i]){
					kcRecord.add(tempR);
				}
			}
			int[] o = new int [kcRecord.size()];
			for(int j = 0; j < kcRecord.size();j++) {
				Record tempR = kcRecord.get(j);
				if(tempR.getProblemType() == 1){
					if(tempR.getProblemResult()[i] == false){
						o[j] = 0;
					}
					else{
						o[j] = 1;
					}
				}
				else{
					if(tempR.getProblemResult()[0] == false){
						o[j] = 0;
					}
					else{
						o[j] = 1;
					}
				}
			}
			ArrayList<Double> L = bkt.computePKnown(o);
			finalList.add(L);
		}
		return finalList;
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

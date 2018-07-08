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
	public void addRecord(@RequestBody Record r) {
		if (r.getId() == null) {
			r.setId(new ObjectId().toString());
		}
		List<Record> tempRecords;
		tempRecords = findByStudentId(studentId);
		for(int i = 0;i < tempRecords.size(); i++){
			if(tempRecords.get(i).getProblemId == r.getProblemId){
				return;
			}
		}
		this.recordRepository.save(r);
	}

	@RequestMapping(path = "/records/mastery/", method = RequestMethod.GET)
	public ArrayList<ArrayList<Double>> addRecord(@RequestParam Integer studentId) {
		ArrayList<ArrayList<Double>> finalList = new ArrayList<ArrayList<Double>>();
		List<Record> tempRecords;
		Integer[] tempKc = {1,2,3,4,5,6,7};
		tempRecords = findByStudentId(studentId);
		for(int i = 0; i < tempKc.length; i++) {
			BKT bkt  = new BKT(tempKc[i]);
			ArrayList<Integer> o = new ArrayList<Integer>();
			for(int j = 0; j < tempRecords.size();j++) {
				Record tempR = tempRecords.get(j);
				if(tempR.getProblemType() == 2 || tempR.getProblemType() == 3) {
					if(tempR.getProblemKc()[0] == tempKc[i]) {
						if(tempR.getProblemResult()[0] == true) {
							o.add(1);
						}
						else {
							o.add(0);
						}
					}
				}
				else {
					for(int k = 0; k < tempR.getProblemKc().length;k++) {
						if(tempR.getProblemKc()[k] == tempKc[i]) {
							if(tempR.getProblemLongquestionAnswer()[k] == true) {
								o.add(1);
							}
							else {
								o.add(0);
							}	
						}	
					}
				}
			}

			int[] oArray = new int[o.size()];
			for(int j = 0; j < oArray.length; j++) {
				oArray[j] = o.get(j);
			}
			ArrayList<Double> L = bkt.computePKnown(oArray);
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

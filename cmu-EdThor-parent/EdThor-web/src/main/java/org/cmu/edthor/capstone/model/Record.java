package org.cmu.edthor.capstone.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Record {

	@Id
	private String id;

	private Integer studentId;
	private Integer problemId;
	private Integer problemNum;
	private Integer problemType;
	private long problemDuration;
	private long[] problemStepDuration;
	private Integer[] problemKc;
	private boolean[] problemResult;
	private boolean[] problemLongquestionAnswer;
	private boolean[] problemLongquestionAnswerifAlternate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getProblemId() {
		return problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public Integer getProblemNum() {
		return problemNum;
	}

	public void setProblemNum(Integer problemNum) {
		this.problemNum = problemNum;
	}

	public Integer getProblemType() {
		return problemType;
	}

	public void setProblemType(Integer problemType) {
		this.problemType = problemType;
	}

	public long getProblemDuration() {
		return problemDuration;
	}

	public void setProblemDuration(long problemDuration) {
		this.problemDuration = problemDuration;
	}

	public boolean[] getProblemResult() {
		return problemResult;
	}

	public void setProblemResult(boolean[] problemResult) {
		this.problemResult = problemResult;
	}

	public boolean[] getProblemLongquestionAnswer() {
		return problemLongquestionAnswer;
	}

	public void setProblemLongquestionAnswer(boolean[] problemLongquestionAnswer) {
		this.problemLongquestionAnswer = problemLongquestionAnswer;
	}

	public Integer[] getProblemKc(){
		return problemKc;
	}

	public void setProblemKc(Integer[] problemKc){
		this.problemKc = problemKc;
	}

	public long[] getProblemStepDuration(){
		return problemStepDuration;
	}

	public void setProblemStepDuration(long[] problemStepDuration){
		this.problemStepDuration = problemStepDuration;
	}

	public boolean[] getProblemLongquestionAnswerifAlternate(){
		return problemLongquestionAnswerifAlternate;
	}

	public void setProblemLongquestionAnswerifAlternate(boolean[] problemLongquestionAnswerifAlternate){
		this.problemLongquestionAnswerifAlternate = problemLongquestionAnswerifAlternate;
	}

}

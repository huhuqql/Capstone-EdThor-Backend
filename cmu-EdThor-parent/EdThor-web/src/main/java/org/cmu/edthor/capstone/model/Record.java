package org.cmu.edthor.capstone.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Record {

	@Id
	private ObjectId id;

	private Integer student_id;
	private Integer problem_id;
	private Integer problem_num;
	private Integer problem_type;
	private long problem_duration;
	private boolean[] problem_answer;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return student_id;
	}

	public void setStudentId(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getProblemId() {
		return problem_id;
	}

	public void setProblemId(Integer problem_id) {
		this.problem_id = problem_id;
	}

	public Integer getProblemNum() {
		return problem_num;
	}

	public void setProblemNum(Integer problem_num) {
		this.problem_num = problem_num;
	}

	public Integer getProblemType() {
		return problem_type;
	}

	public void setProblemType(Integer problem_type) {
		this.problem_type = problem_type;
	}

	public long getProblemDuration() {
		return problem_duration;
	}

	public void setProblemDuration(long problem_duration) {
		this.problem_duration = problem_duration;
	}

	public boolean[] getProblemAnswer() {
		return problem_answer;
	}

	public void setProblemAnswer(boolean[] problem_answer) {
		this.problem_answer = problem_answer;
	}



}

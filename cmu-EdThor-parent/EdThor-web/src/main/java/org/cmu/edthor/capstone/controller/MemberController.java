package org.cmu.edthor.capstone.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.cmu.edthor.capstone.model.Member;
import org.cmu.edthor.capstone.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws")
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;

	@RequestMapping(path = "/members", method = RequestMethod.POST)
	public void addMember(@RequestBody Member m) {
		this.memberRepository.save(m);
	}

	@RequestMapping(path = "/members", method = RequestMethod.GET)
	public List<Member> getAllMembers() {
		return this.memberRepository.findAll();
	}

	@RequestMapping(path = "/members/", method = RequestMethod.GET)
	public Member findByName(@RequestParam String name){
		return this.memberRepository.findByName(name);
	}
	
	@RequestMapping(path = "/members/{id}", method = RequestMethod.GET)
	public Member findOne(@PathVariable String id){
		return this.memberRepository.findOne(new ObjectId(id));
	}
	
}

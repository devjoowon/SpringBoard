package my.spring.springboard.member.service;

import my.spring.springboard.member.vo.MemberVO;

public interface MemberService {
	
	public void register(MemberVO member) throws Exception;
	
	public MemberVO login(MemberVO member);
}

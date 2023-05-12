package my.spring.springboard.member.service;

import my.spring.springboard.member.vo.MemberVO;

public interface MemberService {
	
	public boolean registerMember(MemberVO member) throws Exception;
	
	public MemberVO login(MemberVO member);
	
//	public boolean updateMember
}

package my.spring.springboard.member.dao;

import my.spring.springboard.member.vo.MemberVO;

public interface MemberDAO {
	
	// 회원가입
	public void register(MemberVO member) throws Exception;
	
	// 로그인
	public MemberVO login(MemberVO member);
}

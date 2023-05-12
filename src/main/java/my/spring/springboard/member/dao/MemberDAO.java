package my.spring.springboard.member.dao;

import my.spring.springboard.member.vo.MemberVO;

public interface MemberDAO {
	
	// 회원가입
	public void insertMember(MemberVO member) throws Exception;
	
	// 로그인
	public MemberVO login(MemberVO member);
	
	// 회원정보 수정
	public void updateMember(MemberVO member) throws Exception;
}

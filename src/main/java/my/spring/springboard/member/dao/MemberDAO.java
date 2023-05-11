package my.spring.springboard.member.dao;

import my.spring.springboard.member.vo.MemberVO;

public interface MemberDAO {
	
	// 회원가입
	public void insertMember(MemberVO member) throws Exception;
}

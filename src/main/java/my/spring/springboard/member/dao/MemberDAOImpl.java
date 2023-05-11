package my.spring.springboard.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.spring.springboard.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void insertMember(MemberVO member) throws Exception {
		session.insert("myMember.insertMember", member);
		
	}
	
}

package my.spring.springboard.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.spring.springboard.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private Logger log = LogManager.getLogger("case3");

	@Autowired
	private SqlSession session;

	@Override
	public void insertMember(MemberVO member) throws Exception {
		
		int num = session.insert("myMember.insertMember", member);
		
		if (num != 1) { // 처음 값을 넣는데 1이 아니라면
			throw new Exception(); // 강제적으로 exception발생해서 던지는거. 그럼 try-catch문에서 rollback이 나오게 됨
		}
		
		log.debug("DB 삽입 완료");

	}

	@Override
	public MemberVO login(MemberVO member) {
		
		MemberVO dbMember = session.selectOne("myMember.login", member);
		
		return dbMember;
	}

	@Override
	public void updateMember(MemberVO member) throws Exception {
		
		int num = session.insert("myMember.updateMember", member);
		
		if (num != 1) {
			throw new Exception();
		}
		
		log.debug("DB 업데이트 완료");
	}
	

}

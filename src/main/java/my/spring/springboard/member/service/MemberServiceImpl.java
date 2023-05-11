package my.spring.springboard.member.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.spring.springboard.member.dao.MemberDAO;
import my.spring.springboard.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	private Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public void register(MemberVO member) {
		
		try {
			memberDao.register(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO login(MemberVO member) {

		return memberDao.login(member);
	}

}

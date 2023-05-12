package my.spring.springboard.member.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import my.spring.springboard.member.dao.MemberDAO;
import my.spring.springboard.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	private Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public boolean registerMember(MemberVO member) {
		
		TransactionStatus txStatus = 
				transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		boolean result = false;
		
		try {
			memberDao.insertMember(member);
			result = true;
			transactionManager.commit(txStatus);
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			transactionManager.rollback(txStatus);
		}
		
		return result;
	}

	@Override
	public MemberVO login(MemberVO member) {

		return memberDao.login(member);
	}

}

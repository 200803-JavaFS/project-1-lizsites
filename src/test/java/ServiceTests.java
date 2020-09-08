import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.ReimbursementStatusDAO;
import com.revature.dao.ReimbursementStatusDAOImp;
import com.revature.dao.ReimbursementTypeDAO;
import com.revature.dao.ReimbursementTypeDAOImp;
import com.revature.dao.ReimbursementsDAO;
import com.revature.dao.ReimbursementsDAOImp;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.ERSUser;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.services.Proj1LoginService;
import com.revature.services.ReimbursementService;

public class ServiceTests {
	public static ERSUser u;
	public static Reimbursement r;
	public static Proj1LoginService user = new Proj1LoginService();
	public static ReimbursementService reimb = new ReimbursementService();
	public static UserDAO userDAO = new UserDAOImp();
	public static ReimbursementsDAO reimbursementDAO = new ReimbursementsDAOImp();
	public static ReimbursementStatusDAO statusDAO = new ReimbursementStatusDAOImp();
	public static ReimbursementTypeDAO typeDAO = new ReimbursementTypeDAOImp();
	public static LoginDTO l = new LoginDTO();
	
	@BeforeClass
	public static void init() {
		u = userDAO.getUserByUsername("melia23");
		System.out.println(u);
		Reimbursement rd = new Reimbursement();
		r = new Reimbursement(400, null, null, "JUnit test",
			u, null, new ReimbursementStatus(3,"PENDING"),
			new ReimbursementType(1,"FOOD"));
		System.out.println(r);
		boolean result = reimb.addReimbursement(r);
		assertTrue(result);
	}
	
	@Test
	public void getUser() {
		ERSUser result = userDAO.getUserByUsername("jill1");
		System.out.println(result);
		assertTrue(result.getUserId()==2);
	}
	@Test
	public void approve() {
		r.setReimbursementStatus(statusDAO.getStatus(2));
		System.out.println(r);
		assertTrue(reimb.updateReimbursement(r));
	}
	@Test
	public void seeReimbursements() {
		List<Reimbursement> result = reimb.seeReimbursements(u);
		assertTrue(result!=null);
	}
	
	@Test
	public void loginAttempt() {
		l.username = "jill1";
		l.password = "password";
		
		assertTrue(user.login(l));
		
	}
	
	@Test
	public void seeReimbursementsByStatus() {
		List<Reimbursement> result = reimb.seeReimbursementsByStatusId(2);
		assertTrue(result != null);
	}
	@After
	public void breakDownTest() {
		
	}
	@AfterClass
	public static void breakDownWholeTest() {
		reimbursementDAO.removeReimbursement(r.getReimbursementId());
	}
}

package ss.bshop.gen;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IManagerDAO;
import ss.bshop.dao.IUserDAO;
import ss.bshop.domain.Manager;
import ss.bshop.domain.User;

@Transactional
public class Fill {
	
	@Autowired
	private IManagerDAO managerDao;
	
	@Autowired
	private IUserDAO userDao;

	@Test
	public void createUsers() {
		
		String[] login={"lora", "ada", "mur", "bot", "robot","dog", "kiss", "lapa", "vovan", "murzik",
						"zver","candy","kid", "pretty", "ola", "malchik", "victory", "hope", "mimi","stupid",
						"man","lady","orc", "trololo", "stone", "goodwin", "apple", "nobody", "oner","kicker",
						"pen","ten","oracle", "zip", "rar", "skype", "sql", "eclipse", "teem","stream"};
		
		String[] fullname={"Pupkin V.T","Vladov I.I","Korj L.M","Opal K.G","Martin O.P","Gregor N.M"," Loft H.J.","Miller M.M","Nivada L.K","Frozen G.T.",
							"Lorik N.N","Fauler J.K","Cho J.J","Who M.I","Why I.Z","Look M.N","Duck M.K","Loop J.G","Viver N.F","Opa O.O",
							"Banana I.I","Look A.M","Star J.T","Somebody I.M","Gregorovich V.N","Loo K.K","Mouse M.M","Tomson M.M","Bot F.F","Stivenson H.F",
							"Pupkina V.T","Vladova I.I","Korjikova L.M","Opala K.G","Martina O.P","Gregora N.M"," Lofta H.J.","Millera M.M","Nivadaina L.K","Frozen G.T."};
		
		for(int i=0; i<40; i++){
		User user =new User();
		user.setLogin(login[i]);
		String password=  (UUID.randomUUID().toString()).substring(0, 5);
		user.setPassword(password);
		user.setFullname(fullname[i]);
		user.setPost("manager");
		userDao.addUser(user);
		Manager manager=new Manager();
		manager.setUser(user);
		managerDao.addManager(manager);
		}
		
	}

}

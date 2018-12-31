package cn.itcast.bos.qbc.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.bos.domain.auth.Function;
import cn.itcast.bos.domain.auth.Role;
import cn.itcast.bos.domain.bc.Subarea;
import cn.itcast.bos.domain.user.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AUTH_USER {
	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void demo1() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		User user=new User();
		Role role=new Role();
		Function function=new Function();
		Set<User> users=new HashSet<User>();
		Set<Role> roles=new HashSet<Role>();
	
		user.setId("1");
		user.setUsername("keil");
		user.setPassword("198688");
		user.setRole(role);
		users.add(user);
		
		
		role.setId("1");
		role.setName("admin");
		role.setDescription("管理员");
		
		role.setUsers(users);
		
		
		
        hibernateTemplate.update(user);
        hibernateTemplate.update(role);
       
	}
}

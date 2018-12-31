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
import cn.itcast.bos.domain.zm.ZhongZhuanInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ZhongZhuanInfotest {
	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void demo1() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		ZhongZhuanInfo zhongZhuanInfo = new ZhongZhuanInfo();
	
		zhongZhuanInfo.setArrive("0");
		zhongZhuanInfo.setId("55");
		/*zhongZhuanInfo.setWorkOrderManage(persistWorkOrderManage);*/// 关联工作单 信息
		// 对ZhongZhuanInfo 进行持久化
	
		hibernateTemplate.save(zhongZhuanInfo);
     
       
	}
}

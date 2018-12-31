package cn.itcast.bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.bos.dao.GenericDAO;
import cn.itcast.bos.page.PageResponseBean;

/**
 * 通用DAO 实现
 * 
 * @author seawind
 * 
 */
public class GenericDAOImpl<T> extends HibernateDaoSupport implements GenericDAO<T> {

	private String className;

	public GenericDAOImpl(String className) {
		this.className = className;
	}

	public void save(T obj) {
		// this.getSession(); // 使用原始 hibernate编程方式
		// this.getHibernateTemplate(); // 使用 Spring 提供模板工具类
		this.getHibernateTemplate().save(obj);
	}

	public void update(T obj) {
		this.getHibernateTemplate().update(obj);
	}

	public void delete(T obj) {
		this.getHibernateTemplate().delete(obj);
	}

	
	// DbUitls new BeanHandler<User>(User.class);
	public T findById(Serializable id) {
		Class<?> clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (T) this.getHibernateTemplate().get(clazz, id);
	}


	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from " + className);// 注意空格
	}


	public List<T> findByNamedQuery(String queryName, Object... values) {
		return (List<T>) this.getHibernateTemplate().findByNamedQuery(queryName, values);
	}


	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}


	public long findTotalCount(DetachedCriteria detachedCriteria) {
		// select count(*) from bc_standard
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria, 0, 1);
		return list.get(0);
	}


	public List<T> pageQuery(DetachedCriteria detachedCriteria, int firstResult, int maxResults) {
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
	}


	public void saveOrUpdate(T obj) {
		this.getHibernateTemplate().saveOrUpdate(obj);
	}

	public PageResponseBean queryByLucene(String conditionName, String conditionValue, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}


	/*@SuppressWarnings("all")
	public PageResponseBean queryByLucene(String conditionName, String conditionValue, int page, int rows) {
		// Hibernate Search 编程步骤
		// 1、 获得Session
		Session session = this.getSession();
		// 2、 获得全文检索Session
		FullTextSession fullTextSession = new FullTextSessionImpl(session);
		// 3、编写lucene的Query对象 （词条模糊搜索）
		Query query = new WildcardQuery(new Term(conditionName, "*" + conditionValue + "*"));
		// 4、获得全文检索的Query
		FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query);

		PageResponseBean pageResponseBean = new PageResponseBean();
		// 查询总记录数
		pageResponseBean.setTotal(fullTextQuery.getResultSize());

		// 当前页数据
		int firstResult = (page - 1) * rows;
		int maxResults = rows;
		List list = fullTextQuery.setFirstResult(firstResult).setMaxResults(maxResults).list();
		pageResponseBean.setRows(list);

		return pageResponseBean;
	}*/

}

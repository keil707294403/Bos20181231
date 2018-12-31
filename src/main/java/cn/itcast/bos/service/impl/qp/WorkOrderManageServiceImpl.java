package cn.itcast.bos.service.impl.qp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.api.ExecutionService;

import cn.itcast.bos.domain.qp.WorkOrderManage;
import cn.itcast.bos.domain.zm.ZhongZhuanInfo;
import cn.itcast.bos.page.PageRequestBean;
import cn.itcast.bos.page.PageResponseBean;
import cn.itcast.bos.service.base.BaseService;
import cn.itcast.bos.service.qp.WorkOrderManageService;

/**
 * 工作单管理实现类
 * 
 * @author seawind
 * 
 */
public class WorkOrderManageServiceImpl extends BaseService implements WorkOrderManageService {


	public void saveOrUpdate(WorkOrderManage workOrderManage) {
		System.out.println("workOrderManage5555");
		workOrderManageDAO.save(workOrderManage);
	}


	public PageResponseBean pageQuery(PageRequestBean pageRequestBean) {
		return pageQuery(pageRequestBean, workOrderManageDAO);
	}


	public PageResponseBean queryByLucene(String conditionName, String conditionValue, int page, int rows) {
		return workOrderManageDAO.queryByLucene(conditionName, conditionValue, page, rows);
	}


	public List<WorkOrderManage> listUnCheckWorkOrderManages() {
		// managerCheck = '0'
		return workOrderManageDAO.findByNamedQuery("WorkOrderManage.listUnChecked");
	}


	public void check(WorkOrderManage workOrderManage) {
		// 操作一 ： 将 工作单 managerCheck 属性值 设置为 1
		WorkOrderManage persistWorkOrderManage = workOrderManageDAO.findById(workOrderManage.getId()); // 持久工作单对象
		persistWorkOrderManage.setManagerCheck("1");
		System.out.println(workOrderManage.getId());
		// 操作二 ： 启动中转配送流程
		ExecutionService executionService = processEngine.getExecutionService();
		// 在启动流程时，关联流程实例 对应 全局 中转信息对象
		ZhongZhuanInfo zhongZhuanInfo = new ZhongZhuanInfo();
		zhongZhuanInfo.setArrive("0");// 未到达
		zhongZhuanInfo.setWorkOrderManage(persistWorkOrderManage);// 关联工作单 信息
		// 对ZhongZhuanInfo 进行持久化
		zhongZhuanInfoDAO.save(zhongZhuanInfo);

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("zhongZhuanInfo", zhongZhuanInfo);
        System.out.println(workOrderManage.getId());
		executionService.startProcessInstanceByKey("transfer", variables);

	}
}

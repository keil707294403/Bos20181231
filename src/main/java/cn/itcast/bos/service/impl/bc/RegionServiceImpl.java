package cn.itcast.bos.service.impl.bc;

import java.util.List;

import cn.itcast.bos.domain.bc.Region;
import cn.itcast.bos.page.PageRequestBean;
import cn.itcast.bos.page.PageResponseBean;
import cn.itcast.bos.service.base.BaseService;
import cn.itcast.bos.service.bc.RegionService;

public class RegionServiceImpl extends BaseService implements RegionService {


	public void saveRegion(Region region) {
		regionDAO.save(region);
	}


	public PageResponseBean pageQuery(PageRequestBean pageRequestBean) {
		return pageQuery(pageRequestBean, regionDAO);
	}

	public List<Region> findAllRegions() {
		return regionDAO.findAll();
	}

}

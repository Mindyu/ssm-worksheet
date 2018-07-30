package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bean.Depot;
import com.java.bean.DepotExample;
import com.java.bean.Product;
import com.java.bean.ProductExample;
import com.java.dao.DepotMapper;

/**
 * 仓库service，负责仓库信息的增删改查
 * @author iprcc
 *
 */
@Service
public class DepotService {
	
	@Autowired
	private DepotMapper depotMapper;
	
	public int insertDepot(Depot depot) {
		int n = depotMapper.insertSelective(depot);
		return n;
	}
	public List<Depot> listDepotsBylimit(int currentPage, int pageSize) {
    	System.out.println("分页请求下：" + currentPage + ' ' + pageSize);
    	DepotExample example = new DepotExample();
    	example.setOffset((currentPage-1)*pageSize);
    	example.setLimit(pageSize);
        List<Depot> list = depotMapper.selectByExample(example);
        if (list != null) for (Depot prod:list) System.out.println(prod);
        return list;		
	}
	public long countDepots() {
		return depotMapper.countByExample(null);
	}
	// 根据 ID 删除仓库
	public int deleteDepotByID(Integer depotno) {
		int n = depotMapper.deleteByPrimaryKey(depotno);
		return n;
	}
	
	// 根据 ID 修改仓库信息，为空时，不修改数据库数据
	public int updateDepotByID(Depot depot) {
		int n = depotMapper.updateByPrimaryKeySelective(depot);
		return n;
	}
	
	// 根据 ID 查询仓库信息
	public Depot selectDepotByID(Integer depotno) {
		return depotMapper.selectByPrimaryKey(depotno);
	}
	
	// 选择所有的仓库信息
	public List<Depot> selectAllDepot(){
		return depotMapper.selectByExample(null);
	}
	
	// 查询仓库的数量
	public long getDepotCount() {
		
		return depotMapper.countByExample(null);
	}
}

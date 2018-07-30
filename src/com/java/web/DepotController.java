package com.java.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.bean.Depot;
import com.java.bean.Result;
import com.java.service.DepotService;

@Controller
public class DepotController {

	@Autowired
	private DepotService depotService;

	// 查询
	@RequestMapping(value = "/depotpage", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllDepot(int page, int rows) {
		long total = depotService.countDepots();
		List<Depot> list = depotService.listDepotsBylimit(page, rows);
		for (Depot depot : list)
			System.out.println(depot);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping(value = "/depot", method = RequestMethod.GET)
	@ResponseBody
	public List<Depot> getDepots() {
		return depotService.selectAllDepot();
	}
	// 查询
	@RequestMapping(value = "/depot/{depotno}", method = RequestMethod.GET)
	@ResponseBody
	public Depot getDepotByID(@PathVariable int depotno) {

		Depot depot = depotService.selectDepotByID(depotno);
		System.out.println(depot);

		return depot;
	}

	// 新增
	@RequestMapping(value = "/depot", method = RequestMethod.POST)
	@ResponseBody
	public Result<Depot> newDepot(@RequestBody Depot depot) {
		System.out.println("新增仓库：" + depot);
		Result<Depot> ret = new Result<>();
		int n = depotService.insertDepot(depot);
		if (n>0) {
			ret.setCode(201);
			ret.setMessage("CREATED");
			ret.setData(depot);
		}else {
			ret.setCode(206);
			ret.setMessage("FAILED");
			ret.setData(depot);
		}

		return ret;
	}
	
	// 修改
	@RequestMapping(value = "/depot", method = RequestMethod.PUT)
	@ResponseBody
	public Result<Depot> updateDepot(@RequestBody Depot depot) {
		depotService.updateDepotByID(depot);

		Result<Depot> ret = new Result<>();
		ret.setCode(200);
		ret.setMessage("SUCCESS");
		ret.setData(depot);

		return ret;
	}

	// 删除
	@RequestMapping(value = "/depot/{depotno}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<?> deleteDepot(@PathVariable Integer depotno) {
		System.out.println(depotno);

		depotService.deleteDepotByID(depotno);

		Result<Depot> ret = new Result<>();
		ret.setCode(204);
		ret.setMessage("NO CONTENT");

		return ret;
	}

	
}

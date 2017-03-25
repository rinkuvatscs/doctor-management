package com.medical.doctor.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.medical.doctor.entity.Cases;
import com.medical.doctor.service.CasesService;




@RestController
@RequestMapping("/api")
@Api(basePath = "/", value = "cases", description = "Operations with Landlords", produces = "application/json")
public class CasesController {

	@Autowired
	private CasesService caseService;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/cases/create")
	@ApiOperation(value = "create case", notes = "create case by doctor")
	public String createCase(@RequestBody Cases cases) {
		
		return caseService.createCase(cases);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/cases/close/{caseId}")
	@ApiOperation(value = "close case", notes = "close case by doctor")
	public String closeCaseByCaseId(@PathVariable Integer caseId) {
		
		return caseService.closeCase(caseId);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/cases/reopen/{caseId}")
	@ApiOperation(value = "reopen case", notes = "reopen case by doctor")
	public String reopenCaseByCaseId(@PathVariable Integer caseId) {
		
		return caseService.reopenCase(caseId);
	}
	
}

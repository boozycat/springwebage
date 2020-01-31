package com.health.service;

 
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.health.core.HealthPlan;
@Component @Profile("prod")
public class HealthPlanDAOImpl implements HealthPlanDAO{
	@Autowired
	private JdbcTemplate template;
	private final String SELECT = "SELECT planid as id, zip, name, OUTOFPOCKETIND as deductableIndividual, deductableFamily, OUTOFPOCKETIND as outOfPocketIndividual, outOfPocketFamily, copay FROM PLAN p";
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	 
	public List<HealthPlan> getPlans(){
		String sql = SELECT;
		return template.query(sql,BeanPropertyRowMapper.newInstance(HealthPlan.class));
	}


	@Override
	public HealthPlan getPlan(long id) {
		String sql = SELECT + " where p.planid = ?";
		return template.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(HealthPlan.class));
	}
	      

	@Override
	public void add(HealthPlan plan) {
		String sql = "INSERT INTO PLAN (ZIP, NAME, DEDUCTABLEIND, DEDUCTABLEFAMILY, OUTOFPOCKETIND, OUTOFPOCKETFAMILY, COPAY) VALUES(?,?,?,?,?,?,?)";
		template.update(sql, new Object[]{plan.getZip(), plan.getName(), plan.getDeductableIndividual(), plan.getDeductableFamily(), plan.getOutOfPocketIndividual(), plan.getOutOfPocketIndividual(), plan.getCopay()});
	}
	
	 

}

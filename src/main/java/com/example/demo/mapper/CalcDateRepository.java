package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.CalcDate;

@Mapper
public interface CalcDateRepository {
	
	@Select("select * from calcDate where dateId=#{dateId}")
	List<CalcDate> selectAll();
	
	@Select("select * from calcDate where dateId=#{dateId}")
	CalcDate findOne(String dateId);
	
	@Insert("insert into calcDate values(#{dateId},#{dateName},#{valueYear},#{valueMonth},#{valueDay})")
	void save(CalcDate date);
	
	@Update("update calcDate set dateName =#{dateName},valueYear=#{valueYear},valueMonth=#{valueMonth},valueDay=#{valuDay}")
	void update(CalcDate date);
	
	@Delete("delete from calcDate where dateId =#{dateId}")
	void delete(String dateId);

}

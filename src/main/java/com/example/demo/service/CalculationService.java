package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.CalcDate;
import com.example.demo.mapper.CalcDateRepository;

@Service
public class CalculationService {

	// DI（依存性の注入）
	@Autowired
	private CalcDateRepository calcDateRepository;

	// 日付計算式の一覧を全件検索して取得する
	public List<CalcDate> search() {
		return calcDateRepository.selectAll();

	}

	// 日付計算式を取得
	public CalcDate search(String dateId) {
		return calcDateRepository.selectPK(dateId);
	}

	// 日付計算式を登録
	@Transactional
	public void entry(CalcDate calcDate) {
		calcDateRepository.insert(calcDate);
	}

	// 日付計算式を更新
	@Transactional
	public void update(CalcDate calcDate) {
		calcDateRepository.update(calcDate);
	}

	// 日付計算式を削除
	@Transactional
	public void delete(String dateId) {
		calcDateRepository.delete(dateId);
	}

	// 計算準備をベースに日付計算式の加減値にとづいて計算を行う
	// 計算後の書式は「ｙｙｙｙMMｄｄ」の文字列となる
	public String calclate(String baseDate, CalcDate calcDate) {
		LocalDate date = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate caluculatedDate = date.plusYears(calcDate.getValueYear()).plusMonths(calcDate.getValueMonth())
				.plusDays(calcDate.getValueDay());
		return caluculatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

}

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

	// DI�i�ˑ����̒����j
	@Autowired
	private CalcDateRepository calcDateRepository;

	// ���t�v�Z���̈ꗗ��S���������Ď擾����
	public List<CalcDate> search() {
		return calcDateRepository.selectAll();

	}

	// ���t�v�Z�����擾
	public CalcDate search(String dateId) {
		return calcDateRepository.selectPK(dateId);
	}

	// ���t�v�Z����o�^
	@Transactional
	public void entry(CalcDate calcDate) {
		calcDateRepository.insert(calcDate);
	}

	// ���t�v�Z�����X�V
	@Transactional
	public void update(CalcDate calcDate) {
		calcDateRepository.update(calcDate);
	}

	// ���t�v�Z�����폜
	@Transactional
	public void delete(String dateId) {
		calcDateRepository.delete(dateId);
	}

	// �v�Z�������x�[�X�ɓ��t�v�Z���̉����l�ɂƂÂ��Čv�Z���s��
	// �v�Z��̏����́u��������MM�����v�̕�����ƂȂ�
	public String calclate(String baseDate, CalcDate calcDate) {
		LocalDate date = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate caluculatedDate = date.plusYears(calcDate.getValueYear()).plusMonths(calcDate.getValueMonth())
				.plusDays(calcDate.getValueDay());
		return caluculatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

}

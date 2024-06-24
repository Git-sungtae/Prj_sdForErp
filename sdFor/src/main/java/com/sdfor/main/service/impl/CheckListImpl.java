package com.sdfor.main.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sdfor.main.service.CheckList;

public class CheckListImpl implements CheckList{
	

	@Override
	public int addExecutor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addExecutionDate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addInsulationQuench() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addWearStrengthNoise() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addCorrosionCrackOther() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addYearsElapsed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addInstallationEnvmt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addOperationFreq() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addFailDisruptionFreq() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProductDiscon() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addEquipmentCap() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> getCheckList(String facilityCode) {
		String[] dummyArr = {"21D13010001", "장성태", "4", "4", "5", "5", "4", "5", "5", "5", "3"};
		List<String> strChekList = Arrays.asList(dummyArr);
		List<Integer> excludedIndexes = Arrays.asList(0, 1);
		List<Integer> checkList = new ArrayList<Integer>();
		
		for (int i = 0; i < strChekList.size(); i++) {
			if (!excludedIndexes.contains(i)) {
				String str = strChekList.get(i);
				checkList.add(Integer.parseInt(str));
			}
		}
		
		return checkList;
	}

	@Override
	public int calTestScore(String facilityCode) {
		double safeScore = 0.0;
		double durablityScore = 0.0;
		double useScore = 0.0;
		double finalSafeScore = 0.0;
		double finalDurablityScore = 0.0;
		double finalUseScore = 0.0;
		
		List<Integer> checkList = getCheckList(facilityCode);
		// 추후에 db에서 꺼내오는 것으로 수정
		// 중요도 산정
		List<Integer> impAssess = Arrays.asList(25, 5, 10, 10, 15, 5, 15, 5, 10);
		
		List<Integer> testTotal = new ArrayList<Integer>();
		
		for (int i = 0; i < checkList.size(); i++) {
			int mf = checkList.get(i) * impAssess.get(i);
			testTotal.add(mf);
		}
		
		// 추후에 db에서 꺼내오는 것으로 수정
		// 주요소 보조요소 가중치
		List<Double> safeWgt = Arrays.asList(1.0, 0.7, 0.3, 0.0, 0.0, 0.3, 0.2, 0.0, 0.0);
		for (int i = 0; i < testTotal.size(); i++) {
			safeScore += testTotal.get(i) * safeWgt.get(i);
		}
		
		List<Double> durabilityWgt = Arrays.asList(0.0, 0.3, 0.7, 1.0, 0.7, 0.0, 0.2, 0.0, 0.0);
		for (int i = 0; i < testTotal.size(); i++) {
			durablityScore += testTotal.get(i) * durabilityWgt.get(i);
		}
		
		List<Double> useWgt = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.3, 0.7, 0.6, 1.0, 1.0);
		for (int i = 0; i < testTotal.size(); i++) {
			useScore += testTotal.get(i) * useWgt.get(i);
		}
		
		System.out.println(safeScore);
		System.out.println(durablityScore);
		System.out.println(useScore);
		
		double mfWeight = 0.0;
		for (int i = 0; i < safeWgt.size(); i++) {
			mfWeight += impAssess.get(i) * safeWgt.get(i);
		}
		finalSafeScore = safeScore / mfWeight;
		
		mfWeight = 0.0;
		for (int i = 0; i < safeWgt.size(); i++) {
			mfWeight += impAssess.get(i) * durabilityWgt.get(i);
		}
		finalDurablityScore = durablityScore / mfWeight;
		
		mfWeight = 0.0;
		for (int i = 0; i < safeWgt.size(); i++) {
			mfWeight += impAssess.get(i) * useWgt.get(i);
		}
		finalUseScore = useScore / mfWeight;
		
		return 0;
	}
	
	private String scoreGrade(double score) {
		String grade;
		
		 if (score > 4.5 && score <= 5.5) {
	            grade = "A";
	        } else if (score > 3.5 && score <= 4.5) {
	        	grade = "B";
	        } else if (score > 2.5 && score <= 3.5) {
	        	grade = "C";
	        } else if (score > 1.5 && score <= 2.5) {
	        	grade = "D";
	        } else if (score >= 1.0 && score <= 1.5) {
	        	grade = "E";
	        } else {
	        	grade = "Invalid value"; 
	        }
		
		return grade;
		
	}

}

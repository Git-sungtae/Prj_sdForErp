package com.sdfor.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CheckList {
	
	int addExecutor();
	int addExecutionDate();
	int addInsulationQuench();
	int addWearStrengthNoise();
	int addCorrosionCrackOther();
	int addYearsElapsed();
	int addInstallationEnvmt();
	int addOperationFreq();
	int addFailDisruptionFreq();
	int addProductDiscon();
	int addEquipmentCap();
	
	List<Integer> getCheckList(String facilityCode);
	
	int calTestScore(String facilityCode);

}

package com.fis.origenate.batchsftp;

import javax.annotation.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fis.origenate.batchsftp.constants.ConfigurationConstants;
import com.fis.origenate.batchsftp.service.impl.CommandLineParamsServiceImpl;

/*
 *   Created by SP00597539m, FEB 21, 2019.
 */

@SpringBootApplication
public class DfulfillmentBatchSftpApplication implements ApplicationRunner {

	
	static final Logger logger = LoggerFactory.getLogger(DfulfillmentBatchSftpApplication.class);

	@Autowired
	public CommandLineParamsServiceImpl commandlineparams;

	public static void main(String[] args) {

		SpringApplication.run(DfulfillmentBatchSftpApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		logger.info("Document Folder Location : " + commandlineparams.getDocumentFolderLocation() + args.getOptionValues(ConfigurationConstants.DocumentFolderLocationPath));
		

	}

	

}

package com.fis.origenate.batchsftp.service.impl;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.fis.origenate.batchsftp.service.SecuredFileTransferService;

@Service
public class SecuredFileTransferServiceImpl implements SecuredFileTransferService {

	Logger logger = LoggerFactory.getLogger(SecuredFileTransferServiceImpl.class);

	@Override
	public void transferFileToFis(File file) {

		logger.info("SFTP Service: " + file.getName() + " Thread Name :" + Thread.currentThread().getName());

	}

}

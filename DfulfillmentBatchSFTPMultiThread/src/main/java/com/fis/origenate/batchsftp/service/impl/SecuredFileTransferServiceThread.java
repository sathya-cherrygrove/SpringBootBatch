package com.fis.origenate.batchsftp.service.impl;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fis.origenate.batchsftp.service.SecuredFileTransferService;

public class SecuredFileTransferServiceThread implements SecuredFileTransferService, Runnable {
	
	Logger logger = LoggerFactory.getLogger(SecuredFileTransferServiceImpl.class);
    private File pdfFile;
    public SecuredFileTransferServiceThread(File file) {
		this.pdfFile = file;
	}

	@Override
	public void run() {
		
		transferFileToFis(this.pdfFile);

	}

	@Override
	public void transferFileToFis(File file) {
		
		logger.info("SFTP Service: " + file.getName() + " Thread Name :" + Thread.currentThread().getName());

	}

}

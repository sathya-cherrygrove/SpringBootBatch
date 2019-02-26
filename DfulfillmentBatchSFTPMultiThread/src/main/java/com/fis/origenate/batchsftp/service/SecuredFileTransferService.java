package com.fis.origenate.batchsftp.service;

import java.io.File;

import org.springframework.stereotype.Service;


public interface SecuredFileTransferService {

	public void transferFileToFis(File file);

}

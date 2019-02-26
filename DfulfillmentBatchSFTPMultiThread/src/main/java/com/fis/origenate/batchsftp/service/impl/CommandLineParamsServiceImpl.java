package com.fis.origenate.batchsftp.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fis.origenate.batchsftp.service.CommandLineParamsService;

@Service
public class CommandLineParamsServiceImpl implements CommandLineParamsService {

	private CommandLineParamsServiceImpl() {

	}

	@Value("${DocumentFolderLocationPath}")
	public String DocumentFolderLocationPath;

	@Value("${PdfDocumentLocation}")
	public String PdfDocumentLocation;

	@Value("${maxNumberOfConcurrentThreads}")
	public Integer maxNumberOfConcurrentThreads;

	public String getDocumentFolderLocation() {
		return DocumentFolderLocationPath;
	}

	public String getPdfDocumentLocation() {
		return PdfDocumentLocation;
	}

	public Integer getMaxNumberOfConcurrentThreads() {
		return maxNumberOfConcurrentThreads;
	}

}

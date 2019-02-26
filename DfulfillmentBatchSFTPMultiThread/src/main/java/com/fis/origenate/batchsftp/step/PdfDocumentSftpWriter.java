package com.fis.origenate.batchsftp.step;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.TransactionAwareProxyFactory;
import org.springframework.context.annotation.Bean;
import com.fis.origenate.batchsftp.service.impl.SecuredFileTransferServiceImpl;
import com.fis.origenate.batchsftp.service.impl.SecuredFileTransferServiceThread;

public class PdfDocumentSftpWriter implements ItemWriter<File> {

	SecuredFileTransferServiceImpl securedfiletransferserviceimpl;

	List<File> pdfDocumentOutput = TransactionAwareProxyFactory.createTransactionalList();
	
	ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

	private static final Logger logger = LoggerFactory.getLogger(PdfDocumentSftpWriter.class);

	@Override
	public synchronized void write(List<? extends File> pdfDocuments) throws Exception {

		System.out.println("Write Thread Name : "+ Thread.currentThread().getName() + " Processing Files : "+ pdfDocuments);
		//pdfDocuments.stream().forEach(pdffile -> new SecuredFileTransferServiceImpl().transferFileToFis(pdffile));
		//pdfDocuments.stream().forEach(pdffile -> new Thread(new SecuredFileTransferServiceThread(pdffile)).start());
		pdfDocuments.stream().forEach(pdffile -> executor.execute(new SecuredFileTransferServiceThread(pdffile)));
		
		
	}

	public List<File> getPdfDocumentOutput() {

		return pdfDocumentOutput;
	}

}

package com.fis.origenate.batchsftp.step;

import java.io.File;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class PdfDocumentSftpWriter implements ItemWriter<File> {
	
	private static final Logger logger = LoggerFactory.getLogger(PdfDocumentSftpWriter.class);

	@Override
	public void write(List<? extends File> pdfDocuments) throws Exception {

		for (File pdffile : pdfDocuments) {
			System.out.println(pdffile.getName());
		}

	}

}

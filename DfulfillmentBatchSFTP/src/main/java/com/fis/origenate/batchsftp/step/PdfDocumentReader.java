package com.fis.origenate.batchsftp.step;

import java.io.File;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class PdfDocumentReader implements ItemReader<File> {

	private List<File> pdfDocumentList;
	private int documentCount = 0;

	@Override
	public File read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		if (documentCount < pdfDocumentList.size()) {
			return pdfDocumentList.get(documentCount++);
		} else {
			return null;
		}
	}

	public List<File> getPdfDocumentList() {
		return pdfDocumentList;
	}

	public PdfDocumentReader setPdfDocumentList(List<File> pdfDocumentList) {
		this.pdfDocumentList = pdfDocumentList;
		return this;
	}

}

package com.fis.origenate.batchsftp.config;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import com.fis.origenate.batchsftp.service.impl.CommandLineParamsServiceImpl;
import com.fis.origenate.batchsftp.step.PdfDocumentReader;
import com.fis.origenate.batchsftp.step.PdfDocumentSftpWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	CommandLineParamsServiceImpl commandlineparams;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Value("DocumentFolderLocation")
	private Resource[] resources;

	@Bean
	public Job processJob() throws IOException {
		return jobBuilderFactory
				.get("processJob")
				.incrementer(new RunIdIncrementer())
				.flow(orderStep1())
				.end()
				.build();

	}

	@Bean
	public Step orderStep1() throws IOException {
		return stepBuilderFactory
				.get("orderStep1")
				.<File, File>chunk(5)
				.reader(reader().setPdfDocumentList(getPdfDocuments()))
				.writer(writer())
				.build();
	}

	@Bean
	public PdfDocumentSftpWriter writer() {
		return new PdfDocumentSftpWriter();
	}

	@Bean
	public PdfDocumentReader reader() {
		return new PdfDocumentReader();
	}

	@Bean
	public List<File> getPdfDocuments() {
		File dir = new File(commandlineparams.getPdfDocumentLocation());
		return Stream.of(dir.listFiles()).filter(file -> file.getName().toLowerCase().endsWith(".pdf"))
				.collect(Collectors.toList());
		
	}

}
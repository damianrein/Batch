package com.Batch.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.Batch.repositories.ITransferPaymentRepository;

public class ValidateAccountTasklet implements Tasklet {

	@Autowired
	private ITransferPaymentRepository transferPaymentRepository;
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		boolean filterIsAproved = true;
		
		
		return null;
	}

}

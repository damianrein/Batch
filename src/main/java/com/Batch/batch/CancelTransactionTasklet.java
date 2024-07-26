package com.Batch.batch;

import org.jboss.logging.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.Batch.repositories.ITransferPaymentRepository;


public class CancelTransactionTasklet implements Tasklet {

	//Logger log = Logger.getLogger(CancelTransactionTasklet.class);
    @Autowired
    private ITransferPaymentRepository transferPaymentRespository;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        String transactionId = chunkContext.getStepContext()
                .getStepExecution()
                .getJobParameters()
                .getString("transactionId");

        String errorMessage = chunkContext.getStepContext()
                                          .getStepExecution()
                                          .getJobExecution()
                                          .getExecutionContext()
                                          .getString("message");

        return RepeatStatus.FINISHED;
    }
}

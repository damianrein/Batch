package com.Batch.batch;

import org.jboss.logging.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.Batch.entities.TransferPaymentEntity;
import com.Batch.repositories.ITransferPaymentRepository;

public class ValidateAccountTasklet implements Tasklet {

	Logger log = Logger.getLogger(ValidateAccountTasklet.class);
	@Autowired
	private ITransferPaymentRepository transferPaymentRepository;
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		boolean filterIsAproved = true;
		
        String transactionId = chunkContext.getStepContext()
                .getStepExecution()
                .getJobParameters()
                .getString("transactionId");
        
        TransferPaymentEntity transferPaymentEntity = transferPaymentRepository.findById(transactionId).orElseThrow();
        
        if (!transferPaymentEntity.isEnabled()) {
            // Error porque la cuenta esta inactiva
            chunkContext.getStepContext()
                    .getStepExecution()
                    .getJobExecution()
                    .getExecutionContext()
                    .put("message", "Error, la cuenta se eencuentra inactiva.");

            filterIsAproved = false;
        }

        if (transferPaymentEntity.getAmountPaid().compareTo(transferPaymentEntity.getAvariableBalance()) > 0) {
            // Error porque el saldo es insuficiente
            chunkContext.getStepContext()
                    .getStepExecution()
                    .getJobExecution()
                    .getExecutionContext()
                    .put("message", "Error, el saldo del cliente es insuficiente.");

            filterIsAproved = false;
        }

        chunkContext.getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext()
                .put("transactionObject", transferPaymentEntity);

        ExitStatus exitStatus = null;
        if (filterIsAproved) {

            exitStatus = new ExitStatus("VALID");
            stepContribution.setExitStatus(exitStatus);
        } else {

            exitStatus = new ExitStatus("INVALID");
            stepContribution.setExitStatus(exitStatus);
        }

        return RepeatStatus.FINISHED;
	}

}

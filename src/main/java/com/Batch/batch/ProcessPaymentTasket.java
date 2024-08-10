package com.Batch.batch;

import org.jboss.logging.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.Batch.repositories.ITransferPaymentRepository;

public class ProcessPaymentTasket implements Tasklet {

	Logger log = Logger.getLogger(ProcessPaymentTasket.class);
    @Autowired
    private ITransferPaymentRepository transferPaymentRepository;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        String transactionId = chunkContext.getStepContext()
                .getStepExecution()
                .getJobParameters()
                .getString("transactionId");

        log.info("------> Se procesa el pago de la transaccion {" + transactionId + "} exitosamente.");
        transferPaymentRepository.updateTransferState(true, transactionId);

        return RepeatStatus.FINISHED;
    }


}

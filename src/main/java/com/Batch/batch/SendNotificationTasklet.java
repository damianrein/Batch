package com.Batch.batch;

import org.jboss.logging.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class SendNotificationTasklet implements Tasklet {

	Logger log = Logger.getLogger(SendNotificationTasklet.class);
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
        String transactionId = chunkContext.getStepContext()
                .getStepExecution()
                .getJobParameters()
                .getString("transactionId");

        log.info("++++> Se ha enviado una notificacion al cliente para la transaccion {" + transactionId + "}");

        return RepeatStatus.FINISHED;
	}


}

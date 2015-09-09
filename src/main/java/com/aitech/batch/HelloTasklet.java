package com.aitech.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * Tasklet
 * 
 * @author Nassim AIT BRAHAM
 *
 */
public class HelloTasklet implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

		System.out.println("Batch hello world");
		
		// On indique l'etape est terminee
		stepContribution.setExitStatus(ExitStatus.COMPLETED);
		
		
		// On indique que cette tache n'a pas etre repeter au sein de cette etape
		return RepeatStatus.FINISHED;
	}

}

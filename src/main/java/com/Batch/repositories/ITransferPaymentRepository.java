package com.Batch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.Batch.entities.TransferPaymentEntity;

public interface ITransferPaymentRepository extends JpaRepository<TransferPaymentEntity, String> {

	@Query("update TransferPaymentEntity tpe SET tpe.isProcessed = ?1 WHERE tpe.transactionId = ?2")
	@Modifying
	@Transactional
	void updateTransferState(boolean newValor, String id);
	
	@Query("update TransferPaymentEntity tpe SET tpe.isProcessed = ?1, tpe.error = ?2 WHERE tpe.transactionId = ?3")
	@Modifying
	@Transactional
	void updateTransferStateError(boolean newValor,String error, String id);
}

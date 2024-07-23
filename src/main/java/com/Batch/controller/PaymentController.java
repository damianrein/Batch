package com.Batch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Batch.dtos.TransferPaymentDto;
import com.Batch.entities.TransferPaymentEntity;
import com.Batch.repositories.ITransferPaymentRepository;

@RestController
@RequestMapping("/v1")
public class PaymentController {

	private ITransferPaymentRepository repo;
	@PostMapping
	public ResponseEntity<?> transferPayment(@RequestBody TransferPaymentDto dto){
	
		TransferPaymentEntity transferPayment = new TransferPaymentEntity();
		transferPayment.setAvariableBalance(dto.avariableBalance());
		transferPayment.setAmountPaid(dto.amountPaid());
		transferPayment.setEnabled(dto.enabled());
		transferPayment.setProcessed(false);
		
		repo.save(transferPayment);
		
		Map<String, Object> httpResponse = new HashMap<>();
		//httpResponse.put("transactionId", transactionId);
		httpResponse.put("Message", "Transaccion Recibida");
		
		return ResponseEntity.ok(httpResponse);
	}
}

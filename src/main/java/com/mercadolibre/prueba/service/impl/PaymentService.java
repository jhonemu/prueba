package com.mercadolibre.prueba.service.impl;

import static com.mercadolibre.prueba.util.Utils.throwIfTrue;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.prueba.controller.dto.PaymentDTO;
import com.mercadolibre.prueba.controller.dto.response.BalanceDTO;
import com.mercadolibre.prueba.converter.impl.PaymentConverter;
import com.mercadolibre.prueba.exception.ControlException;
import com.mercadolibre.prueba.model.LoanApplication;
import com.mercadolibre.prueba.model.Payment;
import com.mercadolibre.prueba.persistence.repositories.LoanApplicationRepository;
import com.mercadolibre.prueba.persistence.repositories.PaymentRepository;
import com.mercadolibre.prueba.service.IPaymentService;

/**
 * <p>PaymentService</p>
 * Implementacion de IPaymentService
 * <p>Capa de servicio</p>
 * @author Jhon
 *
 */
@Service
public class PaymentService implements IPaymentService{
	
	public static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	private LoanApplicationRepository loanApplicationRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public void resiterPayment(PaymentDTO dto) throws ControlException {
		LOG.info("Validating Payment...");
		validatePaymentDTO(dto);
		PaymentConverter converter = new PaymentConverter();
		LoanApplication loan = loanApplicationRepository.findByLoanId(dto.getLoanId());
		throwIfTrue(loan ==null , "No existe Loan Application con este ID");
		Payment payment = converter.fromEntity(dto);
		payment.setLoanApplication(loan);
		LOG.info("Save Payment...");
		paymentRepository.save(payment);
	}

	@Override
	public BalanceDTO getBalance(Date date,String loanId) throws ControlException {
		throwIfTrue(date == null, "El parametro date es obligatorio");
		BalanceDTO bDTO = new BalanceDTO();
		LOG.info("Getting Payment Balance...");
		Double result = paymentRepository.balance(date,loanId);
		bDTO.setBalance(result !=null ? result : 0.0);
		return bDTO;
	}
	
	/**
	 * Metodo encargado de realizar la validacion de los datos del DTO
	 * @param dto
	 * @throws ControlException
	 */
	protected void validatePaymentDTO(PaymentDTO dto) throws ControlException {
		throwIfTrue(dto.getAmount() == null , "El campo Ammount es obligatorio");
		throwIfTrue(dto.getDate() == null , "El campo Date es obligatorio");
		throwIfTrue(dto.getLoanId() == null , "El campo LoanId es obligatorio");
		throwIfTrue(dto.getPaymentType() == null, "El campo Payment es obligatorio");
	}

}

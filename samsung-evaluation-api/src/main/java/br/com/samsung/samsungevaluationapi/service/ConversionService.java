package br.com.samsung.samsungevaluationapi.service;

import java.time.LocalDate;
import java.util.List;

import br.com.samsung.samsungevaluationapi.controller.dto.ConversionItemDTO;

public interface ConversionService {

    public List<ConversionItemDTO> findByFilter(String documentNumber, String currencyCode, LocalDate initDate, LocalDate endDate);
}

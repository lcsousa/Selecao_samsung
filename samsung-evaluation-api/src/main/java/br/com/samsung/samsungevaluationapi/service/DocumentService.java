package br.com.samsung.samsungevaluationapi.service;

import java.time.LocalDate;
import java.util.List;

import br.com.samsung.samsungevaluationapi.model.Document;

public interface DocumentService {

    public List<Document> findByFilter(String documentNumber, String currencyCode, LocalDate initDate, LocalDate endDate);
}

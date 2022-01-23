package br.com.samsung.samsungevaluationapi.service;

import java.time.LocalDate;
import java.util.List;

import br.com.samsung.samsungevaluationapi.model.Currency;
import br.com.samsung.samsungevaluationapi.model.Quotation;

public interface QuotationService {

    public List<Quotation> listAll();
        
    public List<Quotation> getQuotationByCurrencyAndDate(Currency currency,LocalDate date);
}

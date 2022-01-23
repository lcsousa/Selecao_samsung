package br.com.samsung.samsungevaluationapi.service;

import java.util.List;

import br.com.samsung.samsungevaluationapi.model.Currency;

public interface CurrencyService {

    public List<Currency> listAll();
    public Currency getCurrencyByCode(String currencyCode);
}

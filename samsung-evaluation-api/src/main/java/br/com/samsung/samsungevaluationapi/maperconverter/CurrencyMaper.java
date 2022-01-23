package br.com.samsung.samsungevaluationapi.maperconverter;

import java.util.List;
import java.util.stream.Collectors;

import br.com.samsung.samsungevaluationapi.controller.dto.CurrencyDTO;
import br.com.samsung.samsungevaluationapi.model.Currency;

public class CurrencyMaper {
	public static CurrencyDTO converter(Currency currency) {
		CurrencyDTO dto = new CurrencyDTO();
		dto.setCurrencyCode(currency.getCurrencyCode());
		dto.setCurrencyDesc(currency.getCurrencyDesc());
		dto.setCurrencyId(currency.getCurrencyId());

		return dto;
	}

	public static List<CurrencyDTO> converterAll(List<Currency> listCurrency) {
		return listCurrency.stream().map(CurrencyMaper::converter).collect(Collectors.toList());
	}
}

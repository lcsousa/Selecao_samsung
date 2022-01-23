package br.com.samsung.samsungevaluationapi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.samsung.samsungevaluationapi.client.feing.FeignClientEvaluationService;
import br.com.samsung.samsungevaluationapi.model.Currency;
import br.com.samsung.samsungevaluationapi.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    FeignClientEvaluationService feignClientService;
   

    @Override
    public List<Currency> listAll() {
        return feignClientService.listCurrencys();
    }
    
    @Override
    public Currency getCurrencyByCode(String currencyCode) {
        return listAll().stream().filter(p -> p.getCurrencyCode().equals(currencyCode)).findFirst().orElse(null);
    }
}

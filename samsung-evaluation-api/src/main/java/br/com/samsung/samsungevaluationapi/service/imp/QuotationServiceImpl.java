package br.com.samsung.samsungevaluationapi.service.imp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.samsung.samsungevaluationapi.client.feing.FeignClientEvaluationService;
import br.com.samsung.samsungevaluationapi.model.Currency;
import br.com.samsung.samsungevaluationapi.model.Quotation;
import br.com.samsung.samsungevaluationapi.service.CurrencyService;
import br.com.samsung.samsungevaluationapi.service.QuotationService;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    FeignClientEvaluationService feignClientService;
    @Autowired
	private CurrencyService currencyService;
    
    @Override
    public List<Quotation> listAll() {
        return feignClientService.listQuotations();
    }
    
    @Override
    public List<Quotation> getQuotationByCurrencyAndDate(Currency currency,LocalDate date) {
    	List<Quotation> listQuotationReturn = new ArrayList<>();
 
    	List<Currency>  listCurrency = currencyService.listAll();
    	
    	List<Quotation> listQuotation = listAll().stream().filter(q -> q.getFromCurrencyCode().equals(currency.getCurrencyCode())).collect(Collectors.toList());
    	
    	listCurrency.stream().forEach(currencyTemp ->{
    		if(!currencyTemp.getCurrencyDesc().endsWith(currency.getCurrencyDesc())) {
    			List<Quotation> listQuotationTo = listQuotation.stream().filter(q -> q.getToCurrencyCode().equals(currencyTemp.getCurrencyCode())).collect(Collectors.toList());
        		
        		listQuotationReturn.add(getQuotation(listQuotationTo, date));
    		}  		
    		
    	});
    	
    	return listQuotationReturn;	
        
    }
    
    private  Quotation getQuotation(List<Quotation> listQuotationTo,LocalDate date) {
    	Quotation quotation = null;
    	Long diferencaEmDiasMenor = null;
    	for(Quotation quotationTemp : listQuotationTo) {
    		long diferencaEmDias = ChronoUnit.DAYS.between(quotationTemp.getDataHoraCotacao(), date);
    		if(diferencaEmDias == 0) {
    			quotation = quotationTemp;
    			break;
    		}else {
    			if(diferencaEmDiasMenor == null || diferencaEmDiasMenor > diferencaEmDias) {
    				diferencaEmDiasMenor = diferencaEmDias;
    				quotation = quotationTemp;
    				continue;
    			}
    		}
    	}
    	
    	return quotation;
    }
}

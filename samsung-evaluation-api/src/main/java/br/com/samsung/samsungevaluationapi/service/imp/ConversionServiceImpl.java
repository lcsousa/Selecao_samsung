package br.com.samsung.samsungevaluationapi.service.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.samsung.samsungevaluationapi.client.feing.FeignClientEvaluationService;
import br.com.samsung.samsungevaluationapi.controller.dto.ConversionItemDTO;
import br.com.samsung.samsungevaluationapi.model.Currency;
import br.com.samsung.samsungevaluationapi.model.Document;
import br.com.samsung.samsungevaluationapi.model.Quotation;
import br.com.samsung.samsungevaluationapi.service.ConversionService;
import br.com.samsung.samsungevaluationapi.service.CurrencyService;
import br.com.samsung.samsungevaluationapi.service.DocumentService;
import br.com.samsung.samsungevaluationapi.service.QuotationService;

@Service
public class ConversionServiceImpl implements ConversionService {

	@Autowired
	FeignClientEvaluationService feignClientService;
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private QuotationService quotationService;
	
	@Autowired
	private CurrencyService currencyService;

	@Override
	public List<ConversionItemDTO> findByFilter(String documentNumber, String currencyCode, LocalDate initDate,
			LocalDate endDate) {
		List<ConversionItemDTO> listConversion = new ArrayList<>();
		
		List<Document> listDoc = documentService.findByFilter(documentNumber, currencyCode,	initDate, endDate);
		
		for(Document document :listDoc) {
			Currency currency = currencyService.getCurrencyByCode(document.getCurrencyCode());
			List<Quotation> listQuotation = quotationService.getQuotationByCurrencyAndDate(currency, document.getDocumentDate());
			
			listConversion.addAll(getCoversionItem(listQuotation, document));
			
		}
		return listConversion;
	}
	
	public List<ConversionItemDTO> getCoversionItem(List<Quotation> listQuotation,Document document) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		HashMap<String, Currency> mapCurrency = getCourrencyMapTemp();
		
		List<ConversionItemDTO> listConversionList =  new ArrayList<>();
		
		ConversionItemDTO conversionItemDoc = new ConversionItemDTO();
		conversionItemDoc.setCurrencyCode(document.getCurrencyCode());

		conversionItemDoc.setDocumentValue(document.getDocumentValue());
		conversionItemDoc.setCotacao(new BigDecimal(1));
		conversionItemDoc.setDocumentNumber(document.getDocumentNumber());
		conversionItemDoc.setDataDocumento(formatter.format(document.getDocumentDate()));
		conversionItemDoc.setCurrencyDesc(mapCurrency.get(document.getCurrencyCode()).getCurrencyDesc());
		listConversionList.add(conversionItemDoc);
		listQuotation.stream().forEach(q -> {
			ConversionItemDTO conversionItemTemp = new ConversionItemDTO();
			conversionItemTemp.setCurrencyCode(q.getToCurrencyCode());
			conversionItemTemp.setDocumentValue(document.getDocumentValue().multiply(new BigDecimal(q.getCotacao())).setScale(2, RoundingMode.HALF_EVEN));
			conversionItemTemp.setCotacao(new BigDecimal(q.getCotacao()));
			conversionItemTemp.setDocumentNumber(document.getDocumentNumber());
			conversionItemTemp.setDataDocumento(formatter.format(document.getDocumentDate()));
			conversionItemTemp.setCurrencyDesc(mapCurrency.get(q.getToCurrencyCode()).getCurrencyDesc());
			listConversionList.add(conversionItemTemp);
		});
		
		return listConversionList;
	}
	
	private HashMap<String, Currency> getCourrencyMapTemp() {
		HashMap<String, Currency> map = new HashMap<>();
		currencyService.listAll().stream().forEach(q ->{
			map.put(q.getCurrencyCode(), q);
		});;
		return map;
	}
}

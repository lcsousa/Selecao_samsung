package br.com.samsung.samsungevaluationapi.service.imp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.samsung.samsungevaluationapi.client.feing.FeignClientEvaluationService;
import br.com.samsung.samsungevaluationapi.model.Document;
import br.com.samsung.samsungevaluationapi.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	FeignClientEvaluationService feignClientService;

	@Override
	public List<Document> findByFilter(String documentNumber, String currencyCode, LocalDate initDate,
			LocalDate endDate) {
		List<Document> listDocument = feignClientService.listDocuments();
		List<Document> listDocumentReturn = new ArrayList<Document>();

		if (!ObjectUtils.isEmpty(listDocument)) {
			for (Document document : listDocument) {
				if (!ObjectUtils.isEmpty(documentNumber) && !document.getDocumentNumber().equals(documentNumber)) {
					continue;
				}

				if (!ObjectUtils.isEmpty(currencyCode)!=document.getCurrencyCode().equals(currencyCode)) {
					continue;
				}
				if (!ObjectUtils.isEmpty(initDate)&& initDate.isAfter(document.getDocumentDate())) {
					continue;
				}

				if (!ObjectUtils.isEmpty(endDate)&& endDate.isBefore(document.getDocumentDate())) {
					continue;
				}
				listDocumentReturn.add(document);
			}
		}

		return listDocumentReturn;
	}
}

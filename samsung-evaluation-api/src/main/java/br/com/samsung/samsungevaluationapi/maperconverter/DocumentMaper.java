package br.com.samsung.samsungevaluationapi.maperconverter;

import br.com.samsung.samsungevaluationapi.controller.dto.DocumentDTO;
import br.com.samsung.samsungevaluationapi.model.Document;

public class DocumentMaper {
	public static DocumentDTO converter(Document document) {
		DocumentDTO dto = new DocumentDTO();
		dto.setCurrencyCode(document.getCurrencyCode());
		dto.setDocumentDate(document.getDocumentDate());
		dto.setDocumentId(document.getDocumentId());
		dto.setDocumentNumber(document.getDocumentNumber());
		dto.setDocumentValue(document.getDocumentValue());
		dto.setNotaFiscal(document.getNotaFiscal());

		return dto;
	}

}

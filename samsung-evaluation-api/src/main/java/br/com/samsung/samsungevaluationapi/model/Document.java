package br.com.samsung.samsungevaluationapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Document {

    private Long documentId;
    private String documentNumber;
    private String notaFiscal;
    private LocalDate documentDate;
    private BigDecimal documentValue;
    private String currencyCode;
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public LocalDate getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(LocalDate documentDate) {
		this.documentDate = documentDate;
	}
	public BigDecimal getDocumentValue() {
		return documentValue;
	}
	public void setDocumentValue(BigDecimal documentValue) {
		this.documentValue = documentValue;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
    
    
}

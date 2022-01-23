package br.com.samsung.samsungevaluationapi.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;

public class DocumentDTO {

	@ApiModelProperty(value = "Identificador do Documento")
    private Long documentId;
	@ApiModelProperty(value = "Número do Documento")
    private String documentNumber;
	@ApiModelProperty(value = "Nota Fiscal")
    private String notaFiscal;
	@ApiModelProperty(value = "Data do Documento")
    private LocalDate documentDate;
	@ApiModelProperty(value = "Valor do Documento")
    private BigDecimal documentValue;
	@ApiModelProperty(value = "Código da Moeda")
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

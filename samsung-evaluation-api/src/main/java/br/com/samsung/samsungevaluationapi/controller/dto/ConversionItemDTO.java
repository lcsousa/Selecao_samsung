package br.com.samsung.samsungevaluationapi.controller.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class ConversionItemDTO {
	@ApiModelProperty(value = "Valor do Documento convertido")
	private BigDecimal documentValue;
	@ApiModelProperty(value = "Valor da cotação da moeda")
	private BigDecimal cotacao;
	@ApiModelProperty(value = "Cádigo da Moeda")
    private String currencyCode;
	@ApiModelProperty(value = "Nome da Moeda")
	  private String currencyDesc;
	@ApiModelProperty(value = "Número do Documento")
    private String documentNumber;	
	@ApiModelProperty(value = "Data do Documento")
    private String dataDocumento;
    
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
	public BigDecimal getCotacao() {
		return cotacao;
	}
	public void setCotacao(BigDecimal cotacao) {
		this.cotacao = cotacao;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getDataDocumento() {
		return dataDocumento;
	}
	public void setDataDocumento(String dataDocumento) {
		this.dataDocumento = dataDocumento;
	}
	public String getCurrencyDesc() {
		return currencyDesc;
	}
	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
	} 
    
    
}

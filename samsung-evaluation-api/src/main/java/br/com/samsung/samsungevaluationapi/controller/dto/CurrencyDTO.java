package br.com.samsung.samsungevaluationapi.controller.dto;

import io.swagger.annotations.ApiModelProperty;

public class CurrencyDTO {
	@ApiModelProperty(value = "Identificador da Moeda")
	private Long currencyId;
	@ApiModelProperty(value = "Código da Moeda")
    private String currencyCode;
	@ApiModelProperty(value = "Descrição da Moeda")
	
    private String currencyDesc;
    
	public Long getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyDesc() {
		return currencyDesc;
	}
	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
	}
    
    
    
    
}

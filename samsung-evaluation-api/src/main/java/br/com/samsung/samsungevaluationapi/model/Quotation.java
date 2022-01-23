package br.com.samsung.samsungevaluationapi.model;

import java.time.LocalDate;

public class Quotation {

	
	    private String fromCurrencyCode;
	    private String toCurrencyCode;
	    private String cotacao;
	    private LocalDate dataHoraCotacao;

	   
	    public String getFromCurrencyCode() {
	        return fromCurrencyCode;
	    }

	    public void setFromCurrencyCode(String fromCurrencyCode) {
	        this.fromCurrencyCode = fromCurrencyCode;
	    }

	    public String getToCurrencyCode() {
	        return toCurrencyCode;
	    }

	    public void setToCurrencyCode(String toCurrencyCode) {
	        this.toCurrencyCode = toCurrencyCode;
	    }

	    public String getCotacao() {
	        return cotacao;
	    }

	    public void setCotacao(String cotacao) {
	        this.cotacao = cotacao;
	    }

	    public LocalDate getDataHoraCotacao() {
	        return dataHoraCotacao;
	    }

	    public void setDataHoraCotacao(LocalDate dataHoraCotacao) {
	        this.dataHoraCotacao = dataHoraCotacao;
	    }
    
}

package br.com.samsung.samsungevaluationapi.controller.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ConversionDTO {
	
	
	/*
	 * @ApiModelProperty(value = "Detalhes do Documento") private DocumentDTO
	 * document;
	 */
    
	@ApiModelProperty(value = "Listas de conversões")
    private List<ConversionItemDTO> listCoversionItem;

	

	public List<ConversionItemDTO> getListCoversionItem() {
		return listCoversionItem;
	}

	public void setListCoversionItem(List<ConversionItemDTO> listCoversionItem) {
		this.listCoversionItem = listCoversionItem;
	}
    
    
}

package br.com.samsung.samsungevaluationapi.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.samsung.samsungevaluationapi.controller.dto.ConversionDTO;
import br.com.samsung.samsungevaluationapi.controller.dto.ConversionItemDTO;
import br.com.samsung.samsungevaluationapi.controller.dto.CurrencyDTO;
import br.com.samsung.samsungevaluationapi.maperconverter.CurrencyMaper;
import br.com.samsung.samsungevaluationapi.model.Currency;
import br.com.samsung.samsungevaluationapi.service.ConversionService;
import br.com.samsung.samsungevaluationapi.service.CurrencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(tags = "Samsung-evaluation-api ")
@RestController
@RequestMapping(value = "v1",produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiEvaluationController {

	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private ConversionService conversionService;
	
	
	@ApiOperation(value = "Método que retorna uma lista com todas Currency")
	@ApiResponses(value = { @ApiResponse(code = 200, response = CurrencyDTO.class, message="Consulta fetuada com Sucesso"),           
            @ApiResponse(code = 400,  message = "Bad Request"),
            @ApiResponse(code = 500, response = Error.class, message = "Internal Server Error")})
	@CrossOrigin
	@GetMapping(value = "/currencys")
    public ResponseEntity<List<CurrencyDTO>> listCurrency() {
	 List<Currency> listCurrency = this.currencyService.listAll();
	 List<CurrencyDTO> listCurrencyDTO = CurrencyMaper.converterAll(listCurrency);
     return new ResponseEntity<>(listCurrencyDTO, HttpStatus.OK);

    }
	
	
	@ApiOperation(value = "Método que retorna os documentos e seus valores convertidos em outras moedas")
	@ApiResponses(value = { @ApiResponse(code = 200, response = ConversionDTO.class, message="Consulta fetuada com Sucesso"),           
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500,  message = "Internal Server Error")})
	@CrossOrigin
    @GetMapping(value = "/documents") 
    public ResponseEntity<List<ConversionItemDTO>> getConversion(
    		     @ApiParam(value = "Número do Documento",example = "800002010") @RequestParam(value="documentNumber",required = false) String documentNumber,
				 @ApiParam(value = "Código da Moeda",example = "USD")@RequestParam(value="currencyCode",required = false) String currencyCode,
				 @ApiParam(value = "Data Início - Filtro de Data do Documento",example = "2020-01-01")  @RequestParam(value="initDate",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate initDate,
				 @ApiParam(value = "Data Final -  Filtro de Data do Documento",example = "2020-01-01")  @RequestParam(value="endDate",required = false)  @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate endDate) {

        return new ResponseEntity<>(conversionService.findByFilter(documentNumber, currencyCode,
        		initDate, endDate), HttpStatus.OK);

    }
	 
	 
}

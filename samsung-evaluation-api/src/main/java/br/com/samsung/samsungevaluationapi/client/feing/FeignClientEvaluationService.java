package br.com.samsung.samsungevaluationapi.client.feing;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.samsung.samsungevaluationapi.model.Currency;
import br.com.samsung.samsungevaluationapi.model.Document;
import br.com.samsung.samsungevaluationapi.model.Quotation;

@org.springframework.cloud.openfeign.FeignClient(name = "evaluation", url = "${url.feign.Evaluation.client}")
public interface FeignClientEvaluationService {

    @GetMapping("/currency")
    List<Currency> listCurrencys();

    @GetMapping("/docs")
    List<Document> listDocuments();
    
    @GetMapping("/quotation")
    List<Quotation> listQuotations();

}

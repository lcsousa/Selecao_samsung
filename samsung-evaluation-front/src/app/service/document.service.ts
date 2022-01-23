import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, tap } from 'rxjs/operators';
import { Conversion } from '../model/Conversion';
import { ConversionItem } from '../model/ConversionItem';
import { Currency } from '../model/Currency';
import { DocumentFilter } from '../model/DocumentFilter';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  private readonly API = environment.api+'/samsung-evaluation-api/v1/';

  constructor(private httpClient: HttpClient) { }

  listCurrency() {
    console.log(this.API);
    return this.httpClient.get<Currency[]>(this.API+'currencys');
  }
 
  listQuotation(quotatioFilter:DocumentFilter) {
    const params = new HttpParams()
    .set('currencyCode', quotatioFilter.currencyCode.toString())
    .set('documentNumber', quotatioFilter.documentNumber.toString())
    .set('endDate', quotatioFilter.endDate.toString())
    .set('initDate', quotatioFilter.initDate.toString());
    return this.httpClient.get<ConversionItem[]>(this.API+'documents',{params});
  }
}

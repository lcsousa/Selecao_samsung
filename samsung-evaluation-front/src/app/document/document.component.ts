import { Component, OnInit } from '@angular/core';
import { Observable , of } from 'rxjs';
import { Conversion } from '../model/Conversion';
import { ConversionItem } from '../model/ConversionItem';
import { Currency } from '../model/Currency';
import { DocumentFilter } from '../model/DocumentFilter';
import { MatCardModule } from '@angular/material/card';
import { DocumentService } from '../service/document.service';

import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrls: ['./document.component.css']
})
export class DocumentComponent implements OnInit {
  listQuotationGrid:ConversionItem[];
  listCurrency:Currency[];
  documentFilter:DocumentFilter;
  dataInicio = new FormControl(); 
  dataFim = new FormControl();

  constructor(private quotatiosService:DocumentService) {
    this.listQuotationGrid=[];
    this.listCurrency=[];
    this.documentFilter = new DocumentFilter('','','','');
  }

  displayedColumns = ['Documento','Data Documento','Moeda','Valor'];
  
  ngOnInit(): void {
    this.getCurrency();
  }
  getCurrency() {   
    this.quotatiosService.listCurrency().subscribe(data => {this.listCurrency = data});  
  }


  pesquisar() {
  
    this.convertdate(this.dataInicio);
    this.documentFilter.initDate = this.convertdate(this.dataInicio);
    this.documentFilter.endDate = this.convertdate(this.dataFim);
    this.quotatiosService.listQuotation(this.documentFilter).subscribe(data => {      
      this.listQuotationGrid = data;       
    });  
  }

  clean(){
    this.documentFilter=new DocumentFilter('','','','');
    this.dataInicio = new FormControl(); 
    this.dataFim = new FormControl();
    this.listQuotationGrid=[];
  }

  convertdate(formControl:FormControl) {
    if(formControl == null || formControl.value == null){
      return '';
    }
    var dataDia = formControl.value.toLocaleString().split(" ")[0];
    var dataPadraoArray :String[] = dataDia.split("/");
    var dataPadrao= dataPadraoArray[2]+'-'+dataPadraoArray[1]+'-'+dataPadraoArray[0];
    return dataPadrao;
  }
}

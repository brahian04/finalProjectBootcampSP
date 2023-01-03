import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../environments/customer-service.service';
import { Customer } from '../model/customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit{

  customers:Customer[];

  constructor(private service:CustomerServiceService){}

  private customerList(){
    this.service.getCustomersList().subscribe(res=> {
      this.customers= res;
    });
  }

  ngOnInit(): void {
    this.customerList();
  }
}

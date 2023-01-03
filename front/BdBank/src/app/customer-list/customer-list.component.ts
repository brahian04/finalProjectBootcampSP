import { Component } from '@angular/core';
import { Customer } from '../model/customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent {
  customers:Customer[];

  constructor(public service:ServiceMainService){}
}

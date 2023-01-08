import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import swal from 'sweetalert2';
import { CustomerServiceService } from '../environments/customer-service.service';
import { Customer } from '../model/customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit{

  customers:Customer[];

  constructor(private service:CustomerServiceService, private router:Router) { }

  private customerList(){
    this.service.getCustomersList().subscribe(res=> {
      this.customers= res;
    });
  }

  customerDetail(id:number){
    this.router.navigate(['customer-detail',id]);
  }

  ngOnInit(): void {
    this.customerList();
  }
}

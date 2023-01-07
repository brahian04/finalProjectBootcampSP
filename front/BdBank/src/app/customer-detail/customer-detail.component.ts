import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerServiceService } from '../environments/customer-service.service';
import { Customer } from '../model/customer';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  id:number
  customer:Customer;
  constructor(private route:ActivatedRoute,private customerService:CustomerServiceService,private router:Router){}


  ngOnInit(): void {
      this.id= this.route.snapshot.params['id'];
      this.customer= new Customer();
      this.customerService.getCustomerById(this.id).subscribe(res =>{
        this.customer= res;
      });
  }
}

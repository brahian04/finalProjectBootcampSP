import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import swal  from 'sweetalert2';
import { CustomerServiceService } from '../environments/customer-service.service';
import { Customer } from '../model/customer';

@Component({
  selector: 'app-register-customer',
  templateUrl: './register-customer.component.html',
  styleUrls: ['./register-customer.component.css']
})
export class RegisterCustomerComponent implements OnInit {
  customer: Customer= new Customer();
  constructor(private customerService:CustomerServiceService,private router:Router){}
  
  ngOnInit(): void {
  }

  registCustomer(){
    this.customerService.registerCustomer(this.customer).subscribe(res => {
      console.log(res);
      this.sendCustomerList();
    },error => console.log(error));
  }

  sendCustomerList(){
    this.router.navigate(['/customers']);
  }

  onSubmit(){
    this.registCustomer();
    swal('Created customer',`The customer ${this.customer.name} has been successfully created`,`success`);
  }

}

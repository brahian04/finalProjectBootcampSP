import { Component, OnInit } from '@angular/core';
import  swal  from 'sweetalert2';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerServiceService } from '../environments/customer-service.service';
import { Customer } from '../model/customer';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  id:number;
  customer:Customer= new Customer();
  constructor(private customerService:CustomerServiceService,private router:Router,private route:ActivatedRoute){}

  ngOnInit(): void {
      this.id= this.route.snapshot.params['id'];
      this.customerService.getCustomerById(this.id).subscribe(res =>{
        this.customer= res;
      },error =>console.log(error));
  }

  goCustomerList(){
    this.router.navigate(['/customers']);
    swal('Updated customer',`The customer ${this.customer.name} has been successfully updated`,`success`);
  }

  onSubmit(){
    this.customerService.updateCustomer(this.id,this.customer).subscribe(date =>{
      this.goCustomerList();
    },error =>console.log(error));
  }
}

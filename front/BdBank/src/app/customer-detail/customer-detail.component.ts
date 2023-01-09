import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import swal from 'sweetalert2';
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

  updateCustomer(id:number){
    this.router.navigate(['update-customer',id]);
  }

  deleteCustomer(id:number){
    swal({
      title: 'are you sure?',
      text: "Confirm if you want to delete the customer",
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes , delete',
      cancelButtonText: "Don't, cancel",
      confirmButtonClass: 'btn btn-succes',
      cancelButtonClass: 'btn btn-danger',
      buttonsStyling: true
    }).then((res) =>{
      if(res.value){
        this.customerService.deleteCustomer(id).subscribe(data=> {
          console.log(data);
          this.updateCustomer(id);
          swal(
            'Customer delete',
            'The customer has been successfully deleted',
            'success'
          )
          this.router.navigate(['customers']);
        })
      }
    })
  }

  sendCustomerList(){
    this.router.navigate(['/customers']);
  }

  ngOnInit(): void {
      this.id= this.route.snapshot.params['id'];
      this.customer= new Customer();
      this.customerService.getCustomerById(this.id).subscribe(res =>{
        this.customer= res;
      });
  }
}

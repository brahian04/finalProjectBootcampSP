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
        this.service.deleteCustomer(id).subscribe(data=> {
          console.log(data);
          this.customerList();
          swal(
            'Customer delete',
            'The customer has been successfully deleted',
            'success'
          )
        })
      }
    })
  }

  customerDetail(id:number){
    this.router.navigate(['customer-detail',id]);
  }

  ngOnInit(): void {
    this.customerList();
  }
}

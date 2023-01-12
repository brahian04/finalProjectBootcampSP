import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import swal from 'sweetalert2';
import { CustomerServiceService } from '../environments/customer-service.service';
import { ProductService } from '../environments/product-service';
import { Customer } from '../model/customer';
import { Product } from '../model/product';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  id:number
  customer:Customer;
  product: Product= new Product();
  button:boolean=false;
  constructor(private route:ActivatedRoute,private customerService:CustomerServiceService,private productService:ProductService,private router:Router){}

  updateCustomer(id:number){
    this.router.navigate(['update-customer',id]);
  }

  buttonReg(){
    if (this.button==false){
      this.button=true;
    }else{this.button=false}
  }

  registProduct(){
    this.productService.registerProduct(this.id,this.product).subscribe(res => {
      console.log(res);
      // this.goCustomerDetail(this.id);
    },error => console.log(error));
  }

  onSubmit(){
    this.registProduct();
    this.buttonReg();
    swal('Created customer',`The customer ${this.product.accountType} has been successfully created`,`success`);
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
  // goCustomerDetail(id:number){
  //   this.router.navigate(['customer-detail',id]);
  // }


  ngOnInit(): void {
      this.id= this.route.snapshot.params['id'];
      this.customer= new Customer();
      this.customerService.getCustomerById(this.id).subscribe(res =>{
        this.customer= res;
      });
  }
}

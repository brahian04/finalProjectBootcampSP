import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import swal from 'sweetalert2';
import { ProductService } from '../environments/product-service';
import { Product } from '../model/product';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit{
  id:number;
  product: Product= new Product();
  constructor(private productService:ProductService,private router:Router,private route:ActivatedRoute){}
  
  ngOnInit(): void {
    this.id= this.route.snapshot.params['id'];
  }

  registProduct(){
    this.productService.registerProduct(this.product).subscribe(res => {
      console.log(res);
      // this.goCustomerDetail(this.id);
    },error => console.log(error));
  }

  // goCustomerDetail(id:number){
  //   this.router.navigate(['customers-detail',id]);
  // }

  onSubmit(){
    this.registProduct();
    swal('Created customer',`The customer ${this.product.accountType} has been successfully created`,`success`);
  }

}

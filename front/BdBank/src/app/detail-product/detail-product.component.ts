import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../environments/product-service';
import { Product } from '../model/product';

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.css']
})
export class DetailProductComponent implements OnInit{
  constructor(private route:ActivatedRoute,private productService:ProductService,private router:Router){}
  id:number;
  product: Product= new Product();

  ngOnInit(): void {
    this.id= this.route.snapshot.params['id'];
    this.product= new Product();
    this.productService.getProductById(this.id).subscribe(res =>{
      this.product= res;
    });
  }

}

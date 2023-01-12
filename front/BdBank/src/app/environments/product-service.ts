import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Customer } from "../model/customer";
import { Product } from "../model/product";

@Injectable({
    providedIn: 'root'
  })
export class ProductService {
      // url origen del servicio en el back
  private url= "http://localhost:8080/v1/api/products";

  constructor(private httpClient:HttpClient) { }

  // método para obtener lista de cuentas
  getProductList():Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.url}`);
  }

  getProductById(id:number):Observable<Product>{
    return this.httpClient.get<Product>(`${this.url}/${id}`);
  }

  // método para registrar cuenta
  registerProduct(id:number,product:Product): Observable<Object>{
    return this.httpClient.post(`${this.url}/${id}`,product);
  }

  // método para actualizar cuenta
  updateProduct(id:number,product:Product): Observable<Object>{
    return this.httpClient.put(`${this.url}/${id}`,product);
  }
}

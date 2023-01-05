import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  // url origen del servicio en el back
  private url= "http://localhost:8080/v1/api/customers";

  constructor(private httpClient:HttpClient) { }

  // método para obtener lista de usuarios
  getCustomersList():Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(`${this.url}`);
  }

  getCustomerById(id:number):Observable<Customer>{
    return this.httpClient.get<Customer>(`${this.url}/${id}`);
  }

  // método para registrar cliente
  registerCustomer(customer:Customer): Observable<Object>{
    return this.httpClient.post(`${this.url}`,customer);
  }

  // método para actualizar cliente
  updateCustomer(id:number,customer:Customer): Observable<Object>{
    return this.httpClient.put(`${this.url}/${id}`,customer);
  }

  // método para borrar cliente
  deleteCustomer(id:number): Observable<Object>{
    return this.httpClient.delete(`${this.url}/${id}`);
  }
}

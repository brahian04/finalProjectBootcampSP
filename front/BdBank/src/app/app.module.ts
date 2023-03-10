import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { HomeComponent } from './home/home.component';
import {HttpClientModule} from '@angular/common/http';
import { RegisterCustomerComponent } from './register-customer/register-customer.component';
import { FormsModule } from '@angular/forms';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { NgbdDropdownContainer } from './dropdown-container/dropdown-container.component';
import { DetailProductComponent } from './detail-product/detail-product.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    HomeComponent,
    RegisterCustomerComponent,
    UpdateCustomerComponent,
    CustomerDetailComponent,
    DetailProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbdDropdownContainer
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

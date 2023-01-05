import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { HomeComponent } from './home/home.component';
import { RegisterCustomerComponent } from './register-customer/register-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';


const routes: Routes = [
  { path: '', redirectTo:'home', pathMatch:'full' },
  { path: 'home', component:HomeComponent},
  { path: 'customers',component:CustomerListComponent},
  { path: 'register-customers',component:RegisterCustomerComponent},
  { path: 'update-customer/:id',component:UpdateCustomerComponent},
  { path: 'customer-detail/:id',component:CustomerDetailComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

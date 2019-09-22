import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoryFormComponent } from './category/page/category-add-form.component';
import { CategoryListComponent } from './category/page/category-list.component';


const routes: Routes = [
  {path : 'categories', component:CategoryListComponent},
  {path : 'addCategory', component:CategoryFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

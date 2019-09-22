import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CategoryService} from '../../core/service/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-add-form.component.html',
  styleUrls: ['./category-add-form.component.css']
})
export class CategoryFormComponent {

  category : Category;

  constructor(private route:ActivatedRoute, private router:Router, private categoryService: CategoryService) {
    this.category = new Category();
   }

  onSubmit() {
    this.categoryService.save(this.category).subscribe(result=>this.goToCategoryList());
  }

  goToCategoryList() {
    this.router.navigate['/categories'];
  }

}

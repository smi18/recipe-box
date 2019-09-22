import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/model/category';
import { CategoryService } from 'src/app/core/service/category.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categories : Category[];
  constructor(private categoryService : CategoryService) { }

  ngOnInit() {
    this.categoryService.findall().subscribe(data=>{
      this.categories = data;
    });
  }

}

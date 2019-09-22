import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable} from 'rxjs';
import { Category } from '../../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private categoriesUrl : string;

  constructor(private http:HttpClient) {
    this.categoriesUrl = 'http://localhost:8080/api/categories'; 
  }

  public findall():Observable<Category[]>{
    return this.http.get<Category[]>(this.categoriesUrl);
  }

  public save(category:Category) {
    return this.http.post<Category>(this.categoriesUrl, category);
  }
}

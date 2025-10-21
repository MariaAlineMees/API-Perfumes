import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Perfume } from '../models/perfume.model';

@Injectable({
  providedIn: 'root'
})
export class PerfumeService {
 API_URL = "http://localhost:8080/perfumes"

  constructor(private http:HttpClient){}

  getAll():Observable<Perfume[]>{
    return this.http.get<Perfume[]>(this.API_URL)
  }

  getById(id:number):Observable<Perfume>{
    return this.http.get<Perfume>(`${this.API_URL}/${id}` )
    // return this.http.get<Perfume>(this.API_URL+"/"+id)
  }
  
  save(perfume:Perfume):Observable<Perfume>{
    return this.http.post<Perfume>(this.API_URL, perfume)
  }

  delete(id:number):Observable<void>{
    return this.http.delete<void>(`${this.API_URL}/${id}` )
  }

  update(id:number, perfume:Perfume):Observable<Perfume>{
    return this.http.put<Perfume>(`${this.API_URL}/${id}`,perfume )
  }
}

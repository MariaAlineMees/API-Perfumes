import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Card } from "../card/card";
import { Perfume } from '../../models/perfume.model';
import { PerfumeService } from '../../services/perfume.service';

@Component({
  selector: 'app-page-produto',
  standalone: true,
  imports: [CommonModule, Card],
  templateUrl: './page-produto.html',
  styleUrls: ['./page-produto.css']
})
export class PageProduto implements OnInit {
 
  perfumes: Perfume[] = [];

  constructor(private perfumeService: PerfumeService){}
  
  ngOnInit(): void {
    this.perfumeService.getAll().subscribe({
      next: (body) => this.perfumes = body
    })
 }

 
 trackById(_index: number, item: Perfume) {
  return item.id;
 }
}

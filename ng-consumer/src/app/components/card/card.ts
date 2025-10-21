import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Perfume } from '../../models/perfume.model';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [CommonModule], 
  templateUrl: './card.html',
  styleUrls: ['./card.css']
})
export class Card {
 
  @Input() dados?: Perfume;

  // Adiciona a lógica para exibir um placeholder se a imagem falhar
  handleImageError(event: Event) {
    const imgElement = event.target as HTMLImageElement;
    imgElement.onerror = null; 
    imgElement.src = 'https://placehold.co/200x200/F5F5F5/333333?text=Sem%0AFoto'; 
  }
}

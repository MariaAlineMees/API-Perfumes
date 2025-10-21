import { Routes } from '@angular/router';
import { PageProduto } from './components/page-produto/page-produto';
import { PageUsers } from './components/page-users/page-users';

export const routes: Routes = [
   {
      path:'produtos', component: PageProduto
   },
   {
      path:'user', component: PageUsers
   },
];

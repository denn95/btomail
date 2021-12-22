import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RecibidosComponent } from './Components/recibidos/recibidos.component';
import { EnviadosComponent } from './Components/enviados/enviados.component';
import { DestacadosComponent } from './Components/destacados/destacados.component';
import { EliminadosComponent } from './Components/eliminados/eliminados.component';
import { SpamComponent } from './Components/spam/spam.component';


const routes: Routes = [
  { path: '', component: RecibidosComponent },
  { path: 'enviados', component: EnviadosComponent },
  { path: 'destacados', component: DestacadosComponent },
  { path: 'eliminados', component: EliminadosComponent },
  { path: 'spam', component: SpamComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

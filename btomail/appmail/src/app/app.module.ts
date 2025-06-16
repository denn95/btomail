import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgxPaginationModule} from 'ngx-pagination';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DataTablesModule } from 'angular-datatables';
import { RecibidosComponent } from './Components/recibidos/recibidos.component';
import { SideBarComponent } from './Components/side-bar/side-bar.component';
import { EncabezadoComponent } from './Components/encabezado/encabezado.component';
import { HttpClientModule } from '@angular/common/http';
import { CorreoService } from './Services/correo.service';
import { FormsModule } from '@angular/forms';
import { EnviadosComponent } from './Components/enviados/enviados.component';
import { DestacadosComponent } from './Components/destacados/destacados.component';
import { EliminadosComponent } from './Components/eliminados/eliminados.component';
import { SpamComponent } from './Components/spam/spam.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { HoraPipe } from './Pipes/hora.pipe';

@NgModule({
  declarations: [
    AppComponent,
    RecibidosComponent,
    SideBarComponent,
    EncabezadoComponent,
    EnviadosComponent,
    DestacadosComponent,
    EliminadosComponent,
    SpamComponent,
    HoraPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DataTablesModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    FontAwesomeModule
  ],
  providers: [
    CorreoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

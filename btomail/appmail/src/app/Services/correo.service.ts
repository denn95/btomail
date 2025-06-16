import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Correo } from '../Models/correo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CorreoService {
  api:string='';
  constructor(private http: HttpClient) { 
    this.api = environment.url;
  }
  getRecibidos(){
    return this.http.get<Correo>(this.api+'Correo/'+0);
  }
  getEnviados(){
    return this.http.get<Correo>(this.api+'Correo/'+1);
  }
  getDestacados(){
    return this.http.get<Correo>(this.api+'Correo/Destacado/'+1);
  }
  getEliminados(){
    return this.http.get<Correo>(this.api+'Correo/Eliminado/'+1);
  }
  getSpam(){
    return this.http.get<Correo>(this.api+'Correo/Spam/'+1);
  }
  create(correo){
        
    let params = JSON.stringify(correo);
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    
    return this.http.post(this.api+'Correo', params, {headers: headers});
  }
  updateDes(correo){
    let params = JSON.stringify(correo);
    let headers = new HttpHeaders().set('Content-Type', 'application/json');

    return this.http.put(this.api+'Correo/Destacado', params, {headers: headers});
  }
  updateSpam(correo){
    let params = JSON.stringify(correo);
    let headers = new HttpHeaders().set('Content-Type', 'application/json');

    return this.http.put(this.api+'Correo/Spam', params, {headers: headers});
  }
  updateElim(correo){
    let params = JSON.stringify(correo);
    let headers = new HttpHeaders().set('Content-Type', 'application/json');

    return this.http.put(this.api+'Correo/Eliminado', params, {headers: headers});
  }
  updateLeido(correo){
    let params = JSON.stringify(correo);
    let headers = new HttpHeaders().set('Content-Type', 'application/json');

    return this.http.put(this.api+'Correo/Leido', params, {headers: headers});
  }
  delete(id){
    let headers = new HttpHeaders().set('Content-Type', 'application/json');

    return this.http.delete(this.api+'Correo/'+id, {headers: headers});;

  }
}

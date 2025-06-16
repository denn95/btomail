import { Component, OnInit } from '@angular/core';
import { CorreoService } from '../../Services/correo.service';
import { Correo } from '../../Models/correo';

@Component({
  selector: 'app-spam',
  templateUrl: './spam.component.html',
  styleUrls: ['./spam.component.css']
})
export class SpamComponent implements OnInit {
  spam:Array<Correo>=new Array<Correo>();
  p:number;
  constructor(private correoService: CorreoService) { }

  ngOnInit(): void {
    this.getRecibidos();
  }
  eliminar(eliminado,id){
    this.updateEliminado(eliminado,id);
     
  }
  destacadoActivar(destacado,id){
    console.log(destacado,id);
    this.updateDestacado(destacado,id);
     
  }
  destacadoDesactivar(destacado,id){
    console.log(destacado,id);
    this.updateDestacado(destacado,id);
    
  }
  getRecibidos(){
    this.correoService.getSpam().subscribe((resp:any) => {
      if (resp.mensaje=="Exito") {
        console.log(resp.data);
        this.spam = resp.data;
      }
    },
    error => {
      console.log("No se pudo listar mensajes recibidos ",error);
    }
    );
  }
  updateDestacado(destacado,id){
    let mail={
      idCorreo:id,
      destacado:destacado
    };
    this.correoService.updateDes(mail).subscribe((resp:any) => {
     
        console.log(resp);
        this.getRecibidos();
    },
    error => {
      console.log("No se actualizo destacado ",error);
    });
  }
  updateEliminado(elimi,id){
    let mail={
      idCorreo:id,
      eliminado:elimi
    };
    this.correoService.updateElim(mail).subscribe((resp:any) => {
     
        console.log(resp);
        this.getRecibidos();
    },
    error => {
      console.log("No se actualizo eliminado ",error);
    });
  }

}

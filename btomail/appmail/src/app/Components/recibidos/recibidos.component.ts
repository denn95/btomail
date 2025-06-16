import { Component, OnInit } from '@angular/core';
import { Correo } from 'src/app/Models/correo';
import { CorreoService } from '../../Services/correo.service';

@Component({
  selector: 'app-recibidos',
  templateUrl: './recibidos.component.html',
  styleUrls: ['./recibidos.component.css']
})
export class RecibidosComponent implements OnInit {
  recibidos:Array<Correo>=new Array<Correo>();
  starActiva:boolean;
  p:number;
  constructor(private correoService: CorreoService) {
    this.starActiva=true;
   }

  ngOnInit(): void {
    this.getRecibidos();
  }

  getRecibidos(){
    this.correoService.getRecibidos().subscribe((resp:any) => {
      if (resp.mensaje=="Exito") {
        console.log(resp.data);
        this.recibidos = resp.data;
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
  updateLeido(lei,id){
    let mail={
      idCorreo:id,
      leido:lei
    };
    this.correoService.updateLeido(mail).subscribe((resp:any) => {
     
        console.log(resp);
        this.getRecibidos();
    },
    error => {
      console.log("No se actualizo leido ",error);
    });
  }
  updateSpam(sp,id){
    let mail={
      idCorreo:id,
      spam:sp
    };
    this.correoService.updateSpam(mail).subscribe((resp:any) => {
     
        console.log(resp);
        this.getRecibidos();
    },
    error => {
      console.log("No se actualizo spam ",error);
    });
  }
  actSpam(spam,id){
    this.updateSpam(spam,id);
     
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
  actualizarLeido(leido,id){
    this.updateLeido(leido,id);
     
  }

}

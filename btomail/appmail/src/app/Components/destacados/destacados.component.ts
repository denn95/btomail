import { Component, OnInit } from '@angular/core';
import { CorreoService } from '../../Services/correo.service';
import { Correo } from '../../Models/correo';

@Component({
  selector: 'app-destacados',
  templateUrl: './destacados.component.html',
  styleUrls: ['./destacados.component.css']
})
export class DestacadosComponent implements OnInit {
  destacados:Array<Correo>=new Array<Correo>();
  constructor(private correoService: CorreoService) { }

  ngOnInit(): void {
    this.getDestacados();
  }
  getDestacados(){
    this.correoService.getDestacados().subscribe((resp:any) => {
      if (resp.mensaje=="Exito") {
        console.log(resp.data);
        this.destacados = resp.data;
      }
    },
    error => {
      console.log("No se pudo listar mensajes destacados ",error);
    });
  }
  updateEliminado(elimi,id){
    let mail={
      idCorreo:id,
      eliminado:elimi
    };
    this.correoService.updateElim(mail).subscribe((resp:any) => {
     
        console.log(resp);
        this.getDestacados();
    },
    error => {
      console.log("No se actualizo eliminado ",error);
    });
  }
  updateDestacado(destacado,id){
    let mail={
      idCorreo:id,
      destacado:destacado
    };
    this.correoService.updateDes(mail).subscribe((resp:any) => {
     
        console.log(resp);
        this.getDestacados();
      
    },
    error => {
      console.log("No se actualizo destacado ",error);
    });
  }
  eliminar(eliminado,id){
    this.updateEliminado(eliminado,id)
  }

  destacadoActivar(destacado,id){
    this.updateDestacado(destacado,id);
    
  }
  destacadoDesactivar(destacado,id){
    this.updateDestacado(destacado,id);
   
  }
}

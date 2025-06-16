import { Component, OnInit } from '@angular/core';
import { Correo } from 'src/app/Models/correo';
import { CorreoService } from 'src/app/Services/correo.service';

@Component({
  selector: 'app-enviados',
  templateUrl: './enviados.component.html',
  styleUrls: ['./enviados.component.css']
})
export class EnviadosComponent implements OnInit {
  enviados:Array<Correo>=new Array<Correo>();
  constructor(private correoService: CorreoService) { }

  ngOnInit(): void {
    this.getEnviados();
  }
  updateDestacado(destacado,id){
    let mail={
      idCorreo:id,
      destacado:destacado
    };
    this.correoService.updateDes(mail).subscribe((resp:any) => {
     
        console.log(resp);
        this.getEnviados();
      
    },
    error => {
      console.log("No se actualizo destacado ",error);
    });
  }
  getEnviados(){
    this.correoService.getEnviados().subscribe((resp:any) => {
      if (resp.mensaje=="Exito") {
        console.log(resp.data);
        this.enviados = resp.data;
      }
    },
    error => {
      console.log("No se pudo listar mensajes enviados ",error);
    });
  }
  updateEliminado(elimi,id){
    let mail={
      idCorreo:id,
      eliminado:elimi
    };
    this.correoService.updateElim(mail).subscribe((resp:any) => {
     
        console.log(resp);
        this.getEnviados();
    },
    error => {
      console.log("No se actualizo eliminado ",error);
    });
  }
  eliminar(eliminado,id){
    this.updateEliminado(eliminado,id);
  }

  destacadoActivar(destacado,id){
    this.updateDestacado(destacado,id)
  }
  destacadoDesactivar(destacado,id){
    this.updateDestacado(destacado,id)
  }
}

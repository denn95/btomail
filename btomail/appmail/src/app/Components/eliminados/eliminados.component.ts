import { Component, OnInit } from '@angular/core';
import { Correo } from 'src/app/Models/correo';
import { CorreoService } from 'src/app/Services/correo.service';

@Component({
  selector: 'app-eliminados',
  templateUrl: './eliminados.component.html',
  styleUrls: ['./eliminados.component.css']
})
export class EliminadosComponent implements OnInit {
  p:number;
  eliminados:Array<Correo>=new Array<Correo>();
  constructor(private correoService: CorreoService) { }

  ngOnInit(): void {
    this.getEliminados();
  }
  getEliminados(){
    this.correoService.getEliminados().subscribe((resp:any) => {
      if (resp.mensaje=="Exito") {
        console.log(resp.data);
        this.eliminados = resp.data;
      }
    },
    error => {
      console.log("No se pudo listar mensajes elimimados ",error);
    });
  }
  eliminar(id){
    this.correoService.delete(id).subscribe(
      resp => {
        console.log("Se elimino ",resp);
        this.getEliminados();
      },
      error => {
        console.log("No se elimino ",error);
      }
    );
  }

}

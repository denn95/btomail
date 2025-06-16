import { Component, OnInit } from '@angular/core';
import { faEnvelope, faPaperPlane, faStar, faExclamationTriangle, faTrashAlt, faEnvelopeOpen } from "@fortawesome/free-solid-svg-icons";
import { NgForm } from "@angular/forms";
import { Correo } from 'src/app/Models/correo';
import { CorreoService } from 'src/app/Services/correo.service';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {
  bandejaMensaje:boolean=false;
  mail:Correo=new Correo();
  faEnvelope=faEnvelope;
  faPaperPlane=faPaperPlane;
  faStar=faStar;
  faExclamationTriangle=faExclamationTriangle;
  faTrashAlt=faTrashAlt;
  faEnvelopeOpen=faEnvelopeOpen;
  constructor(private correoService: CorreoService) { }

  ngOnInit(): void {
  }
  abrirBandeja(){
    this.bandejaMensaje = true;
  }
  cerrarBandeja(){
    this.bandejaMensaje = false;
  }

  onSubmit(correo){
    this.mail.nombreEmisor="denny";
    this.mail.categoria=true;
    this.mail.destacado=false;
    this.mail.eliminado=false;
    this.mail.fecha=new Date;
    this.mail.leido=false;
    this.mail.spam=false;
    console.log(this.mail);
    this.correoService.create(this.mail).subscribe(
      (resp:any) => {
        if (resp.mensaje="Exito") {
          console.log(resp);
        }
      },
      error => {
        console.log("No se inserto correo ",error);
      }
    );
  }

  inicializarFecha(fechaConParam) {
    var fechaNac = new Date(fechaConParam);

    var dd = fechaNac.getDate() + 1;
    var mm = fechaNac.getMonth() + 1; //January is 0!
    var yyyy = fechaNac.getFullYear();

    var dia = dd.toString();
    if (dd < 10) {
      dia = "0" + dd;
    }
    var mes = mm.toString();
    if (mm < 10) {
      mes = "0" + mm;
    }
    console.log(yyyy + "-" + mes + "-" + dia);
    return yyyy + "-" + mes + "-" + dia;
  }
}

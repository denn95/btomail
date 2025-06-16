import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'horaP'
})
export class HoraPipe implements PipeTransform {

  transform(value: any){

    let fecha = new Date(value);

    let sec = fecha.getSeconds();
    let min = fecha.getMinutes();
    let hor = fecha.getHours();

    //let fechaString = year+'/'+mes+'/'+dia;
    let fechaString = hor+' : '+min;

    return fechaString;

}

}

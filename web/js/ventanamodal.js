/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function mostrarVentana(titulo,descripcion,idioma,ano)
{
    var ventana = document.getElementById('miVentana');
    ventana.style.marginTop = '100px';
    ventana.style.left = ((document.body.clientWidth-350) / 2) +  'px';
    ventana.style.display = 'block';
    ventana.innerHTML = '<p align="center">' + titulo + '</p></br><p align="center">' + descripcion + '</p></br><p align="center">' + idioma + '</p></br><p align="center">' + ano + 
            '</p><button onclick="ocultarVentana()" style="display: block;margin-left: auto;margin-right: auto;width: 50%;" align="center">CERRAR</button>';
    
    
}

function ocultarVentana()
{
    var ventana = document.getElementById('miVentana');
    ventana.style.display = 'none';
}




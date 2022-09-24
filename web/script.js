/* global Swal */

window.onload=function(){
    alert("Quiere registrar un libro Master?");   
}

function comeDom (){
    let libro = new Object();
    let codigo=document.getElementById("cod");
    let nombre=document.getElementById("name");
    let direccion=document.getElementById("tip");
    let correo=document.getElementById("edit");
    let telefono=document.getElementById("publi");
    libro.codigo=cod.value;
    libro.nombre=name.value;
    libro.tipo=tip.value;
    libro.editorial=edit.value;
    libro.publicacion=publi.value;
    console.log(libro);
    cod.value='';
    name.value='';
    tip.value='';
    edit.value='';
    publi.value='';
}

function sendData(){
	const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('formu'))).toString();
	  XHR.addEventListener('error',(event) => {alert('Oops! ah ocurrido un error (T_T)');});
	  XHR.open('POST', 'Servlet', true);
          XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    
          XHR.onload = () => { if (XHR.readyState === XHR.DONE && XHR.status === 200){
            console.log("response => " + XHR.response);
            document.getElementById('regTab').innerHTML=XHR.response; susMsj('Libro guardado exitosamente'); clearFormu();}};
          XHR.send(formData);	
}

function clearFormu(){
    document.getElementById("cod").value='';
    document.getElementById("name").value='';
    document.getElementById("tip").value='';
    document.getElementById("edit").value='';
    document.getElementById("publi").value='';
}

function susMsj(msj){
  Swal.fire({
  icon: 'success',
  title: msj,
  showConfirmButton: false,
  timer: 1500
})
}

function eliminarlibro(codigo){
    const XHR = new XMLHttpRequest();
    var formData = new URLSearchParams(new FormData());

    XHR.addEventListener('error', (event) => {
      alert('Oops! Something went wrong.');
    });

    XHR.open('POST', 'Servlet', true);
    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    XHR.onload = () => {
      if (XHR.readyState === XHR.DONE && XHR.status === 200) {
        console.log("response => " + XHR.response);
        susMsj('Se elimino el Libro');
        setTimeout( 2000 );
      }
    };        
    formData.append('codigoBD', codigo);
    formData.append('control', 'ELIMINAR');
    XHR.send(formData); 

}
function f5() { window.location.reload();};

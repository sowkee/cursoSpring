// Call the dataTables jQuery plugin
$(document).ready(function () {
    //En ready
  });
  
  async function registrarUsuarios() {
    let datos = { };
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.correo = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;
    
    let repetirPassword = document.getElementById('txtRepetirPassword').value;

    if (repetirPassword != datos.password) {
        alert('Las contraseñas no coinciden.');
        return;
    }

    const request = await fetch('api/clientes', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'content-Type': 'application/json'
      },
      body: JSON.stringify(datos)

    });

    console.log(datos);
    if(datos != null) {
      alert("La cuenta fue creada con exito.");
      window.location.href = '/login/login-cliente.html';
    }
    
  }
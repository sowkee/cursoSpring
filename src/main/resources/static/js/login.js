/* Call the dataTables jQuery plugin
$(document).ready(function () {
    //En ready
  });
  */
  async function loginUsuario() {
    let datos = { };
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;
    

    const request = await fetch('api/login/usuario', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'content-Type': 'application/json'
      },
      body: JSON.stringify(datos)

    });

    const respuesta = await request.text();

    if(respuesta != 'Fail.') {
      localStorage.token = respuesta;
      localStorage.email = datos.email;
        window.location.href = 'usuarios/usuarios.html';

    }else {
        alert("Las credenciales son incorrectas. Intentelo de nuevo.");
    }
    
  }

  async function loginCliente() {
    let datos = { };
    datos.correo = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;
    

    const request = await fetch('api/login/cliente', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'content-Type': 'application/json'
      },
      body: JSON.stringify(datos)

    });

    const respuesta = await request.text();

    if(respuesta != 'Fail.') {
      localStorage.token = respuesta;
      localStorage.correo = datos.correo;
        window.location.href = '../usuarios/clientes.html';

    }else {
        alert("Las credenciales son incorrectas. Intentelo de nuevo.");
    }
    
  }

  async function loginEmpleado() {
    let datos = { };
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;
    

    const request = await fetch('api/login/empleado', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'content-Type': 'application/json'
      },
      body: JSON.stringify(datos)

    });

    const respuesta = await request.text();

    if(respuesta != 'Fail.') {
      localStorage.token = respuesta;
      localStorage.email = datos.email;
        window.location.href = '../usuarios/empleados.html';

    }else {
        alert("Las credenciales son incorrectas. Intentelo de nuevo.");
    }
    
  }
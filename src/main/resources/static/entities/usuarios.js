// Call the dataTables jQuery plugin
$(document).ready(function () {
  cargarUsuarios();
  $("#usuarios").DataTable();
});

async function cargarUsuarios() {
  const request = await fetch("http://localhost:8080/usuarios/all", {
    method: "GET",
    headers: {
      Accept: "application/json",
    },
  });

  const usuarios = await request.json();
  for(let usuario of usuarios.data) {
    console.log(usuario)
  }

  let listadoHtml = " ";

  for (let usuario of usuarios.data) {
    //let usuario = usuarios[usuarioJSon];

    let botonEliminar =
      '<a href="#" onClick = "eliminarUsuario(' +
      usuario.idUsuario +
      ')" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i> </a>';

    let telefonoTexto =
      usuario.telefono == null || usuario.telefono == NaN? "-" : usuario.telefono;
    let usuarioHtml =
      "<tr> <td>" +
      usuario.idUsuario +
      "</td><td>" +
      usuario.nombre +
      " " +
      usuario.apellido +
      "</td><td>" +
      usuario.correo +
      "</td><td>" +
      +telefonoTexto +
      "</td><td>" +
      botonEliminar +
      "</td></tr>";
    listadoHtml += usuarioHtml;
  }

  document.querySelector("#usuarios tbody").outerHTML = listadoHtml;

}

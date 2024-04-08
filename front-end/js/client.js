function disabledBotton(){
    const btnAgregar = document.querySelector('button[name="btnAgregar"]');
    btnAgregar.classList.add('disabled');
}

document.getElementById('personForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const firstName = document.getElementById('first_name').value;
    const lastName = document.getElementById('last_name').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;

    const selectDirection = document.getElementById('selectDirection').value;
    const num1 = document.getElementById('num1').value;
    const num2 = document.getElementById('num2').value;
    const letter = document.getElementById('letter').value;

    const dateOfBirthElement = document.getElementById('date_of_birth');
    const dateOfBirth = dateOfBirthElement.value;

    // Formatear la fecha de nacimiento al formato ISO 8601 (YYYY-MM-DD)
    const formattedDateOfBirth = new Date(dateOfBirth).toISOString().split('T')[0];

    const gender = document.getElementById('gender').value;
    const state = true;

    const address = selectDirection + ' ' + num1 + ' #' + num2 + ' ' + letter;

    // Verificar si todos los campos requeridos están llenos
    if (firstName && lastName && email && phone && dateOfBirth && gender && address && state) {

        const jsonData = {
            firstName: firstName,
            lastName: lastName,
            email: email,
            phone: phone,
            dni: $('#tags').val(),
            typeInit: $('#selectElement').val(),
            dateOfBirth: formattedDateOfBirth, // Enviar la fecha formateada
            gender: gender,
            address: address,
            state: state
        };

        // Realizar la solicitud Fetch
        fetch('http://localhost:9000/service-security/v1/api/client/personCustomer', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(jsonData),
        })
        .then(response => {
            if (!response.ok) {
                Swal.fire({
                    title: 'Error',
                    text: 'Error de registro',
                    icon: 'error',
                    confirmButtonText: 'Volver'
                  })            }
            return response.json();
        })
        .then(data => {
            Swal.fire({
                title: 'Success',
                text: 'Registro exitoso',
                icon: 'Success',
              })
              location.reload();
        })
        .catch(error => {
            console.error('Error:', error);
            // Aquí puedes manejar errores de red o del servidor
        });
    } else {
        // Mostrar mensaje de error si algún campo requerido está vacío
        console.error('Por favor, llene todos los campos requeridos.');
    }
});

function save() {
    
        const requestData = {
            state: true,
            person: {
                id:  document.getElementById('id').value,
            },
        };

        // FETCH GUARDAR CLIENTE

        fetch('http://localhost:9000/service-security/v1/api/client', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestData) 
        })
        .then(response => {
            if (!response.ok) {
                
                Swal.fire({
                    title: 'Error!',
                    text: 'La persona ya es cliente',
                    icon: 'error',
                    confirmButtonText: 'Error'
                  })

                  disabledBotton();

            }
            return response.json();
        })
        .then(data => {
            loadData();
            cleanData();

            Swal.fire({
                title: 'succes!',
                text: 'Cliente agregado',
                icon: 'success',
                confirmButtonText: 'Aceptar'
              })
              disabledBotton();
        })
        .catch(error => {
            console.error('Error en la solicitud:', error);
        });
}

function openModal() {
    const tagsValue = document.getElementById('tags').value.trim();
    
    // Verificar si el campo tags está vacío
    if (tagsValue === '') {
        // Si está vacío, llamar a la función save() para guardar los datos del cliente
        save();
    } else {
        // Si no está vacío, abrir el modal como lo estás haciendo actualmente
        // Aquí pon tu código para abrir el modal
    }
}

// FUNCION AUTOCOMPLETE

$(function() {
    fetch('http://localhost:9000/service-security/v1/api/person/document')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            let availableTags = [];
            const person = data.data;
            person.forEach(item => {
                availableTags.push({id: item.id, value:item.dni});
            });

            $("#tags").autocomplete({
                source: function(request, response) {
                    var results = $.ui.autocomplete.filter(availableTags, request.term);
                    if (!results.length) {
                      results = [{ label: 'No se encontraron resultados', value: null }];

                    }
                    response(results) ;
                },
                select: function(event, ui) {
                    // Al seleccionar un elemento, obtener el ID y hacer otra solicitud para obtener los detalles
                    const selectedId = ui.item.id;
                    $('#id').val(selectedId);
                        var btnAgregar = $('button[name="btnAgregar"]');
                      btnAgregar.text('Agregar cliente');
                      btnAgregar.attr('onclick', 'save()');
                      btnAgregar.removeAttr('data-bs-toggle');
                      btnAgregar.removeAttr('data-bs-target');


                    

fetch(`http://localhost:9000/service-security/v1/api/person/${selectedId}`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })

    .then(data => {
        const a = data.data;

        console.log(data)
        $('#namePerson').val(a.firstName);
        
        // var btnAgregar = $('button[name="btnAgregar"]');
        // btnAgregar.text('Agregar');
        // btnAgregar.attr('onclick', 'save()');
        // btnAgregar.removeAttr('data-bs-toggle');
        // btnAgregar.removeAttr('data-bs-target');

    })
    .catch(error => {
        console.error('Error al obtener los detalles de la persona:', error);
    });
                }
            });
        })
        .catch(error => {
            // Función que se ejecuta si hay un error en la solicitud
            console.error('Error en la solicitud:', error);
        });
});        

fetch('http://localhost:9000/service-security/v1/api/enum/tipo-id')
.then(response => {
    if (!response.ok) {
        throw new Error('Error al enviar los datos');
    }
    return response.json();
})
.then(data => {
    const TypeId = data;
    
    // Obtener el select2 element
    const selectElement = document.getElementById('selectElement');
    // const selectElement2 = document.getElementById('selectElement2');
    selectElement.innerHTML = '';

    // Iterar sobre los datos recibidos y crear las opciones del select2
    TypeId.forEach(TypeId => {
        const option = document.createElement('option');
        option.value = TypeId; 
        option.text = TypeId; 
        selectElement.appendChild(option);
    });
})
.catch(error => {
    console.error('Error al enviar los datos:', error);
});


document.addEventListener('DOMContentLoaded', function () {
    loadData();
});

function loadData() {
    fetch('http://localhost:9000/service-security/v1/api/client')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {

        const roles = data.data;

        var html = '';
  
        roles.forEach(item => {
          // Construir el HTML para cada objeto
          html += `<tr>
                  <td>${item.id}</td>
                  <td>${item.code}</td>
                  <td>${item.person.firstName}</td>
                  <td>${item.person.dni}</td>
                  <td>${item.person.typeInit}</td>
                  <th><img src="../../assets/icon/pencil-square.svg" alt="" onclick="findById(${item.id})"></th>
                  <th><img src="../../assets/icon/trash3.svg" alt="" onclick="deleteById(${item.id})"></th>
              </tr>`;
        });
  
        document.getElementById('resultData').innerHTML = html;
      })
      .catch(error => {
        // Función que se ejecuta si hay un error en la solicitud
        console.error('Error en la solicitud:', error);
      });
  }

function cleanData(){
    $('#namePerson').val('');
    $('#tags').val('');

}
const miInput = document.getElementById('tags');
const btnAgregar = document.querySelector('button[name="btnAgregar"]');

function inputChangeHandler() {
  if (miInput.value.trim() !== '' && miInput.value.trim()) {
    btnAgregar.classList.remove('disabled');
  } else {
    btnAgregar.textContent = 'Agregar Persona';
    btnAgregar.removeAttribute('onclick');
    btnAgregar.removeAttribute('data-bs-toggle');
    btnAgregar.removeAttribute('data-bs-target');
    btnAgregar.classList.add('disabled');
    document.getElementById('namePerson').value = '';
  }
}

miInput.addEventListener('input', inputChangeHandler);


fetch('http://localhost:9000/service-security/v1/api/enum/direction')
.then(response => {
    if (!response.ok) {
        throw new Error('Error al enviar los datos');
    }
    return response.json();
})
.then(data => {
    const TypeId = data;
    
    // Obtener el select2 element
    const selectElement = document.getElementById('selectDirection');
    selectElement.innerHTML = '';

    // Iterar sobre los datos recibidos y crear las opciones del select2
    TypeId.forEach(TypeId => {
        const option = document.createElement('option');
        option.value = TypeId; 
        option.text = TypeId; 
        selectElement.appendChild(option);
    });
})
.catch(error => {
    console.error('Error al enviar los datos:', error);
});
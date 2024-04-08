document.addEventListener('DOMContentLoaded', function () {
    loadData();
    loadModules();
});

function loadData() {
    fetch('http://localhost:9000/service-security/v1/api/view/list')
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
                  <td>${item.view}</td>
                  <td>${item.route}</td>
                  <td>${item.description}</td>
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

  function deleteById(id) {
    fetch('http://localhost:9000/service-security/v1/api/view/' + id, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      }
    })
    .then(response => {
      if (response.ok) {
        alert('Registro eliminado con éxito');
        loadData();
      }
    })
    .catch(error => {
      console.error('Error al eliminar el registro:', error);
    });
  }
  function findById(id) {
    fetch('http://localhost:9000/service-security/v1/api/view/' + id)
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        const form = document.getElementById('formEdit');
          form.classList.remove('visually-hidden');
        // Actualizar los campos con los datos recibidos
        document.getElementById('idEdit').value = data.data.id;
        document.getElementById('nameEdit').value = data.data.name;
        document.getElementById('routeEdit').value = data.data.route;
        document.getElementById('descriptionEdit').value = data.data.description;
      })
      .catch(error => {
        // Función que se ejecuta si hay un error en la solicitud
        console.error('Error en la solicitud:', error);
      });
  }
  
  
  document.getElementById('form-role').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission

      const formData = {
        name: document.getElementById('name').value,
        description: document.getElementById('description').value,
        route: document.getElementById('route').value,
        state: true
      };
    
      fetch('http://localhost:9000/service-security/v1/api/view', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      })
      .then(response => {
        if (!response.ok) {
          throw new Error('Error al enviar los datos');
        }
        return response.json();
      })
      .then(data => {
        const loadModuleView = {
          "state": true,
          "module": {
            "id": document.getElementById('selectElement').value
          },
          "view": {
            "id": data.data.id
          }
        };
  
        fetch('http://localhost:9000/service-security/v1/api/module-view', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(loadModuleView)
        })
        .then(response => {
          if (!response.ok) {
            throw new Error('Error al enviar los vistas');
          }
          return response.json();
        })
        .then(data => {
          console.log('vistas enviados correctamente:', data);
  
  })
        .catch(error => {
          console.error('Error al enviar los vistas:', error);
        });
  

        loadData()      
})
      .catch(error => {
        console.error('Error al enviar los datos:', error);
      });

      

  });

  function loadModules(){

  fetch('http://localhost:9000/service-security/v1/api/module/list')
.then(response => {
    if (!response.ok) {
        throw new Error('Error al enviar los datos');
    }
    return response.json();
})
.then(data => {
    console.log('Datos recibidos correctamente:', data);

    const modules = data.data;
    
    // Obtener el select2 element
    const selectElement = document.getElementById('selectElement');

    // Limpiar el select2 element
    selectElement.innerHTML = '';

    // Iterar sobre los datos recibidos y crear las opciones del select2
    modules.forEach(module => {
        const option = document.createElement('option');
        option.value = module.id; // Suponiendo que el campo 'id' contiene el valor a usar como value del option
        option.text = module.module; // Suponiendo que el campo 'name' contiene el texto a mostrar en el option
        selectElement.appendChild(option);
    });
})
.catch(error => {
    console.error('Error al enviar los datos:', error);
});

}

  document.getElementById('formEdit').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission

    // Construir el objeto data
    const dataForm = {
      "id": document.getElementById('idEdit').value,
      "state": true,
      'name': document.getElementById('nameEdit').value,
      'description': document.getElementById('descriptionEdit').value,
      'route': document.getElementById('routeEdit').value,
    };
    var id = document.getElementById('idEdit').value;
  
    fetch('http://localhost:9000/service-security/v1/api/view/' + id, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(dataForm)
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Error al actualizar el registro');
      }
      alert('Registro actualizado con éxito');
      loadData();
      const form = document.getElementById('formEdit');
      form.classList.add('visually-hidden');
    })
    .catch(error => {
      console.error('Error al actualizar el registro:', error);
    });
});
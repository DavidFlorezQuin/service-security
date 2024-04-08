document.addEventListener('DOMContentLoaded', function () {
    loadData();
});

function loadData() {
    fetch('http://localhost:9000/service-security/v1/api/user/list')
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
                  <td>${item.user}</td>
                  <td>${item.personName}</td>
                  <td>${item.personEmail}</td>
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
    fetch('http://localhost:9000/service-security/v1/api/user/' + id, {
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

    function assignUserRole(userId, roleId, isChecked) {
        const url = isChecked ?'http://localhost:9000/service-security/v1/api/userRole':'http://localhost:9000/service-security/v1/api/userRole/' + id;
        const method = isChecked ? 'POST' : 'DELETE';
        const body = JSON.stringify({
          user: { id: userId },
          role: { id: roleId },
          state: true
        });
    
        fetch(url, {
          method: method,
          headers: {
            'Content-Type': 'application/json'
          },
        //   body: body
        })
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          console.log(`Role ${isChecked ? 'assigned' : 'unassigned'} successfully.`);
        })
        .catch(error => {
          console.error('Error assigning role to user:', error);
        });
      }

    fetch('http://localhost:9000/service-security/v1/api/user/' + id)
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(userData => {
        const form = document.getElementById('formEdit');
        form.classList.remove('visually-hidden');
        
        // Actualizar los campos con los datos recibidos
        document.getElementById('idEdit').value = userData.data.id;
        document.getElementById('nameEdit').value = userData.data.username;
        document.getElementById('descriptionEdit').value = userData.data.person.email;
  
        // Obtener los roles asociados al usuario
        fetch('http://localhost:9000/service-security/v1/api/userRole/UserRole', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ id: userData.data.id }) 
        })
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json();
        })
        .then(userRoleData => {
          const rolesData = userRoleData.data;
          
          // Obtener todos los roles disponibles
          fetch('http://localhost:9000/service-security/v1/api/role/list')
            .then(response => {
              if (!response.ok) {
                throw new Error('Network response was not ok');
              }
              return response.json();
            })
            .then(rolesResponse => {
              const roles = rolesResponse.data;
              var html = '';
              
              // Construir el HTML para cada objeto de roles
              roles.forEach(role => {
                html += ` 
                  <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="${role.id}" id="role_${role.id}" ${rolesData.some(userRole => userRole.id === role.id) ? 'checked' : ''}>
                    <label class="form-check-label" for="role_${role.id}">
                      ${role.role}
                    </label>
                  </div>`;
              });
  
              document.getElementById('rolesData').innerHTML = html;

              roles.forEach(role => {
                const checkbox = document.getElementById(`role_${role.id}`);
                checkbox.addEventListener('change', function() {
                  const userId = userData.data.id;
                  const roleId = role.id;
                  const isChecked = this.checked;
                  assignUserRole(userId, roleId, isChecked);
                });
              });
            })

            
            .catch(error => {
              console.error('Error en la solicitud de roles:', error);
            });
        })
        .catch(error => {
          console.error('Error en la solicitud de roles asociados al usuario:', error);
        });
  
      })
      .catch(error => {
        console.error('Error en la solicitud de usuario:', error);
      });
  }
  
  
  document.getElementById('form-role').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission

      const formData = {
        name: document.getElementById('name').value,
        description: document.getElementById('description').value,
        state: true
      };
    
      fetch('http://localhost:9000/service-security/v1/api/role', {
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

        console.log('Datos enviados correctamente:', data);
loadData()      
})
      .catch(error => {
        console.error('Error al enviar los datos:', error);
      });

    
  });


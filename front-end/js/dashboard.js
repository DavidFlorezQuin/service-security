
document.addEventListener('DOMContentLoaded', function () {
    loadData();

    var enlaces = document.getElementById('enlaces');

// Iterar sobre los enlaces y agregar un event listener para el evento clic
    enlaces.forEach(function(enlace) {
    enlace.addEventListener('click', function(event) {
    event.preventDefault(); // Evitar el comportamiento normal del enlace
    alert('Has hecho clic en el enlace, pero no se ha navegado a otra página.');


  });
});
});

document.getElementById('logoutButton').addEventListener('click', function() {
    // Eliminar los datos de inicio de sesión de localStorage
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('formData'); // Elimina cualquier otro dato relacionado con la sesión
    
    // Redirigir a la página de inicio de sesión
    window.location.href = '/login.html';
});

const formDataString = localStorage.getItem('formData');
const formData = JSON.parse(formDataString);
function loadData(){

// Convertir los datos del usuario de JSON a un objeto JavaScript

const userName = formData.personName;
const saludo = `¡Hola, ${userName}!`;
document.getElementById("saludo").innerHTML = saludo;
}
window.onload = function() {
    loadData();
    // Otras acciones que necesites realizar al cargar la página
};



//USER ROLE

fetch('http://localhost:9000/service-security/v1/api/userRole/UserRole', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ id: formData.id }) // Incluir el valor de id como parte del cuerpo de la solicitud
})
.then(response => {
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    return response.json();
})
.then(data => {
    // Acceder a los datos devueltos por la solicitud POST
    const usersData = data.data;

    // Mostrar los datos en la página HTML
    const userContainer = document.getElementById('userContainer');

    usersData.forEach(userData => {
        const userElement = document.createElement('div');
        userElement.innerHTML = `
            <p>Rol: ${userData.id}</p>
            <p>Rol: ${userData.roleName}</p>
            <hr> <!-- Línea separadora entre cada usuario -->
        `;
        userContainer.appendChild(userElement);

        //MODULE-ROLE
        // Realizar el segundo fetch aquí, dentro del bloque then del primer fetch
        fetch('http://localhost:9000/service-security/v1/api/module-role/moduleRole', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ id: userData.id }) // Incluir el valor de id como parte del cuerpo de la solicitud
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // Acceder a los datos devueltos por la solicitud POST
            const moduleData = data.data;

            // Mostrar los datos en la página HTML
            const navbarNav = document.querySelector('.navbar-nav');
            
            moduleData.forEach(moduleData => {
                const listItem = document.createElement('li');
                const link = document.createElement('a');
                const dropdownMenu = document.createElement('ul');

                
                // Agregar clases y atributos necesarios
                listItem.classList.add('nav-item', 'dropdown');
                link.classList.add('nav-link', 'dropdown-toggle');
                dropdownMenu.classList.add('dropdown-menu');
                link.href = '#'; 
                link.setAttribute('role', 'button');
                link.setAttribute('data-bs-toggle', 'dropdown');
                link.setAttribute('aria-expanded', 'false');
                
                // Agregar el nombre del módulo como texto dentro del enlace
                link.textContent = moduleData.moduleName;
            
                // Agregar el enlace al elemento li y el elemento li al contenedor ul
                listItem.appendChild(link);
                listItem.appendChild(dropdownMenu);
                navbarNav.appendChild(listItem);

                //MODULE-VIEW

                fetch('http://localhost:9000/service-security/v1/api/module-view/moduleView', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ id: moduleData.id }) // Incluir el valor de id como parte del cuerpo de la solicitud
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(data => {
                    // Acceder a los datos devueltos por la solicitud POST
                    const viewData = data.data;


                    viewData.forEach(viewData => {

                        const viewListItem = document.createElement('li');
                        const viewLink = document.createElement('a');
                        viewLink.classList.add('dropdown-item');
                        viewLink.setAttribute('id', 'enlaces');
                        viewLink.href = viewData.routeName; // Puedes poner la URL correspondiente si lo deseas
                        viewLink.textContent = viewData.viewName;
                        dropdownMenu.appendChild(viewListItem);
                        viewListItem.appendChild(viewLink);                
                    });
                })
                .catch(error => {
                    // Handle error
                    console.error('There was a problem with fetching modules:', error);
                    // Display an error message to the user, clear form fields, etc.
                });
            });
        })
        .catch(error => {
            // Handle error
            console.error('There was a problem with fetching modules:', error);
            // Display an error message to the user, clear form fields, etc.
        });
    });
    
})
.catch(error => {
    // Handle error
    console.error('There was a problem with fetching user roles:', error);
    // Display an error message to the user, clear form fields, etc.
});


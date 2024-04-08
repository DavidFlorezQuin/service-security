fetch('http://localhost:9000/service-security/v1/api/enum/tipo-id')
.then(response => {
    if (!response.ok) {
        throw new Error('Error al enviar los datos');
    }
    return response.json();
})
.then(data => {
    const TypeId = data;
    
    const selectElement = document.getElementById('selectElement');

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
        fetch('http://localhost:9000/service-security/v1/api/client', {
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






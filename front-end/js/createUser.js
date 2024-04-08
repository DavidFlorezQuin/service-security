document.getElementById('personForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission


const personId = sessionStorage.getItem('personId');


const formData = {
    username: document.getElementById('userName').value,
    password: document.getElementById('password').value, 
    state: true, 
    person: {
        id: personId
    }
};

fetch('http://localhost:9000/service-security/v1/api/user', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        // Handle successful login response
        console.log('Login successful:', data);
        localStorage.setItem('formData', JSON.stringify(data.data));
        window.location.href = '../../index.html';
        

    })
    .catch(error => {
        // Handle error
        console.error('There was a problem with the login:', error);
        // Display an error message to the user, clear form fields, etc.
    });
});
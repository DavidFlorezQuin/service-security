document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission

    // Get the form data
    const formData = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };

    // Make an HTTP POST request to the API
    fetch('http://localhost:9000/service-security/v1/api/user/login', {
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
        window.location.href = './navbar.html';
        
        localStorage.setItem('formData', JSON.stringify(data.data));

    })
    .catch(error => {
        // Handle error
        console.error('There was a problem with the login:', error);
        // Display an error message to the user, clear form fields, etc.
    });
});


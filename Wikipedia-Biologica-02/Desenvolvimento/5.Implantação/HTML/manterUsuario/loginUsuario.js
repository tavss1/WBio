export async function login() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('senha').value;

    const response = await fetch(`http://127.0.0.1:8080/user/login`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: `email=${email}&password=${password}`,
        credentials: "include" 
    });

    if (response.ok) {
        alert("Login bem-sucedido!");
        //window.location.href = '/home/visualizarAnimais.html';
    } else {
        alert("Credenciais inválidas!");
    }
}
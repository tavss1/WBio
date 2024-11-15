export function cadastrarAdm(){
    var nome = document.getElementById("nome").value;
    var email = document.getElementById("email").value;
    var senha = document.getElementById("senha").value;
    var lattes = document.getElementById("lattes").value;

    var adm = {
        nome: nome,
        email: email,
        senha: senha,
        lattes: lattes
    }

    fetch('http://localhost:8080/admin/cadastrarAdmin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(adm),
    })
    .then(response => {
        if (response.ok) {
            // O animal foi adicionado com sucesso
            console.log('Administrador cadastrado com sucesso!');
            // Aqui você pode redirecionar o usuário para outra página, por exemplo:
            // window.location.href = '/pagina-de-sucesso';
        } else {
            // Ocorreu algum erro ao adicionar o animal
            console.error('Erro ao cadastrar Administrador:', response.statusText);
        }
    })
    .catch(error => {
        console.error('Erro de conexão:', error);
    });
}
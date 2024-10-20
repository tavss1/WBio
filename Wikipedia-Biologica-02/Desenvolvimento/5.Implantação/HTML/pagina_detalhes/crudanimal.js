import getDados from "../home/getDados.js";


export function cadastrar() {
    var nome = document.getElementById("nomepopular").value;
    var filo = document.getElementById("filo").value;
    var classe = document.getElementById("classe").value;
    var ordem = document.getElementById("ordem").value;
    var familia = document.getElementById("familia").value;
    var genero = document.getElementById("genero").value;
    var especie = document.getElementById("especie").value;
    var descricao = document.getElementById("descricao").value;
    var imagem = document.getElementById("imagem").value;
    var peso = document.getElementById("peso").value;
    var habitat = document.getElementById("habitat").value;
    var alimentacao = document.getElementById("alimentacao").value;

    // Criar objeto com os dados do animal
    var animal = {
        nomePopular: nome,
        filo: filo,
        classe: classe,
        ordem: ordem,
        familia: familia,
        genero: genero,
        especie: especie,
        descricao: descricao,
        imagem: imagem,
        peso: peso,
        habitat: habitat,
        alimentacao: alimentacao
    };

    // Fazer requisição POST para adicionar o animal
    fetch('http://localhost:8080/animais/adicionarAnimal', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(animal),
    })
    .then(response => {
        if (response.ok) {
            // O animal foi adicionado com sucesso
            console.log('Animal cadastrado com sucesso!');
            // Aqui você pode redirecionar o usuário para outra página, por exemplo:
            // window.location.href = '/pagina-de-sucesso';
        } else {
            // Ocorreu algum erro ao adicionar o animal
            console.error('Erro ao cadastrar animal:', response.statusText);
        }
    })
    .catch(error => {
        console.error('Erro de conexão:', error);
    });
}


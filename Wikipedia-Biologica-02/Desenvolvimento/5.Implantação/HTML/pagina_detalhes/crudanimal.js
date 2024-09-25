import getDados from "../home/getDados.js";


document.querySelector("#id").addEventListener("change", function(){
    const id = document.getElementById("id").value
    const elementos = {
        nomepopular : document.getElementById("nomepopular")
    }

    const url = ["/animais/getDadosAnimal/" + id]

    Promise.all(url.map(u => getDados(u)))
    .then(data => {
        
        if(data[0].nomePopular == null){
            alert("Identificador não encontrado, digite um identificador válido")
            return;
        }

        document.getElementById("nomepopular").value = data[0].nomePopular;
        document.getElementById("nomepopular").removeAttribute("hidden")

        document.getElementById("filo").value = data[0].filo;
        document.getElementById("filo").removeAttribute("hidden")

        document.getElementById("classe").value = data[0].classe;
        document.getElementById("classe").removeAttribute("hidden")

        document.getElementById("ordem").value = data[0].ordem;
        document.getElementById("ordem").removeAttribute("hidden")

        document.getElementById("familia").value = data[0].familia;
        document.getElementById("familia").removeAttribute("hidden")

        document.getElementById("genero").value = data[0].genero;
        document.getElementById("genero").removeAttribute("hidden")

        document.getElementById("especie").value = data[0].especie
        document.getElementById("especie").removeAttribute("hidden")

        document.getElementById("descricao").value = data[0].descricao
        document.getElementById("descricao").removeAttribute("hidden")

        document.getElementById("imagem").value = data[0].imagem;
        document.getElementById("imagem").removeAttribute("hidden")

        document.getElementById("peso").value = data[0].peso;
        document.getElementById("peso").removeAttribute("hidden")

        document.getElementById("habitat").value = data[0].habitat;
        document.getElementById("habitat").removeAttribute("hidden")
        
        document.getElementById("alimentacao").value = data[0].alimentacao;
        document.getElementById("alimentacao").removeAttribute("hidden")
        
    }).catch(error => {
        alert("Erro")
    });

    

})
    
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

export function atualizar() {
    var id = document.getElementById("id").value;
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
    fetch('http://localhost:8080/animais/autalizarAnimal/'+id, {
        method: 'PUT',
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


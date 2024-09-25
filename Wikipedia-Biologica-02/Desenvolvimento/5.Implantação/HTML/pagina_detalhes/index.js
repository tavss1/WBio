import getDados from "../home/getDados.js";

const params = new URLSearchParams(window.location.search);
const animalId = params.get('id');

const elementos = {
    animais: document.getElementById("main")
}

function carregaDetalhes(){
    console.log(animalId)
    getDados(`/animais/getDadosAnimal/${animalId}`)
    .then(dados => {        
        const main = document.createElement("main")
        
        const listaHtml =`
            <section class="product-hero">
            <img src=${dados.imagem} alt="animal" width=1000px>
            <h1>${dados.nomePopular}</h1>
            <p><i>${dados.genero} ${dados.especie}</i></p>
        </section>
        <section class="product-info">
            <div class="informacao">
            <h2>Taxonomia</h2>
            <ul>
            <li><strong>Filo:</strong>${dados.filo}</li>
            <li><strong>Classe:</strong>${dados.classe}</li>
            <li><strong>Ordem:</strong>${dados.ordem}</li>
            <li><strong>Familia:</strong>${dados.familia}</li>
            <li><strong>Gênero:</strong>${dados.genero}</li>
            <li><strong>Espécie:</strong>${dados.genero} ${dados.especie}</li>
            </ul>
        </div>
        <div class="informacao">
            <h2>Características</h2>
            <ul>
            <li><strong>Habitat:</strong>${dados.habitat}</li>
            <li><strong>Alimentação:</strong>${dados.alimentacao}.</li>
            <li><strong>Peso:</strong>${dados.peso}</li>
            
            </ul>
        </div>
        
        
        <div class="informacao">
            <h2>Descrição</h2>
            <p class="descricao">${dados.descricao}</p>
        </div>
        </section>
    `;
    

    main.innerHTML = listaHtml;
    elementos.animais.appendChild(main);
    
    })
}
carregaDetalhes()

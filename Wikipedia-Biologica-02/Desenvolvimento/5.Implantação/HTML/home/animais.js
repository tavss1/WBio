import getDados from "./getDados.js";

const elementos = {
    animais: document.getElementById("lista-animais"),
    filo: document.getElementById("filos"),
    classe: document.getElementById("classes"),
    ordem: document.getElementById("ordens"),
    familia: document.getElementById("familias"),
    genero: document.getElementById("generos")
}
const pesquisa = document.querySelector('.pesquisar-bloco')
const form = document.querySelector(".formPesquisa")

var filtros

form.addEventListener("submit", (event) => {
  event.preventDefault();
  if(pesquisa.value == ''){
    geraAnimais()
  }
  else{
    pesquisarAnimais(pesquisa.value);
  }
  console.log(pesquisa.value)
})


function carregarAnimais(elemento, dados){

    const divExistente = elemento.querySelector('div')

    if (divExistente) {
      elemento.removeChild(divExistente);
    }
    
    const div = document.createElement('div');
    div.className = 'container row mx-auto g-4 my-5'
    const listaHtml = dados.map((animal) =>`
    <div class="col-12 col-md-6 col-xxl-4">
    <div class="card rounded-0 border-0">
      <img class="d-md-none d-block" src="${animal.imagem}" alt="${animal.genero} ${animal.especie}">
      <img class="d-none d-md-block d-xl-none" src="${animal.imagem}" alt="${animal.genero} ${animal.especie}">
      <img class="d-none d-xl-block" src="${animal.imagem}" alt="${animal.genero} ${animal.especie}">
      <div class="card-body">
        <h5 class="card-title">${animal.nomePopular}</h5>
        <p class="card-text"><i>${animal.genero} ${animal.especie}</i></p>
        <a href="../pagina_detalhes/detalhes.html?id=${animal.id}" class="btn btn-primary text-light botao-produtos border-0 rounded-0">Ver mais</a>
      </div>
    </div>
  </div>
    `).join('');
    

    div.innerHTML = listaHtml;
    elemento.appendChild(div);
}

function pesquisarAnimais(nome){
  const url = ['/animais/pesquisar/' + nome]
  const divExistente = elementos.animais.querySelector('div')

    if (divExistente) {
      elementos.animais.removeChild(divExistente);
    }

  Promise.all(url.map(u => getDados(u)))
    .then(data => {
        carregarAnimais(elementos.animais, data[0])        
    })
    .catch(error => {
        lidarComErro("Ocorreu um erro ao carregar os dados. ")
    });
}

function lidarComErro(mensagemErro) {
  console.error(mensagemErro);
}


function geraAnimais(){
    const url = ['/animais']

    Promise.all(url.map(u => getDados(u)))
    .then(data => {
        carregarAnimais(elementos.animais, data[0])
        filtroFilos(elementos.filo, data[0])
        filtroClasses(elementos.classe, data[0])
        filtroFamilias(elementos.familia, data[0])
        filtroOrdens(elementos.ordem, data[0])
        filtroGeneros(elementos.genero, data[0])

        filtros = document.querySelectorAll(".dropdown-item")        
    })
    .catch(error => {
        lidarComErro("Ocorreu um erro ao carregar os dados. ")
    });
}

function filtroFilos(elemento, dados){
    const liexistente = elemento.querySelector('li')

    if(liexistente){
      elemento.removeChild(liexistente)
    }

    const li = document.createElement('li')
    const listaHtml = dados.map((animal) =>`
        <li><a class="dropdown-item" onclick="clickFiltro(event)">${animal.filo}</a></li>
    `).join('');
    

    li.innerHTML = listaHtml;
    elemento.appendChild(li);
}

function filtroClasses(elemento, dados){
  const liexistente = elemento.querySelector('li')

  if(liexistente){
    elemento.removeChild(liexistente)
  }

  const li = document.createElement('li')
  const listaHtml = dados.map((animal) =>`
      <li><a class="dropdown-item" onclick="clickFiltro(event)">${animal.classe}</a></li>
  `).join('');
  

  li.innerHTML = listaHtml;
  elemento.appendChild(li);
}

function filtroOrdens(elemento, dados){
  const liexistente = elemento.querySelector('li')

  if(liexistente){
    elemento.removeChild(liexistente)
  }

  const li = document.createElement('li')
  const listaHtml = dados.map((animal) =>`
      <li><a class="dropdown-item" onclick="clickFiltro(event)">${animal.ordem}</a></li>
  `).join('');
  

  li.innerHTML = listaHtml;
  elemento.appendChild(li);
}

function filtroFamilias(elemento, dados){
  const liexistente = elemento.querySelector('li')

  if(liexistente){
    elemento.removeChild(liexistente)
  }

  const li = document.createElement('li')
  const listaHtml = dados.map((animal) =>`
      <li><a class="dropdown-item" onclick="clickFiltro(event)">${animal.familia}</a></li>
  `).join('');
  

  li.innerHTML = listaHtml;
  elemento.appendChild(li);
}

function filtroGeneros(elemento, dados){
  const liexistente = elemento.querySelector('li')

  if(liexistente){
    elemento.removeChild(liexistente)
  }

  const li = document.createElement('li')
  const listaHtml = dados.map((animal) =>`
      <li><a class="dropdown-item" onclick="clickFiltro(event)">${animal.genero}</a></li>
  `).join('');
  

  li.innerHTML = listaHtml;
  elemento.appendChild(li);
}

export function clickFiltro(event){
  const elemento = event.target;
  const textoElemento = elemento.textContent;

  // Encontra o botão na mesma div que o elemento clicado
  const divPai = elemento.closest('div');
  const botao = divPai.querySelector('button');
  const textoBotao = botao ? botao.textContent.replace(/\s+/g, '').toLowerCase() : '';

  const url = ['/animais/filtro/' + textoBotao + '/' + textoElemento]
  const divExistente = elementos.animais.querySelector('div')

    if (divExistente) {
      elementos.animais.removeChild(divExistente);
    }

  Promise.all(url.map(u => getDados(u)))
    .then(data => {
        carregarAnimais(elementos.animais, data[0])        
    })
    .catch(error => {
        lidarComErro("Ocorreu um erro ao carregar os dados. ")
    });
}

geraAnimais();

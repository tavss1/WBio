export function loadComponent(componentId, filePath) {
    fetch(filePath)
      .then(response => response.text())
      .then(data => {
        document.getElementById(componentId).innerHTML = data;
      });
  }
  
  // Carregar header e footer
  loadComponent("header-container", "/componentes/header.html");
  loadComponent("footer-container", "/componentes/footer.html");
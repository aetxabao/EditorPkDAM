<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/estilo.css">
</head>
<body>
    <h1>Nivel Fuego rojo</h1>
    <div id="contenedor">
        <div id="tablero">
            <#list 0..39 as i>
                <#list 0..29 as j>
<div class="celda" data-fila="${i}" data-columna="${j}"></div>
                </#list>
            </#list>
        </div>
        <div id="escenario">
            <h2>Escenario</h2>
            <div class="horizontal">
                <div id="inicio" class="celda pintura" onclick="elegirPintura(this,true,0)"></div><h3>Inicio</h3>
            </div>
            <div class="horizontal">
                <div id="fin" class="celda pintura" onclick="elegirPintura(this,true,1)"></div><h3>Fin</h3>
            </div>
            <div class="horizontal">
                <div id="tierra" class="celda pintura selected" onclick="elegirPintura(this,true,2)"></div><h3>Tierra</h3>
            </div>
            <div class="horizontal">
                <div id="agua" class="celda pintura" onclick="elegirPintura(this,true,3)"></div><h3>Agua</h3>
            </div>
            <div class="horizontal">
                <div id="pared" class="celda pintura" onclick="elegirPintura(this,true,4)"></div><h3>Pared</h3>
            </div>
        </div>
        <div id="elementos">
            <h2>Elementos</h2>
        </div>
        <div id="acciones">
            <h2>Acciones</h2>
        </div>
    </div>
<script>
    let isMouseDown = false;
    let idx = 2;

    const colsSurfaces = [
        '#0f0',         //Inicio
        '#f00',         //Fin
        '#7A420D',      //Tierra
        '#0000FF',      //Agua
        '#444'          //Pared
    ];

    document.addEventListener('mouseup', (e) => {
       isMouseDown = false;
    });

    document.querySelectorAll('#tablero .celda')
        .forEach( celda => {
            celda.addEventListener('mousedown', (e) => {
                // console.log('mousedown');
                isMouseDown = true;
                pintarCelda(celda);
            });
            celda.addEventListener('mouseover', (e) => {
                // console.log('mouseover');
                if (isMouseDown) {
                    pintarCelda(celda);
                }
            });
            celda.addEventListener('mouseup', (e) => {
                // console.log('mouseup');
                isMouseDown = false;
            });
        });

    function pintarCelda(celda) {
        celda.style.backgroundColor = colsSurfaces[idx];
    }

    function elegirPintura(elemento, superficie, indice) {
        document.querySelectorAll('.pintura')
            .forEach(celda => {
               celda.classList.remove('selected');
            });
        elemento.classList.add('selected');
        idx = indice;
    }
</script>
</body>
</html>
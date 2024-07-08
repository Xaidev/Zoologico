# Proyecto final | Desarrollo Orientado a Objetos
## Tema 3: Zoológico Interactivo
## Grupo 16 Integrantes:
* Sebastián Emir Garcías Cabrera
* Jesús David Guevara Salcedo
* Agustín Andrés Lineros Cid

## Instrucciones
Al clonar el repositorio, realizar lo siguiente:
1. Ejecutar el archivo "ventana.java" en el paquete "visual".
2. Al abrir el programa, seleccionar uno de los 4 cuadros para crear un hábitat.
3. Al elegir un cuadro en blanco de los que estén disponibles, seleccionar las características del hábitat que desee.
4. Una vez creado el hábitat, seleccionar qué animales se quieren añadir a este.
> La lista de animales puede variar dependiendo del hábitat.
5. Disfrutar de alimentar a los animales cuando sea necesario.
## Diagrama de clases UML:
![uml Zoologico (2)](https://github.com/Xaidev/Zoologico/assets/150608054/5e9102fc-a214-4a41-bfee-9db6b9518cbf)

## Diagrama de casos de uso:
![diagrama de casos de uso](https://github.com/Xaidev/Zoologico/assets/150608054/f60984c9-5e31-4bb0-bd1a-2ac24d2fa746)


## Patrones de diseño que se utilizaron:
* Builder: Se utilizó este patrón de diseño debido a que nos permitió crear diferentes representaciones de un hábitat en tiempo real, lo cual
 es crucial para poder seleccionar las características del hábitat y luego filtrar qué animales tienen las condiciones para habitar dentro de este.
* Template Method: Se utilizó este patrón de diseño para los animales, ya que dentro de la clase abstracta "Animales", se actualiza el estado de los animales, ya sea desplazándose
 o alimentándose. Como cada animal se desplaza de manera diferente, era importante poder modificar individualmente sus movimientos sin afectar al resto del proceso.
  
## Interfaz de Usuario(UI):
* Inicio de programa:
![imagen menu inicial](https://github.com/Xaidev/Zoologico/assets/150608054/ec503dd6-7791-4b8b-8cbc-a6ade1e71d7b)

* Selector de habitats:
![imagen seleccion de habitats](https://github.com/Xaidev/Zoologico/assets/150608054/22b07e2b-795c-484b-b47d-8f6cfdff5a07)

* Interfaz dentro del Habitat:
![imagen dentro del habitat](https://github.com/Xaidev/Zoologico/assets/150608054/11819277-89da-4479-bb9c-cee9fa58d029)

## Decisiones dentro del proyecto: 
Inicialmente, decidimos empezar con un pequeño boceto de cómo podría ser nuestra interfaz final. Luego, desarrollamos las bases y la primera versión del diagrama
de clases UML. Este incluía algunas clases que no están presentes en el código actual o que no estaban inicialmente planeadas.

En cuanto al código, comenzamos con la lógica del mismo en un paquete con el mismo nombre. Poco a poco, se introdujeron los códigos necesarios para el correcto funcionamiento
interno, es decir, todo lo que no está relacionado con la interfaz visual. Mientras tanto, se diseñaban los sprites de los distintos animales en estilo pixel art, elegido por preferencia del grupo.

Decidimos que cada tipo de animal tendría un movimiento específico: los terrestres se desplazan solo horizontalmente. Los voladores extienden la clase "terrestre" para mantener
este movimiento horizontal y se les añade la función de vuelo, que se representa con un movimiento vertical. Los acuáticos pueden moverse libremente en cualquier dirección para simular su entorno acuático.

En el desarrollo del paquete "visual", la primera decisión fue crear el botón "Crear hábitat". Utilizamos un pop-up menu junto con un optionPanel para ofrecer las opciones
de los builders y crear el hábitat deseado. Desde allí, se crearon los diferentes botones utilizados en el programa, como el botón "Retroceder" para volver a un menú anterior y el botón "Manual", que proporciona información sobre la alimentación de los animales en un hábitat.

Los fondos de los hábitats también fueron diseñados en estilo pixel art para mantener coherencia con el diseño de los animales.

## Autocrítica:
Hubo dos grandes problemas. Uno fue adaptar las imágenes de alimentación de los animales, un desafío visual donde tuvimos que actualizar correctamente las imágenes basadas
en cómo se alimentaban los animales con su hilo respectivo. El otro problema fue con los paneles de aviso, donde necesitábamos sincronizar correctamente el panel exterior
con los paneles individuales de cada hábitat.

Como autocrítica, creemos que el programa podría haberse integrado mejor simplificando la conexión entre la lógica y la interfaz visual. También pensamos que podríamos
haber utilizado mejor el patrón builder para filtrar opciones al crear hábitats. Nos habría gustado implementar mejores animaciones para cada animal y haber optimizado
el uso de hilos para reducir errores, ya que lidiar con ellos fue un desafío constante.

Además, al utilizar el patrón de diseño "Template Method", encontramos que mantener el código puede ser más complejo a medida que se añaden más funciones 
únicas para cada tipo de animal. Esto podría volverse contraproducente en el futuro.


# App de Recetas (Proyecto PMDM)

Aplicación sencilla de recetas para Android, desarrollada en **Kotlin**, como proyecto para la asignatura de **Programación Multimedia y Dispositivos Móviles (PMDM)**.

La aplicación permite al usuario seleccionar los ingredientes que tiene en casa y le muestra qué recetas puede preparar, indicando el porcentaje de coincidencia de ingredientes.

## Características

La aplicación consta de 4 pantallas principales:

1.  **Pantalla Inicial:** Portada de la aplicación con acceso a las demás secciones.
2.  **Pantalla de Ingredientes:** El usuario marca (mediante *CheckBoxes*) los 11 ingredientes disponibles que tiene.
3.  **Pantalla de Resumen de Recetas:**
    * Muestra el **porcentaje** de ingredientes que el usuario tiene para cada una de las 4 recetas.
    * Indica el nombre de la receta en un color según el porcentaje:
        * **Verde:** Si es superior al 90%.
        * **Rojo:** Si es inferior al 50%.
        * **Amarillo:** El resto de casos.
    * Permite pulsar en una receta para ver sus detalles.
4.  **Pantalla de Descripción:** Muestra la información detallada de la receta seleccionada (nombre, lista de ingredientes y descripción de la preparación).

## Tecnologías Utilizadas

* **Lenguaje:** Kotlin
* **Plataforma:** Android (SDK Nativo)
* **IDE:** Android Studio

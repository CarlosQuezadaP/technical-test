# Meli Search App

Este proyecto fue realizado con el objetivo de participar en el proceso de seleccion para el cargo de android developer.

## Arquitectura
Clean Architecture - MVVM  - Modularizacion por feature
En este proyecto se utiliza el patron de presentación MVVM, Jetpack Components y Clean architecture.

### Librerias
1) JetPack: 

```bash
- ViewModel (https://developer.android.com/topic/libraries/architecture/viewmodel) 
- LiveData (https://developer.android.com/topic/libraries/architecture/livedata) 
- Navigation Component (https://developer.android.com/guide/navigation) (https://developer.android.com/training/data-storage/room) 
- View Binding (https://developer.android.com/topic/libraries/data-binding) 
- Paging (https://developer.android.com/topic/libraries/architecture/paging )
- Retrofit (https://developer.android.com/topic/libraries/data-binding) 

 Otras librerias
- Coil (https://github.com/coil-kt/coil) 
- arrow(https://arrow-kt.io/) 
- Lottie(https://lottiefiles.com/)
- 
```

### Pendiente por finalizar

1. Migracion de Lenguaje Groovy a kotlin por medio de Kotlin DLS
2. Gestion de recursos compartidos en gradle
3. Aplicacion de pruebas unitarias a Viewmodel y presenter por medio de la herramienta de 
https://mockk.io/ 
4. Aplicacion de UI test por medio de Espresso.
5. Utilizar una estrategia de gestion de errores.
Para un servicio se utilizo la libreria Either el cual por medio de un flow se emite un resultado por derecha(Response) y un resultado por respuesta.
Para otro servicio se uso una sealed class y para esta se manejo un ebject en caso de salir un error. 
La idea final era utilzar un procesador de errores que gestionara desde la clase padre en caso de llegar  
- Data (Repository) se mapea a tipo domain
- Domain (Use Case).
 
Y al final levantar el mensaje final de error al usuario.

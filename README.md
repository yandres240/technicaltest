# technicaltest
Prueba Práctica Android AppGate

Para refactorizar el código deberían seguir los siguientes pasos:

Usar una librería para el consumo de apis, un claro ejemplo es Retrofit para simplificar el consumo de servicios mediante interfaces, además de poder usar interceptores para realizar el refresco de tokens para la comunicación entre apis. 
A nivel de almacenamiento no se debería almacenar información sensible como credenciales u otros datos que puedan afectar la seguridad de la aplicación.
A nivel de código se debería hacer un manejo de hilos para tareas asíncronas que permitan a la interfaz de usuario desligarse de las tareas que requieren más tiempo para su procesamiento.
Se trato de usar el patrón MVP para la arquitectura, pero es recomendable usar firebase para la lectura de información para no consumir demasiados servicios desde la app. Siempre dependerá el tipo de aplicación que se quiera construir el planteamiento de la arquitectura, pero siguiendo el estándar de Google se usuaria MVVM con las nuevas características Jetpack de android

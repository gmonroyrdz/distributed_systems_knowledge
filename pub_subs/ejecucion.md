# Guía de uso

## 1. Ejecutar el *broker*
Abre una terminal (*cmd*)
~~~bash
python broker.py
~~~

Se mostrará como resultado:
~~~bash
[BROKER] Escuchando en 0.0.0.0:14000...
~~~

## 2. Ejecutar uno o más suscriptores
Abre una terminal y ejecuta un suscriptor o más
~~~bash
python subscriber.py
~~~
Cuando se te pida, escribe el tema (*topic*), por ejemplo:
~~~bash
Tema a suscribirse: deportes
~~~
El sistema mantendrá la conexión abierta esperando mensajes del *broker*

## 3. Ejecutar uno o más publicadores
En otra terminal:
~~~bash
python publisher.py
~~~
Envía un mensaje en este formato:
~~~bash
deportes:¡El América ganó 15-0!
~~~
Todos los *suscriptores* suscritos a *deportes* recibirán:
~~~bash
[deportes] ¡El Pumas ganó 5-0!
~~~
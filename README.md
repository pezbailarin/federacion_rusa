federacion rusa
===============

Aprendiendo a programar android.

Este programa no tiene ninguna finalidad aparte de permitir que me vaya familiarizando con el 
entorno de programación IDEA, con GitHub y por supuesto con el SDK de Android.

Primer Commit
---

Primera versión funcional, carga un ListView con el nombre de varios estados de la antigua URSS, 
al seleccionar algún item abre una nueva activity en la que carga la info de wikipedia sobre ese estado 
mediante un control webView.

Utiliza:
* ListView
* Adapter
* Intent
* startActivity
* permission INTERNET
* Fragmentos

Segundo Commit
---

Si se trabaja en modo landscape, en lugar de abrir una nueva actividad se carga el webview en un fragmento en
la propia actividad principal.

Demuestra:
* fragmentos, fragmentManager, reutilización de un fragmento.
* Orientación del dispositivo.

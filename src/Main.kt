

/*

---> Activity <---

onCreate: Se ejecuta cuando se crea una Activity por primera vez.
onStart: Se ejecuta después del onCreate cuando se crea por primera vez o cuando una Activity ha sido sacada de memoria y quiere volverse a mostrar.
onResume: Se ejecuta después del onStart o cuando una Activity que estaba en segundo plano vuelve a estar en primer plano.
onPause: Se ejecuta cuando el usuario manda una Activity al segundo plano.
onStop: Se ejecuta cuando la Activity deja de ser visible.
onDestroy: Se ejecuta cuando el usuario elimina la Activity del segundo plano o Android requiere memoria. No siempre se ejecuta


onSaveInstanceState I
Cuando una activity va a destruirse con perspectivas de se recreada, entonces se llama a método onSaveInstanceState(outState: Bundle)
En outState es posible guardar valores.
outState.putString(TAG_USER_TEXT, etText.text.toString())
Siendo TAG_USER_TEXT un String.




onSaveInstanceState II
Cuando se vuelva a ejecutar el método onCreate(savedInstanceState: Bundle?) se recibirán los valores guardados en el outState dentro de savedInstanceState.
Para recuperar los valores guardados anteriormente, utilizamos el siguiente código.
savedInstanceState?.run {
   getString(TAG_USER_TEXT)?.let {
       etText.setText(it)
   }
}



sharedPreferences I
La forma más sencilla de almacenar datos en forma persistente es utilizando la API sharedPreferences. Se puede acceder a ella a través de un Context y permite almacenar duplas de clave valor (similar a lo que se ha realizado en onSaveInstanceState).
Para acceder a las sharedPreferences se debe ejecutar el siguiente código:
val sharedPref = getPreferences(Context.MODE_PRIVATE)




sharedPreferences II
Para guardar un valor en las las sharedPreferences debes:
with (sharedPref.edit()) {
   putString(TAG_USUARIO, string)
   commit() }
Para cargar un valor:
return sharedPref.getString(TAG_USUARIO, "")



Toast
Una forma sencilla de dar feedback al usuario es mediante los Toast.
Un toast es una ventana emergente de corta duración capaz de mostrar textos.
Toast.makeText(this, "Escribe algo primero", Toast.LENGTH_LONG).show()


 */
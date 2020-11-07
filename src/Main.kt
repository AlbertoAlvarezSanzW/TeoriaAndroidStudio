

/*

---> Activity <---

onCreate: Se ejecuta cuando se crea una Activity por primera vez.
onStart: Se ejecuta después del onCreate cuando se crea por primera vez o cuando una Activity ha sido sacada de memoria y quiere volverse a mostrar.
onResume: Se ejecuta después del onStart o cuando una Activity que estaba en segundo plano vuelve a estar en primer plano.
onPause: Se ejecuta cuando el usuario manda una Activity al segundo plano.
onStop: Se ejecuta cuando la Activity deja de ser visible.
onDestroy: Se ejecuta cuando el usuario elimina la Activity del segundo plano o Android requiere memoria. No siempre se ejecuta


-->onSaveInstanceState I
Cuando una activity va a destruirse con perspectivas de se recreada, entonces se llama a método onSaveInstanceState(outState: Bundle)
En outState es posible guardar valores.
outState.putString(TAG_USER_TEXT, etText.text.toString())
Siendo TAG_USER_TEXT un String.




-->onSaveInstanceState II
Cuando se vuelva a ejecutar el método onCreate(savedInstanceState: Bundle?) se recibirán los valores guardados en el outState dentro de savedInstanceState.
Para recuperar los valores guardados anteriormente, utilizamos el siguiente código.
savedInstanceState?.run {
   getString(TAG_USER_TEXT)?.let {
       etText.setText(it)
   }
}



-->sharedPreferences I
La forma más sencilla de almacenar datos en forma persistente es utilizando la API sharedPreferences. Se puede acceder a ella a través de un Context y permite almacenar duplas de clave valor (similar a lo que se ha realizado en onSaveInstanceState).
Para acceder a las sharedPreferences se debe ejecutar el siguiente código:
val sharedPref = getPreferences(Context.MODE_PRIVATE)




-->sharedPreferences II
Para guardar un valor en las las sharedPreferences debes:
with (sharedPref.edit()) {
   putString(TAG_USUARIO, string)
   commit() }
Para cargar un valor:
return sharedPref.getString(TAG_USUARIO, "")



-->Toast
Una forma sencilla de dar feedback al usuario es mediante los Toast.
Un toast es una ventana emergente de corta duración capaz de mostrar textos.
Toast.makeText(this, "Escribe algo primero", Toast.LENGTH_LONG).show()



-->Accediendo/Modificando los atributos de una vista
Es posible acceder al contenido de una vista utilizando los respectivos métodos disponibles.
Estos métodos dependen del tipo de la vista. Por ejemplo,
twContent.text = etContent.text
siendo
twContent un TextView y etContent un EditText



-->Listeners
Un listener es una función que se queda en espera hasta que cierto evento ocurre, momento en el que se ejecuta. Ejemplos:
bConvert.setOnClickListener {...}
twContent.setOnLongClickListener {...}
etContent.addTextChangedListener( object : TextWatcher {
   override fun afterTextChanged(s: Editable?) {...}
   override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
   override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {} })


EJEMPLO
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addListenerToButton()
        addListenerToEditText()
        addListenerToTextView()
    }

    private fun addListenerToTextView() {
        twContent.setOnLongClickListener {
            Toast.makeText(this, "Transformando texto a mayusculas", Toast.LENGTH_LONG).show()
            etContent.setText(etContent.text.toString().toUpperCase(Locale.getDefault()))
            true
        }
    }

    private fun addListenerToButton() {
        bConvert.setOnClickListener {
            if(twContent.text.isEmpty())
                Toast.makeText(this, "Escribe algo primero", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Hay ${twContent.text.length} caracteres escritos", Toast.LENGTH_LONG).show()
        }
    }


    private fun addListenerToEditText() {
        etContent.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                twContent.text = etContent.text
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })

    }

-->Clases en Android
   Un proyecto Android puede contener tantas Clases como se desee.
   La forma de crear nuevas clases y utilizarlas es similar a cualquier otro proyecto en Kotlin.







 */
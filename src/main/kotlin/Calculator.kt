import kotlin.IllegalArgumentException

data class Calculator (val context: String){
    init {
        if (context.isNullOrBlank()) throw IllegalArgumentException("")
        context.split(" ")
    }


}
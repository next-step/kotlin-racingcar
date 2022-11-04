import java.lang.IllegalArgumentException

class Calculator {
    fun main(arg : String) {
        if (arg.isNullOrBlank()) throw IllegalArgumentException("") // todo
    }
}
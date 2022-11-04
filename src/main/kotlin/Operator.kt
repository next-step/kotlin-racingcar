import java.lang.IllegalArgumentException

enum class Operator (val value: String){
    ADD("+"),
    MINUS("-"),
    TIMES("*"),
    DIV("/");

    companion object {
        fun of(s: String) : Operator {
            values().forEach {
                if (it.value == s) return it
            }
            throw IllegalArgumentException("")
        }
    }
}
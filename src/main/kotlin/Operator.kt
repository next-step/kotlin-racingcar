import java.lang.IllegalArgumentException

enum class Operator (val value: String){
    add("+"),
    minus("-"),
    times("*"),
    div("/"),
    none("");

    companion object {
        fun of(s: String) : Operator {
            values().forEach {
                if (it.value == s) return it
            }
            throw IllegalArgumentException("")
        }
    }
}
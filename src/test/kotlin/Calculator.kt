import org.assertj.core.data.Index


enum class Operate(val row: String) {
    SUM("+") {
        fun cal(a: Int, b: Int) = a + b
    },
    SUB("-") {
        fun cal(a: Int, b: Int) = a - b
    },
    MUL("*") {
        fun cal(a: Int, b: Int) = a * b
    },
    DIV("/") {
        fun cal(a: Int, b: Int): Int{
            if  (b == 0) throw ArithmeticException("0으로 나누면 값이 무한이 됩니다.")
            return a / b
        }
    }
}


class Calculator() {

    fun OperateSymbol(input: String?) {
        if (input.isNullOrBlank())
            throw IllegalArgumentException("공백이나 null값은 혀용이 되지 않습니다.")
    }
}


fun main() {
    val s : String = "2 + 3 * 4 / 2"




        }

    }


    val cal = Calculator()

}
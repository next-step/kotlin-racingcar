package step2

interface Stoi {
    fun StringtoInt(rows: String): List<String>
}

interface Result {
    fun cal(a: Int, b: Int): Int
}

enum class Operate(val sym: String) : Result{
    SUM("+") {
        override fun cal(a: Int, b: Int) = a + b
    },
    SUB("-") {
        override fun cal(a: Int, b: Int) = a - b
    },
    MUL("*") {
        override fun cal(a: Int, b: Int) = a * b
    },
    DIV("/") {
        override fun cal(a: Int, b: Int): Int {
            if (b == 0) throw ArithmeticException("0으로 나누면 값이 무한이 됩니다.")
            return a / b
        }
    }
}

class CalculatorforString(elements: String) {
    var element = elements.trim().split(" ")
    fun OperateSymbol (element :List<String>) {
        for (x: Int in 0 until element.size) {
            if ((element[x] == " ") or (element[x] == null)) throw IllegalArgumentException("공백이나 null값은 혀용이 되지 않습니다.")

            // fun calc (sym: String,number:Int,number2:Int){
                // return Operate.valueOf()
        }
    }
    }
}

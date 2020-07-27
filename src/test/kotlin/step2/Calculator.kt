package step2

// import jdk.internal.joptsimple.internal.Rows

interface Result {
    fun cal(a: Int, b: Int): Int
}

enum class Operate(val sym: String) : Result {
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
    };

    companion object {
        fun run(sym: String): Operate {
            return enumValues<Operate>().first {
                it.sym == sym
            }
        }
    }
}

object CalculatorforString {
    fun seperate(element: List<String>): Int {
        var result = element[0].toInt()
        for (x: Int in 0 until element.size) {
            if ((element[x] == " ") or (element[x] == null)) throw IllegalArgumentException("공백이나 null값은 혀용이 되지 않습니다.")
        }
        for (i in 1 until element.size step 2) {
            result = Operate.run(element[i]).cal(result.toInt(), element[i + 1].toInt()).toInt()
        }
        return result
    }
}

class StringtoList {
    fun stoL(rows: String): List<String> {
        return rows.trim().split(" ")
    }
}

fun main() {
    val input = StringtoList().stoL("2 + 3 * 4 / 2 ")
    val result = CalculatorforString.seperate(input)
    println(result)
}

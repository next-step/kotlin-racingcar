package step2

fun main() {
    Calculator().calculate()
}

class Calculator {

    fun calculate() {
        val readln = readln()
        require(!readln.isEmpty())

        val split = readln.split(" ")
        var operand: Long? = null
        var operator: String? = null
        split.forEach {
            when (it) {
                "+", "-", "*", "/" -> operator = it
                else -> {
                    if (operand == null) {
                        operand = it.toLong()
                    } else {
                        when (operator) {
                            "+" -> operand = plus(operand!!, it.toLong())
                            "-" -> operand = minus(operand!!, it.toLong())
                            "*" -> operand = mutiply(operand!!, it.toLong())
                            "/" -> operand = divide(operand!!, it.toLong())
                        }
                    }
                }
            }
        }
        println(operand)
    }

    fun plus(a: Long, b: Long): Long {
        return a + b
    }

    fun minus(a: Long, b: Long): Long {
        return a - b
    }

    fun mutiply(a: Long, b: Long): Long {
        return a * b
    }

    fun divide(a: Long, b: Long): Long {
        return a / b
    }
}

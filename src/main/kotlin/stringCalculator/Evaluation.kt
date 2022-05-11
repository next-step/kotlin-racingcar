package stringCalculator

class Operator {

    fun evaluate(number: Int, operator: String, result: Int): Int {
        return if (operator == "+") {
            add(result, number)
        } else if (operator == "-") {
            substrate(result, number)
        } else if (operator == "*") {
            multiple(result, number)
        } else {
            divide(result, number)
        }
    }

    fun add(a: Int, b: Int): Int = a + b

    fun substrate(a: Int, b: Int): Int = a - b

    fun multiple(a: Int, b: Int): Int = a * b

    fun divide(a: Int, b: Int): Int = a / b
}


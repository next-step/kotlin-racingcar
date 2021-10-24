package StringCalculator

class Calculator {
    fun calculate(input : String?) : Int {
        checkIsValidExpression(input)

        throw NotImplementedError(Exception().stackTrace[0].methodName)
    }

    private fun checkIsValidExpression(input: String?) {
        if (input == null) throw IllegalArgumentException()
        if (input.isBlank()) throw IllegalArgumentException()
        // 공백으로 문자열 분할
        val list = input.split(" ").toMutableList()
        // 빈 문자열 제거
        list.removeIf { element -> element.isEmpty()}
        // 연산과 수식의 합은 홀수여야 한다.
        if (list.size % 2 == 0) throw IllegalArgumentException()
        // 수식은 숫자와 연산자가 번갈아 와야 한다.
        var mustBeNumber = false
        list.forEach { parameter ->
            mustBeNumber = !mustBeNumber
            if (mustBeNumber && parameter.toIntOrNull() != null) return@forEach
            if (!mustBeNumber && isValidOperator(parameter)) return@forEach
            throw IllegalArgumentException()
        }
    }

    private fun isValidOperator(operation: String?) : Boolean {
        if (operation == "+") return true
        if (operation == "-") return true
        if (operation == "*") return true
        if (operation == "/") return true
        return false
    }

    fun add(a: Int, b: Int) :Int = a + b

    fun subtract(a: Int, b: Int) = a - b

    fun multiply(a: Int, b: Int) = a * b

    fun divide(a: Int, b: Int) = a / b
}
class Calculator() {
    fun calculate(expression: String?): Int {
        nullOrEmptyCheck(expression)

        val arr_experssion: Array<String> =
            expression?.split(" ".toRegex())?.dropLastWhile { it.isEmpty() }?.toTypedArray() as Array<String>
        val operando1 = arr_experssion[0].toInt()

        val result = operatorCheck(operando1, arr_experssion)

        return result
    }

    fun operatorCheck(operando1: Int, arr_fomula: Array<String>): Int {
        var i = 0

        var result = operando1

        while (i < arr_fomula.size) {
            if (finishOperandoCheck(i, arr_fomula.size - 1)) {
                when (arr_fomula[i + 1]) {
                    "+" ->
                        result = sum(result, arr_fomula[i + 2].toInt())

                    "-" ->
                        result = minus(result, arr_fomula[i + 2].toInt())

                    "*" ->
                        result = multiply(result, arr_fomula[i + 2].toInt())

                    "/" ->
                        result = divide(result, arr_fomula[i + 2].toInt())

                    else ->
                        iaeException()
                }
            }
            i += 2
        }

        return result
    }

    fun finishOperandoCheck(currentIndex: Int, finishIndex: Int): Boolean {
        return currentIndex != finishIndex
    }

    fun iaeException() {
        throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
    }

    fun nullOrEmptyCheck(expression: String?) {
        if (expression == null || (expression == "")) {
            throw IllegalArgumentException("계산식이 NULL 혹은 공백입니다.")
        }
    }

    fun sum(operando1: Int, operando2: Int): Int {
        return operando1 + operando2
    }

    fun minus(operando1: Int, operando2: Int): Int {
        return operando1 - operando2
    }

    fun multiply(operando1: Int, operando2: Int): Int {
        return operando1 * operando2
    }

    fun divide(operando1: Int, operando2: Int): Int {
        return operando1 / operando2
    }
}

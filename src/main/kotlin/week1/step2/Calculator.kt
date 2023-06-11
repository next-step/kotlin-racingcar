package week1.step2

class Calculator {

    val operatorArray: Array<String> = arrayOf("+", "-", "*", "/")

    inline fun <reified T : Number> convertStringToNumber(input: String): T {
        return when (T::class) {
            Int::class -> input.toInt() as T
            Double::class -> input.toDouble() as T
            else -> throw IllegalArgumentException("지원하지 않는 숫자 형식입니다.")
        }
    }

    inline fun <reified T : Number> calculate(input: String): T {
        if (input == "") {
            throw IllegalArgumentException("유효한 형식이 아닙니다.")
        }

        val inputArray = input.split(" ")
        val numberQueue = ArrayList<T>()
        val operatorQueue = ArrayList<String>()

        inputArray.forEachIndexed { index, value ->
            if (index % 2 == 0) {
                try {
                    numberQueue.add(convertStringToNumber(value))
                } catch (e: IllegalArgumentException) {
                    throw IllegalArgumentException("유효한 형식이 아닙니다.")
                }
            } else {
                if (value in operatorArray) {
                    operatorQueue.add(value)
                } else {
                    throw IllegalArgumentException("유효한 형식이 아닙니다.")
                }
            }
        }
        return execute(numberQueue, operatorQueue)
    }

    fun <T : Number> plus(num1: T, num2: T): T {
        return when (num1) {
            is Int -> (num1.toInt() + num2.toInt()) as T
            is Double -> (num1.toDouble() + num2.toDouble()) as T
            else -> throw IllegalArgumentException("지원하지 않는 숫자 형식입니다.")
        }
    }

    fun <T : Number> minus(num1: T, num2: T): T {
        return when (num1) {
            is Int -> (num1.toInt() - num2.toInt()) as T
            is Double -> (num1.toDouble() - num2.toDouble()) as T
            else -> throw IllegalArgumentException("지원하지 않는 숫자 형식입니다.")
        }
    }

    fun <T : Number> multiply(num1: T, num2: T): T {
        return when (num1) {
            is Int -> (num1.toInt() * num2.toInt()) as T
            is Double -> (num1.toDouble() * num2.toDouble()) as T
            else -> throw IllegalArgumentException("지원하지 않는 숫자 형식입니다.")
        }
    }

    fun <T : Number> divide(num1: T, num2: T): T {
        return when (num1) {
            is Int -> (num1.toInt() / num2.toInt()) as T
            is Double -> (num1.toDouble() / num2.toDouble()) as T
            else -> throw IllegalArgumentException("지원하지 않는 숫자 형식입니다.")
        }
    }

    fun <T : Number> execute(numArr: ArrayList<T>, opArr: ArrayList<String>): T {
        var result = numArr[0]
        var opArrayIdx = 0

        for (i in 1..numArr.lastIndex) {
            val num1 = result
            val num2 = numArr[i]

            when (opArr[opArrayIdx]) {
                "+" -> result = plus(num1, num2)
                "-" -> result = minus(num1, num2)
                "*" -> result = multiply(num1, num2)
                "/" -> result = divide(num1, num2)
            }
            opArrayIdx += 1
        }
        return result
    }
}

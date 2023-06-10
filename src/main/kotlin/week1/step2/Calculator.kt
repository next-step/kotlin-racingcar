package week1.step2

class Calculator {

    private val operatorArray: Array<String> = arrayOf("+", "-", "*", "/")
    fun calculate(input: String): Float {
        if (input == "") {
            throw IllegalArgumentException()
        }

        val inputArray = input.split(" ")
        val numberQueue = ArrayList<Float>()
        val operatorQueue = ArrayList<String>()

        inputArray.forEachIndexed { index, value ->
            if (index % 2 == 0) {
                try {
                    numberQueue.add(value.toFloat())
                } catch (e: IllegalArgumentException) {
                    println("유효한 숫자 형식이 아닙니다.")
                }
            } else {
                if (value in operatorArray) {
                    operatorQueue.add(value)
                } else {
                    println("유효한 연산자 형식이 아닙니다.")
                    throw IllegalArgumentException()
                }
            }
        }
        return execute(numberQueue, operatorQueue)
    }

    fun plus(num1: Float, num2: Float): Float {
        return num1 + num2
    }

    fun minus(num1: Float, num2: Float): Float {
        return num1 - num2
    }

    fun multiply(num1: Float, num2: Float): Float {
        return num1 * num2
    }

    fun divide(num1: Float, num2: Float): Float {
        return (num1 / num2)
    }

    fun execute(numArr: ArrayList<Float>, opArr: ArrayList<String>): Float {
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

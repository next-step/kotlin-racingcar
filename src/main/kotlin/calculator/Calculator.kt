package calculator

class Calculator(
    val inputData: String
) {
    private var result = 0
    private val numberList: MutableList<Int> = mutableListOf()
    private val signList: MutableList<String> = mutableListOf()

    private fun checkInputDataIsNullOrBlank(inputData: String): Boolean {
        return inputData.isNullOrBlank()
    }

    private fun checkIsNotSign(sign: String): Boolean {
        if (sign == "+" || sign == "-" || sign == "*" || sign == "/")
            return true
        else
            return false
    }
    private fun splitNumberAndSign(inputData: String) {
        val splitData = inputData.split(" ")

        splitData.forEach {
            try {
                numberList.add(it.toInt())
            } catch (e: Exception) {
                signList.add(it)
            }
        }
    }

    fun calculate(): Int {
        if (checkInputDataIsNullOrBlank(inputData))
            throw IllegalArgumentException("입력값이 null 이거나 공백 입니다.")

        splitNumberAndSign(inputData)

        for (i in 0 until numberList.size) {
            if (i == 0) {
                result = numberList.get(i)
                continue
            }
            result = checkSignAndCalculate(signList.get(i - 1), result, numberList.get(i))
        }
        return result
    }

    private fun checkSignAndCalculate(sign: String, number1: Int, number2: Int): Int {
        if (!checkIsNotSign(sign))
            throw IllegalArgumentException("사칙연산의 기호가 아닙니다.")

        return if (sign.equals("+")) {
            sum(number1, number2)
        } else if (sign.equals("-")) {
            substract(number1, number2)
        } else if (sign.equals("*")) {
            multiply(number1, number2)
        } else {
            divide(number1, number2)
        }
    }

    private fun sum(number1: Int, number2: Int): Int {
        return number1 + number2
    }

    private fun substract(number1: Int, number2: Int): Int {
        return number1 - number2
    }

    private fun multiply(number1: Int, number2: Int): Int {
        return number1 * number2
    }

    private fun divide(number1: Int, number2: Int): Int {
        return number1 / number2
    }
}

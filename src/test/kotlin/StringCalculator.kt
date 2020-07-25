import java.lang.ArithmeticException

enum class Operator(val sign: String) {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/")
}

private const val REMAINDER_ZERO = 0
private const val REMAINDER_ONE = 1

class StringCalculator {
    private var result: Int = 0

    fun calculate(inputStr: String?): Int {
        isCorrectInput(inputStr)

        val strList = inputStr!!.trim().split(" ")

        val numbers = ArrayList<Int>()
        val operators = ArrayList<String>()

        separateNumsAndOperators(strList, numbers, operators)

        calculateInOrder(operators, numbers)

        return result
    }

    private fun isCorrectInput(inputStr: String?) {
        if (inputStr.isNullOrEmpty() or (inputStr == " ")) throw IllegalArgumentException("값을 입력해주세요.")
    }

    private fun separateNumsAndOperators(strList: List<String>, numbers: ArrayList<Int>, operators: ArrayList<String>) {
        for (i in strList.indices) {
            if (i % 2 == REMAINDER_ZERO) numbers.add(strList.get(i).toInt())
            if (i % 2 == REMAINDER_ONE) operators.add(strList.get(i))
        }
    }

    private fun calculateInOrder(operators: ArrayList<String>, numbers: ArrayList<Int>) {
        result = numbers.removeAt(0)
        if (numbers.isEmpty()) return
        for (i in operators.indices) {
            when (operators.removeAt(0)) {
                Operator.PLUS.sign -> plus(numbers.removeAt(0))
                Operator.MINUS.sign -> minus(numbers.removeAt(0))
                Operator.MULTIPLY.sign -> multiply(numbers.removeAt(0))
                Operator.DIVIDE.sign -> divide(numbers.removeAt(0))
                else -> throw IllegalArgumentException("올바르지 않은 연산자가 있습니다.")
            }
        }
    }

    private fun plus(num: Int) {
        result += num
    }

    private fun minus(num: Int) {
        result -= num
    }

    private fun multiply(num: Int) {
        result *= num
    }

    private fun divide(num: Int) {
        if (num == 0) throw ArithmeticException("0으로 나눌 수 없습니다.")
        result /= num
    }
}

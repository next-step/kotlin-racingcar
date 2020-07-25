import java.lang.ArithmeticException

enum class Operator(val sign: String) {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/")
}

private const val REMAINDER_ZERO = 0
private const val REMAINDER_ONE = 1

class StringCalculator {

    companion object {
        private var result: Int = 0
    }

    fun calculate(input: String?): Int {
        isCorrectInputFormat(input)

        val inputSplit = input!!.trim().split(" ")

        val numbers = ArrayList<Int>()
        val operators = ArrayList<String>()

        separateNumsAndOperators(inputSplit, numbers, operators)

        calculateInOrder(operators, numbers)

        return result
    }

    private fun isCorrectInputFormat(inputStr: String?) {
        if (inputStr.isNullOrEmpty() or (inputStr == " ")) throw IllegalArgumentException("값을 입력해주세요.")
    }

    // TODO.05 람다식 사용해보기 (람다식을 인자로 list의 원소를 filtering해보기)
    private fun separateNumsAndOperators(inputSplit: List<String>, numbers: ArrayList<Int>, operators: ArrayList<String>) {
        for (i in inputSplit.indices) {
            if (i % 2 == REMAINDER_ZERO) numbers.add(inputSplit[i].toInt())
            if (i % 2 == REMAINDER_ONE) operators.add(inputSplit[i])
        }
    }

    private fun calculateInOrder(operators: ArrayList<String>, numbers: ArrayList<Int>) {
        result = numbers.removeAt(0)
        if (numbers.isEmpty()) return
        // TODO.03 switch/case 구문을 피하고 Map 또는 람다 활용하기
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

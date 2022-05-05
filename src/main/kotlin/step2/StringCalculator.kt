package step2

/**
 * 문자열 사칙 연산 계산기
 * Created by Jaesungchi on 2022.05.05..
 */

fun main() {
    val calculator = StringCalculator()
    val input = readlnOrNull()
    val output = calculator.startCalculate(input)
    println(output)
}

class StringCalculator {
    /**
     * 문자열을 받고 계산을 시작하여 계산한값을 돌려준다.
     */
    fun startCalculate(input: String?): String {
        if (input.isNullOrBlank()) throw IllegalArgumentException("Input is Null or Blank.")

        val inputList = splitStringBySpace(input)
        inputList.forEachIndexed { index, text ->
            // 짝수 index에는 숫자, 홀수 index에는 연산자가 온다.
            if (index % 2 == 0) {
                checkEnabledNumber(text)
                //TODO 첫 숫자면 저장하고, 이후에는 계산한다.
            } else {
                checkEnabledOperator(text)
                //TODO 연산자는 저장한다.
            }
        }

        return input
    }

    /**
     * 문자열을 스페이스로 나눠 List로 돌려주는 메소드.
     */
    private fun splitStringBySpace(input: String): List<String> {
        return input.split(" ")
    }

    /**
     * 계산가능한 연산자인지 확인하는 메소드.
     */
    private fun checkEnabledOperator(input: String) {
        when (input) {
            "+", "-", "/", "*" -> return
            else -> throw IllegalArgumentException("There is a non-operator character in the operator position.")
        }
    }

    /**
     * 계산가능한 숫자인지 확인하는 메소드.
     */
    private fun checkEnabledNumber(input: String) {
        if (input.toIntOrNull() == null)
            throw IllegalArgumentException("There is a non-digit character in the digit position.")
    }
}
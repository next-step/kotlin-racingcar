package calculator

import java.lang.IllegalArgumentException

class StringCalculator {
    fun calculate(typeSymbol: String, firstSource: Int, secondSource: Int): Int {
        if (isNotValidTypeSymbol(typeSymbol)) {
            throw IllegalArgumentException("입력 불가능한 문자열 입니다.")
        }

        return CalculateType.find(typeSymbol).calc(firstSource, secondSource)
    }

    fun isNotValidTypeSymbol(typeSymbol: String): Boolean =
        typeSymbol.isEmpty() || typeSymbol.isBlank()
}

fun main() {
    val calculator = StringCalculator()

    val input = readLine()

    val inputElement = input?.split(" ") ?: throw IllegalArgumentException("잘못된 입력 값 입니다.")

    var result = inputElement[0].toInt()

    for (x in 1 until inputElement.size step 2) {
        result = calculator.calculate(inputElement[x], result, inputElement[x + 1].toInt())
    }

    print(result)
}

package calculator

import java.lang.IllegalArgumentException

enum class CalculateType(
    private val typeSymbol: String,
    val calc: (firstSource: Int, secondSource: Int) -> Int
) {
    ADD("+", { firstSource: Int, secondSource: Int -> firstSource + secondSource }),
    MINUS("-", { firstSource: Int, secondSource: Int -> firstSource - secondSource }),
    DIVIDE("/", { firstSource: Int, secondSource: Int ->
        if (secondSource == 0) {
            throw IllegalArgumentException("0으로 나눌수 없습니다.")
        }
        firstSource / secondSource
    }),
    MULTIPLY("*", { firstSource: Int, secondSource: Int -> firstSource * secondSource });

    companion object {
        fun find(typeSymbol: String): CalculateType {
            return values().find { typeSymbol == it.typeSymbol }
                ?: throw IllegalArgumentException("잘못된 계산 문자열 입니다. symbol :$typeSymbol")
        }
    }
}

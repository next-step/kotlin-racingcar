package com.nextstep.jngcii.step2

/**
 * 피연산자 ㅋㅋ
 */
class POperator(
    input: String,
    val isEnd: Boolean = false,
) {
    val value: Int

    init {
        try {
            value = input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자형만 계산 가능합니다.")
        }
    }
}

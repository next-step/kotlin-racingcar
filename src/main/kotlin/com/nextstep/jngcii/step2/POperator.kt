package com.nextstep.jngcii.step2

/**
 * 피연산자 ㅋㅋ
 */
class POperator(
    val value: Int,
    val isEnd: Boolean = false,
) {
    constructor(input: String, isEnd: Boolean = false) : this(
        value = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자형만 계산 가능합니다.")
        },
        isEnd = isEnd
    )
}

package com.nextstep.jngcii.step2

import java.math.BigDecimal

class Operand(
    val value: BigDecimal,
    val isEnd: Boolean = false,
) {
    constructor(input: String, isEnd: Boolean = false) : this(
        value = try {
            val doubleValue = input.toDouble()
            BigDecimal(doubleValue)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자형만 계산 가능합니다.")
        },
        isEnd = isEnd
    )
}

package com.nextstep.jngcii.step2

import com.nextstep.jngcii.step2.vo.Number
import com.nextstep.jngcii.step2.vo.Operator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputTest {
    @Test
    fun `Input 생성 성공 테스트`() {
        val numbers = listOf(
            Number("1"),
            Number("2"),
            Number("3"),
            Number("4")
        )
        val operators = listOf(
            Operator.MINUS,
            Operator.PLUS,
            Operator.DIVIDE
        )

        assertDoesNotThrow { Input(numbers, operators) }
    }

    @Test
    fun `Input 생성 실패 테스트`() {
        val numbers = listOf(
            Number("1"),
            Number("2"),
            Number("3")
        )
        val operators = listOf(
            Operator.MINUS,
            Operator.PLUS,
            Operator.DIVIDE
        )

        assertThrows<IllegalArgumentException>("잘못된 계산식입니다.") { Input(numbers, operators) }
    }
}

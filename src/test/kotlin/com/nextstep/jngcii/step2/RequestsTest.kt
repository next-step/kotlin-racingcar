package com.nextstep.jngcii.step2

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class RequestsTest {
    @Test
    fun `Input 생성 성공 테스트`() {
        val numbers = listOf(
            Operand("1"),
            Operand("2"),
            Operand("3"),
            Operand("4")
        )
        val operators = listOf(
            Operator.MINUS,
            Operator.PLUS,
            Operator.DIVIDE
        )

        assertDoesNotThrow { Requests(numbers, operators) }
    }

    @Test
    fun `Input 생성 실패 테스트`() {
        val numbers = listOf(
            Operand("1"),
            Operand("2"),
            Operand("3")
        )
        val operators = listOf(
            Operator.MINUS,
            Operator.PLUS,
            Operator.DIVIDE
        )

        assertThrows<IllegalArgumentException>("잘못된 계산식입니다.") { Requests(numbers, operators) }
    }
}

package com.nextstep.jngcii.step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ComputerTest {

    // 연산자 상관없이 무조건 더하기만 해대는 친구
    private val mockCalculator = object : Calculator {
        override fun run(lhs: POperator, rhs: POperator, op: Operator) = POperator(
            value = lhs.value + rhs.value,
            isEnd = lhs.isEnd || rhs.isEnd
        )
    }
    private val computer = Computer(mockCalculator)

    @Test
    fun computeTest() {
        val numbers = listOf(
            POperator(1),
            POperator(2),
            POperator(3),
            POperator(4),
            POperator(5, true),
        )
        val operators = listOf(
            Operator.PLUS,
            Operator.MINUS,
            Operator.MULTIPLY,
            Operator.DIVIDE
        )
        val requests = Requests(numbers, operators)

        assertEquals(15, computer.compute(requests))
    }
}

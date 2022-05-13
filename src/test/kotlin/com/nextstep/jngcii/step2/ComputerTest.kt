package com.nextstep.jngcii.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ComputerTest {

    private val justPlusCalculator = object : Calculator {
        override fun run(left: Operand, right: Operand, operator: Operator) = Operand(
            value = left.value + right.value,
            isEnd = left.isEnd || right.isEnd
        )
    }
    private val computer = Computer(justPlusCalculator)

    @Test
    fun `일반적인 상황에 대한 단순 계산 테스트`() {
        val numbers = listOf(
            Operand("1"),
            Operand("2"),
            Operand("3"),
            Operand("4"),
            Operand("5", isEnd = true),
        )
        val operators = listOf(
            Operator.PLUS,
            Operator.MINUS,
            Operator.MULTIPLY,
            Operator.DIVIDE
        )
        val requests = Requests(numbers, operators)

        val actual = computer.compute(requests)
        val expect = 15.0
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun `isEnd=true Operand가 없을 경우 끝까지 계산 테스트`() {
        val numbers = listOf(
            Operand("1"),
            Operand("2"),
            Operand("3"),
            Operand("4"),
            Operand("5"),
        )
        val operators = listOf(
            Operator.PLUS,
            Operator.MINUS,
            Operator.MULTIPLY,
            Operator.DIVIDE
        )
        val requests = Requests(numbers, operators)

        val actual = computer.compute(requests)
        val expect = 15.0
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun `isEnd=true Operand까지 계산 테스트`() {
        val numbers = listOf(
            Operand("1"),
            Operand("2", isEnd = true),
            Operand("3"),
            Operand("4"),
            Operand("5"),
        )
        val operators = listOf(
            Operator.PLUS,
            Operator.MINUS,
            Operator.MULTIPLY,
            Operator.DIVIDE
        )
        val requests = Requests(numbers, operators)

        val actual = computer.compute(requests)
        val expect = 3.0
        assertThat(actual).isEqualTo(expect)
    }
}

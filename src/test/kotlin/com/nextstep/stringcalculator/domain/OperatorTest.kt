package com.nextstep.stringcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorTest {
    @Test
    fun `+에 해당하는 operator를 가져온다`() {
        assertThat(Operator.valueOfOperator("+")).isEqualTo(Operator.ADD)
    }

    @Test
    fun `-에 해당하는 operator를 가져온다`() {
        assertThat(Operator.valueOfOperator("-")).isEqualTo(Operator.SUBTRACT)
    }

    @Test
    fun `*에 해당하는 operator를 가져온다`() {
        assertThat(Operator.valueOfOperator("*")).isEqualTo(Operator.MULTIPLY)
    }

    @Test
    fun `나누기에 해당하는 operator를 가져온다`() {
        assertThat(Operator.valueOfOperator("/")).isEqualTo(Operator.DIVISION)
    }
}

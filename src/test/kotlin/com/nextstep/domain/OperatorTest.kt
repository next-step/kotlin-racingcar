package com.nextstep.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorTest {
    @Test
    fun `operator 값에 따라 enum값을 가져온다`() {
        assertThat(Operator.valueOfOperator("+")).isEqualTo(Operator.ADD)
        assertThat(Operator.valueOfOperator("-")).isEqualTo(Operator.SUBTRACT)
        assertThat(Operator.valueOfOperator("*")).isEqualTo(Operator.MULTIPLY)
        assertThat(Operator.valueOfOperator("/")).isEqualTo(Operator.DIVISION)
    }
}

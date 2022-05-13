package com.nextstep.jngcii.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {
    @ParameterizedTest
    @CsvSource(
        "PLUS,+",
        "MINUS,-",
        "MULTIPLY,*",
        "DIVIDE,/"
    )
    fun `operator 생성 성공 테스트`(name: String, input: String) {
        val actual = Operator.of(input).name
        val expect = Operator.valueOf(name).name
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "a", "1"])
    fun `operator 생성 실패 테스트`(input: String) {
        assertThrows<IllegalArgumentException>("연산자는 '+, -, *, /'만 입력 가능합니다.") { Operator.of(input) }
    }
}

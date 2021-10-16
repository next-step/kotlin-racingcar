package step2

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["1","2"])
    fun `어노테이션을_테스트_한다`(str: String) {
        assertTrue(str.isNotBlank())
    }

    @Test
    fun `덧셈을 테스트 한다`() {

    }

    @Test
    fun `뺄셈을 테스트 한다`() {

    }

    @Test
    fun `곱셈을 테스트 한다`() {

    }

    @Test
    fun `나눗셈을 테스트 한다`() {

    }

    @Test
    fun `입력값이 null이거나 빈 공백을 테스트 한다`() {

    }

    @Test
    fun `사칙연산 기호가 아닌 경우를 테스트 한다`() {

    }

    @Test
    fun `계산기의 모든 기능을 테스트 한다`() {

    }

}

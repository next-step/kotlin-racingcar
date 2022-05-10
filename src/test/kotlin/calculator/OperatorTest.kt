package calculator

import io.kotest.matchers.nulls.shouldNotBeNull
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {

    @ParameterizedTest(name = " {0} 사칙 연산 기호로 Enum 을 찾을수 있다.")
    @ValueSource(strings = ["+", "-", "/", "*"])
    fun `사칙연산자 기호로  Enum 값을 찾을수 있다`(operatorString: String) {
        // when
        val value = Operator.stringOf(operatorString)

        // then
        assertThat(value).shouldNotBeNull()
    }

    @Test
    fun `사칙연산 기호가 아닌 값을 넣으면 IllegalArgumentException 에러가 발생한다`() {
        // given
        val illegalArguments = "`"

        // then
        assertThatThrownBy {
            Operator.stringOf(illegalArguments)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage(Operator.ERROR_MESSAGE_BY_OPERARTOR_STRING)
    }
}
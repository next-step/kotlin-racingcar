package calculator.application

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EngineTest {

    private val engine: Engine = Engine(Tokenizer(), Converter())

    @Test
    fun `더하기 연산`() {
        //given
        val input = "1 + 2"

        //when
        val actual: String = engine.compute(input)

        //then
        assertThat(actual).isNotNull
        assertThat(actual).isNotEmpty
        assertThat(actual).isEqualTo("3")
    }

    @Test
    fun `빼기 연산`() {
        //given
        val input = "1 - 2"

        //when
        val actual: String = engine.compute(input)

        //then
        assertThat(actual).isNotNull
        assertThat(actual).isNotEmpty
        assertThat(actual).isEqualTo("-1")
    }

    @Test
    fun `곱하기 연산`() {
        //given
        val input = "1 * 2"

        //when
        val actual: String = engine.compute(input)

        //then
        assertThat(actual).isEqualTo("2")
    }

    @Test
    fun `나누기 연산`() {
        //given
        val input: String = "4 / 2"

        //when
        val actual: String = engine.compute(input)

        //then
        assertThat(actual).isNotNull
        assertThat(actual).isNotEmpty
        assertThat(actual).isEqualTo("2")
    }

    @Test
    fun `0으로 나누는 경우`() {
        //given
        val input = "4 / 0"

        //then
        Assertions.assertThatThrownBy { engine.compute(input) }.isInstanceOf(ArithmeticException::class.java)
    }

    @Test
    fun `복잡한 연산`() {
        //given
        val input = "1 + 4 - 10"

        //when
        val actual: String = engine.compute(input)

        //then
        assertThat(actual).isNotNull
        assertThat(actual).isNotEmpty
        assertThat(actual).isEqualTo("-5")
    }
}

package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputConverterTest {

    @Test
    fun `수식에 포함된 숫자들의 리스트를 반환합니다`() {
        val intDeque = InputConverter().extractInts("1 - 2 + 3 * 4".split(" "))

        assertThat(intDeque).isEqualTo(ArrayDeque(listOf(1, 2, 3, 4)))
    }

    @Test
    fun `수삭에 포함된 연산자들의 리스트를 반환합니다`() {
        val operations = InputConverter().convertToOperators("1 + 2 - 3 * 4 / 5".split(" "))

        assertThat(operations).isEqualTo(
            listOf(
                Operator.ADD,
                Operator.SUBTRACT,
                Operator.MULTIPLY,
                Operator.DIVIDE
            )
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["=", "%"])
    fun `정의 되지 않은 연산자를 받으면 NoSuchElementException 을 일으킨다`(input: String) {
        assertThrows<NoSuchElementException> {
            InputConverter().convertToOperators(input.split(" "))
        }
    }
}

package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputConverterTest {

    @Test
    fun `extractInts 실행 시 Int 덱을 반환한다`() {
        val intDeque = InputConverter().extractInts("1 - 2 + 3 * 4".split(" "))

        assertThat(intDeque).isEqualTo(ArrayDeque(listOf(1, 2, 3, 4)))
    }

    @Test
    fun `convertToOperations 실행 시 Operation 리스트를 반환한다`() {
        val operations = InputConverter().convertToOperations("1 + 2 - 3 * 4 / 5".split(" "))

        assertThat(operations).isEqualTo(
            listOf(
                Operator.ADD.operation,
                Operator.SUBTRACT.operation,
                Operator.MULTIPLY.operation,
                Operator.DIVIDE.operation
            )
        )
    }

    @Test
    fun `정의 되지 않은 연산자를 받으면 NoSuchElementException 을 일으킨다`() {
        assertThrows<NoSuchElementException> {
            InputConverter().convertToOperations("?".split(" "))
        }
    }
}

package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import stringcalculator.operations.Operation

class InputConverterTest {

    @Test
    fun `extractInts 실행 시 Int 덱을 반환한다`() {
        val intDeque = InputConverter().extractInts("1 - 2 + 3 * 4".split(" "))

        assertThat(intDeque).hasSize(4).allMatch { it is Int }
    }

    @Test
    fun `convertToOperations 실행 시 Operation 리스트를 반환한다`() {
        val operations = InputConverter().convertToOperations("2 + 3 * 4 / 2".split(" "))

        assertThat(operations).hasSize(3).allMatch { it is Operation }
    }

    @Test
    fun `정의되지 않은 연산자를 받으면 IllegalArgumentException 을 일으킨다`() {
        assertThrows<IllegalArgumentException> {
            InputConverter().convertToOperations("?".split(" "))
        }
    }
}

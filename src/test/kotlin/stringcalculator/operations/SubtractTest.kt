package stringcalculator.operations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SubtractTest {
    @Test
    fun `execute 시 덱의 처음 두 값을 꺼내 차를 구한 결과를 덱의 가장 앞에 집어넣는다`() {
        val deque = ArrayDeque(listOf(2, 1, 3))

        Subtract().execute(deque)

        assertThat(deque)
            .hasSize(2)
            .isEqualTo(ArrayDeque(listOf(1, 3)))
    }

    @ParameterizedTest
    @CsvSource(*["2, 1 | 1", "1, 2 | -1"], delimiter = '|')
    fun `차를 구할 때 첫 번째 값에서 두 번째 값을 뺀다`(input: String, expected: Int) {
        val deque = ArrayDeque(input.split(", ").map { it.toInt() })

        Subtract().execute(deque)

        assertThat(deque).isEqualTo(ArrayDeque(listOf(expected)))
    }

    @Test
    fun `덱에 값이 부족한 경우 NoSuchElementException 에러를 일으킨다`() {
        val deque = ArrayDeque(listOf(1))

        assertThrows<NoSuchElementException> {
            Subtract().execute(deque)
        }
    }
}

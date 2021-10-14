package stringcalculator.operations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SubtractTest {
    @Test
    fun `execute 시 덱의 처음 두 값을 꺼내 차를 구한 결과를 덱의 가장 앞에 집어넣는다`() {
        val deque = ArrayDeque(listOf(2, 1, 3))

        Subtract().execute(deque)

        assertThat(deque)
            .hasSize(2)
            .isEqualTo(ArrayDeque(listOf(1, 3)))
    }

    @Test
    fun `덱에 값이 부족한 경우 NoSuchElementException 에러를 일으킨다`() {
        val deque = ArrayDeque(listOf(1))

        assertThrows<NoSuchElementException> {
            Subtract().execute(deque)
        }
    }
}

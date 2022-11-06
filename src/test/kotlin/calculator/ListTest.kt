package calculator

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

internal class ListTest {

    @Test
    fun `리스트 마지막 인덱스를 확인한다`() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertThat(list.indices.last).isEqualTo(9)
    }

    @Test
    fun `리스트 이터레이터를 가져와서 다음 아이템을 확인한다`() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val iterator = list.listIterator()

        val next = iterator.next()
        assertThat(next).isEqualTo(1)
    }

    @Test
    fun `리스트 이터레이터를 가져와서 다다음 아이템을 확인한다`() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val iterator = list.listIterator()

        iterator.next()
        iterator.next()
        val next = iterator.next()
        assertThat(next).isEqualTo(3)
    }
}

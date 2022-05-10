package expressioncalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CollectionTest {
    @Test
    fun `chunked는 파라미터로 들어온 숫자의 단위로 리스트를 쪼갠다`() {
        val chunkedNumbers = listOf("one", "two", "three", "four", "five").chunked(3)

        val firstElement = listOf("one", "two", "three")
        val secondElement = listOf("four", "five")

        assertThat(chunkedNumbers).isEqualTo(listOf(firstElement, secondElement))
    }

    @Test
    fun `chunked는 콜백을 넘겨 쪼갠 리스트를 변환해 새로운 타입의 리스트를 만들 수 있다`() {
        val chunkedNumbers = listOf("one", "two", "three", "four", "five").chunked(3) {
            it.joinToString(" / ")
        }

        val firstElement = "one / two / three"
        val secondElement = "four / five"

        assertThat(chunkedNumbers).isEqualTo(listOf(firstElement, secondElement))
    }

    @Test
    fun `windowed는 앞에서부터 size 파라미터 크기의 sub list를 생성하고, step 파라미터 만큼 index를 건너 뛰어 다시 sub list를 생성한다`() {
        val size3Step1 = (1..5).toList().windowed(3)
        val size5Step3 = (1..10).toList().windowed(5, 3)

        val windowedSize3Step1 = listOf(listOf(1, 2, 3), listOf(2, 3, 4), listOf(3, 4, 5))
        val windowedSize5Step3 = listOf(listOf(1, 2, 3, 4, 5), listOf(4, 5, 6, 7, 8))

        assertThat(size3Step1).isEqualTo(windowedSize3Step1)
        assertThat(size5Step3).isEqualTo(windowedSize5Step3)
    }
}

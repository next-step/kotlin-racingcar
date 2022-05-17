package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CountTest {

    @Test
    fun `Int 5 입력되었을때 5개의 원소를 갖는 List 생성`() {
        assertThat(5.toList()).isEqualTo(listOf(1, 2, 3, 4, 5))
    }

    @Test
    fun `Int 0 입력되었을때 5개의 원소를 갖는 emptyList 생성`() {
        assertThat(0.toList()).isEqualTo(emptyList<Int>())
    }
}

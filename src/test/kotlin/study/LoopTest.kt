package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LoopTest {

    @Test
    fun `2 간격 으로 루프`() {
        val list = arrayListOf<Int>()
        for (i in 1..5 step 2) {
            list.add(i)
        }
        assertThat(list).containsAll(arrayListOf(1, 3, 5))
    }
}

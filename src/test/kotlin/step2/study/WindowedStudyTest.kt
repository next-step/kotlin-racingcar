package step2.study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Collection.windowed 의 기능을 학습하는 테스트
 */
internal class WindowedStudyTest {

    @Test
    fun `size 와 step 이 동일할 때 원소가 겹치지 않는지`() {
        val list = listOf(1, 2, 3, 4, 5)
        list.windowed(size = 2, step = 2, partialWindows = true) { window: List<Int> ->
            val first = window.first()

            // 마지막 window 에서 window.first()와 window.last()가 동일한 값이 나옴. window.size 가 step 보다 작을 때, 남은 원소를 특수 케이스 패턴으로 처리
            val last = if (window.size == 2) window.last() else 6
            assertThat(first).isNotEqualTo(last)
        }
    }
}

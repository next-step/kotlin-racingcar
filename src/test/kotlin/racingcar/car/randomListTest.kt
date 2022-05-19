package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RandomListTest {
    @Test
    fun `주어진 size 만큼 랜덤리스트가 생성된다`() {
        for (size in 0..200) {
            Assertions.assertThat(randomListBy(-100..100, size).size).isEqualTo(size)
        }
    }

    @Test
    fun `랜덤리스트의 모든 엘리먼트는 range 에 포함된 값이다`() {
        for (min in -10..10)
            for (max in min + 10..min + 20) {
                val range = min..max
                randomListBy(range, 100).forEach { Assertions.assertThat(range.contains(it)).isTrue }
            }
    }
}

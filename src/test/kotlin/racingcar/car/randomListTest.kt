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
    fun `충분히 큰 사이즈의 랜덤리스트를 구성할 경우, 각 엘리먼트의 분포도는 어느정도 균일함을 갖는다(허용오차 5%)`() {
        repeat(100) {
            val listSize = 100000
            val min = 0
            val max = 9
            val range = (min..max)
            val rangeSize = max - min + 1
            val expectedSize = listSize / rangeSize
            val allowableErrorRatio = 5
            val allowableErrorSize = expectedSize / 100 * allowableErrorRatio
            val allowableErrorRange = (expectedSize - allowableErrorSize..expectedSize + allowableErrorSize)
            val randomList = randomListBy(range, listSize)
            val intListMap = randomList.groupBy { it }

            Assertions.assertThat(intListMap.size).isEqualTo(rangeSize)
            intListMap.forEach { (int, list) -> Assertions.assertThat(allowableErrorRange.contains(list.size)).isTrue }
        }
    }
}

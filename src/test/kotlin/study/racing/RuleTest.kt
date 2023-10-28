package study.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.Rule

class RuleTest {
    @Test
    fun `움직임을 판단한 값을 설정하고, 움직임의 여부를 판단할 때, 4이상일 경우 참이 반환된다`() {
        // given : 움직임을 판단한 값을 설정한다.
        val numberList = mutableListOf(6, 4, 7, 5)

        // when : 움직임의 여부를 판단한다.
        val isMoveList = Rule.isMoveListTest(numberList)

        // then : 4이상일 경우 참이 반환된다.
        val expectedList = mutableListOf(true, false, true, true)
        for ((i, isMove) in isMoveList.withIndex()) {
            assertThat(isMove).isEqualTo(expectedList[i])
        }
    }
}

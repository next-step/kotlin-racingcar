package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.beans.Beans.isInstanceOf

class RaceTest {
    @Test
    fun `자동차 수와 이동 시도 횟수를 전달받아 roundList를 구성한다`() {
        // given
        val race = Race()
        val carCount = 3
        val roundCount = 5

        // when
        race.start(carCount, roundCount)

        // then
        assertThat(race.roundList).allMatch {
            isInstanceOf(it, Round::class.java)
        }
        assertThat(race.roundList.size).isEqualTo(roundCount)
    }
}

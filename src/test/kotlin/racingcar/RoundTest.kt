package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RoundTest {
    @Test
    fun `저장된 자동차 경주 결과를 문자열로 변환하여 반환한다`() {
        // given
        val carList = listOf(Car(1), Car(2), Car(3))
        val round = Round()

        // when
        round.saveResult(carList)

        // then
        assertThat(round.getResult()[0]).isEqualTo("-")
        assertThat(round.getResult()[1]).isEqualTo("--")
        assertThat(round.getResult()[2]).isEqualTo("---")
    }
}

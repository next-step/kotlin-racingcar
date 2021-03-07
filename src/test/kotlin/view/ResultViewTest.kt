package view

import domain.racingcar.Reception
import fixture.CarFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import view.ResultView.joinToWinners

class ResultViewTest {
    @Test
    fun `우승자들의 이름을 연결해준다`() {
        val carNames = CarFixture.CAR_NAMES

        val joinToWinners = joinToWinners(carNames, Reception.CAR_NAME_DELIMITERS)

        assertThat(joinToWinners).isEqualTo("kim, pack, lee")
    }
}

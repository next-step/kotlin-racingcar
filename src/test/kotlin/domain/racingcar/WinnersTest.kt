package domain.racingcar

import fixture.CarFixture.CAR_NAMES
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import domain.racingcar.Reception.CAR_NAME_DELIMITERS

class WinnersTest {
    @Test
    fun `우승자들의 이름을 연결해준다`() {
        val carNames = CAR_NAMES

        val winners = Winners(carNames)
        val joinToWinners = winners.joinToWinners(CAR_NAME_DELIMITERS)

        assertThat(joinToWinners).isEqualTo("kim, pack, lee")
    }
}

package racingcar.domain.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.domain.car.Car
import racingcar.domain.car.vo.Name
import racingcar.domain.car.vo.Position

class CarRaceResultTest {
    @Test
    fun `우승자를 확인`() {
        val 제이 = Car(Name("제이"), Position(2))
        val 제이슨 = Car(Name("제이슨"), Position(1))
        val 포비 = Car(Name("포비"), Position(1))

        val carRaceResultForRound = CarRaceResultForRound(listOf(제이, 제이슨, 포비))
        val carRaceResult = CarRaceResult(listOf(carRaceResultForRound))
        val winners = carRaceResult.findWinners()

        assertAll({
            assertThat(winners.size).isEqualTo(1)
            assertThat(winners[0].name).isEqualTo(제이.name.value)
            assertThat(winners[0].position).isEqualTo(제이.position.value)
        })
    }
}

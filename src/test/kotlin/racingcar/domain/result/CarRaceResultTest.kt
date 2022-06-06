package racingcar.domain.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.vo.Name
import racingcar.domain.move.MovingStrategy

class CarRaceResultTest {
    private val alwaysMovingStrategy = object : MovingStrategy {
        override fun canMove(): Boolean {
            return true
        }
    }

    @Test
    fun `우승자를 확인`() {
        val 제이 = Car(Name("제이"))
        val 제이슨 = Car(Name("제이슨"))
        val 포비 = Car(Name("포비"))

        포비.move(alwaysMovingStrategy)
        val firstRound = CarRaceResultForRound(listOf(제이, 제이슨, 포비))

        제이.move(alwaysMovingStrategy)
        제이슨.move(alwaysMovingStrategy)
        val secondRound = CarRaceResultForRound(listOf(제이, 제이슨, 포비))

        제이.move(alwaysMovingStrategy)
        val thirdRound = CarRaceResultForRound(listOf(제이, 제이슨, 포비))

        val carRaceResult = CarRaceResult(listOf(firstRound, secondRound, thirdRound))

        val winners = carRaceResult.findWinners()
        assertThat(winners.size).isEqualTo(1)
        assertThat(winners[0].name).isEqualTo(제이.name.value)
        assertThat(winners[0].position).isEqualTo(제이.position.value)
    }
}

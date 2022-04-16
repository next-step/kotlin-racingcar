package racingcar.domain.racing

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.CarAction
import racingcar.domain.car.Cars

internal class WinnersTest {

    @Test
    internal fun `가장 멀리 간 자동차가 우승자고 우승자는 한 명 이상일 수 있다`() {
        val expectedWinner1 = Car(name = "가", accelerator = { CarAction.MOVE })
        val expectedWinner2 = Car(name = "나", accelerator = { CarAction.MOVE })
        val cars = Cars(
            cars = listOf(
                expectedWinner1,
                expectedWinner2,
                Car(name = "다", accelerator = { CarAction.STOP }),
            )
        ).race()
        assertThat(Winners(CarsHistory(mutableListOf(cars)))).allSatisfy {
            assertThat(it.movedDistance).isEqualTo(WINNER_MOVED_DISTANCE)
        }
    }

    companion object {
        private const val WINNER_MOVED_DISTANCE = 1
    }
}

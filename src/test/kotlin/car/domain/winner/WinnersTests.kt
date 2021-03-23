package car.domain.winner

import car.domain.move.AlwaysMovableStrategy
import car.domain.Car
import car.domain.Cars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnersTests {
    @Test
    fun `승리자 목록은 자동차 중 최고 위치에 있는 애들로 뽑아야 한다`() {
        val cars = Cars(
            listOf(
                Car("1번차", 3),
                Car("2번차", 5),
                Car("3번차", 2),
                Car("4번차", 5),
                Car("5번차", 1)
            )
        )
        val winners = Winners(cars.currentMoveHistories)

        assertThat(winners.winners)
            .containsExactlyInAnyOrder(
                Winner("2번차"),
                Winner("4번차")
            )
    }

    private fun Car(carName: String, position: Int): Car {
        return Car(carName, position, AlwaysMovableStrategy())
    }
}

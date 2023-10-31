package step4

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import step4.domain.CarName
import step4.domain.RacingCar
import step4.domain.RacingCars

class RacingCarsTest {
    @Test
    fun `가장 높은 moveCount를 가진 차의 리스트를 뽑아준다`() {
        val racingCars1 = listOf(
            RacingCar(CarName("1"), 1),
            RacingCar(CarName("2"), 2),
            RacingCar(CarName("3"), 3)
        )
        Assertions.assertThat(RacingCars(racingCars1).winner)
            .isEqualTo(listOf(RacingCar(CarName("3"), 3)))
    }

    @Test
    fun `여러 개의 가장 높은 moveCount를 가진 차의 리스트를 뽑아준다`() {
        val racingCars1 = listOf(
            RacingCar(CarName("1"), 3),
            RacingCar(CarName("2"), 3),
            RacingCar(CarName("3"), 1)
        )
        Assertions.assertThat(RacingCars(racingCars1).winner)
            .isEqualTo(
                listOf(
                    RacingCar(CarName("1"), 3),
                    RacingCar(CarName("2"), 3)
                )
            )
    }
}

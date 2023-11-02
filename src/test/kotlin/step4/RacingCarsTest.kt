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
            RacingCar(CarName(name = "1"), moveCount = 1),
            RacingCar(CarName(name = "2"), moveCount = 2),
            RacingCar(CarName(name = "3"), moveCount = 3)
        )
        Assertions.assertThat(RacingCars(racingCars1).winner)
            .isEqualTo(listOf(RacingCar(CarName(name = "3"), moveCount = 3)))
    }

    @Test
    fun `여러 개의 가장 높은 moveCount를 가진 차의 리스트를 뽑아준다`() {
        val racingCars1 = listOf(
            RacingCar(CarName(name = "1"), moveCount = 3),
            RacingCar(CarName(name = "2"), moveCount = 3),
            RacingCar(CarName(name = "3"), moveCount = 1)
        )
        Assertions.assertThat(RacingCars(racingCars1).winner)
            .isEqualTo(
                listOf(
                    RacingCar(CarName(name = "1"), moveCount = 3),
                    RacingCar(CarName(name = "2"), moveCount = 3)
                )
            )
    }
}

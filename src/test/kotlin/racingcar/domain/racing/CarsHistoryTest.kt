package racingcar.domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.CarAction
import racingcar.domain.car.Cars

internal class CarsHistoryTest {

    @Test
    internal fun `자동차가 움직인 히스토리를 동적으로 추가할 수 있다`() {
        val carsHistory = CarsHistory()
        val cars = Cars(listOf())
        carsHistory.add(cars)
        assertThat(carsHistory.latest).isEqualTo(cars)
    }

    @Test
    internal fun `자동차의 마지막 히스토리를 가져올 수 있다`() {
        val latestCar = Cars(listOf())
        val carsHistory = CarsHistory(
            listOf(
                Cars(listOf()),
                latestCar
            )
        )
        assertThat(carsHistory.latest).isEqualTo(latestCar)
    }

    @Test
    internal fun `가장 멀리 간 자동차를 알 수 있다`() {
        val maxDrivenCar = Car(name = "가", accelerator = { CarAction.MOVE })
        val cars = Cars(
            cars = listOf(
                maxDrivenCar,
                Car(name = "나", accelerator = { CarAction.STOP }),
            )
        )
        val carsHistory = CarsHistory(listOf(cars))
        assertThat(carsHistory.maxDrivenCars).allSatisfy {
            assertThat(it.movedDistance).isEqualTo(maxDrivenCar.movedDistance)
        }
    }
}

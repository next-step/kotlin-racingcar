package racingcar.domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.CarPosition
import racingcar.domain.car.Cars
import racingcar.domain.car.Ignore

internal class CarsHistoryTest {

    @Test
    internal fun `자동차가 움직인 히스토리를 동적으로 추가할 수 있다`() {
        val carsHistory = CarsHistory()
        val cars = Cars(emptyList())
        carsHistory.add(cars)
        assertThat(carsHistory.carsHistory).containsExactly(cars)
    }

    @Test
    internal fun `자동차의 마지막 히스토리를 가져올 수 있다`() {
        val latestCar = Cars(emptyList())
        val carsHistory = CarsHistory(
            listOf(
                Cars(emptyList()),
                latestCar
            )
        )
        assertThat(carsHistory.latest).isEqualTo(latestCar)
    }

    @Test
    internal fun `가장 멀리 간 자동차를 알 수 있다`() {
        val cars = Cars(
            cars = listOf(
                Car(name = "가", accelerator = Ignore(), position = CarPosition(10)),
                Car(name = "나", accelerator = Ignore(), position = CarPosition(0)),
            )
        )
        val carsHistory = CarsHistory(listOf(cars))
        assertThat(carsHistory.maxDrivenCars).allSatisfy {
            assertThat(it.name).isEqualTo("가")
        }
    }
}

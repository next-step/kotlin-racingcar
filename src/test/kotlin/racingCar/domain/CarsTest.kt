package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingCar.domain.strategy.MoveStrategy
import racingCar.domain.strategyImpl.RandomStrategy

class CarsTest {

    private lateinit var cars: Cars
    private val moveStrategy: MoveStrategy = RandomStrategy()

    @BeforeEach
    fun setUp() {
        cars = Cars(moveStrategy)
    }

    @Test
    fun `각 자동차 Name 이 ","를 기준으로 List 에 반환된다`() {
        cars.initCars(CARS)
        val expectedNames = listOf("pobi", "crong", "honux")
        assertThat(cars.getCarList().map { it.name }).containsExactlyElementsOf(expectedNames)
    }

    @Test
    fun `자동차 Name 의 길이는 5 초과가 되어선 안된다`() {
        assertThrows<IllegalArgumentException> {
            cars.initCars(LENGTH_OVER_CARS)
        }
    }

    @Test
    fun `moveCount 가 제일 높은 Car 의 Names 을 출력 한다`() {
        val car1 = Car("car1", 3, moveStrategy)
        val car2 = Car("car2", 2, moveStrategy)
        val car3 = Car("car3", 3, moveStrategy)

        val carList = listOf(car1, car2, car3)
        val winners = Cars(moveStrategy, carList).getWinners()

        assertThat(winners).containsExactly(car1, car3)
    }

    companion object {
        private const val CARS = "pobi,crong,honux"
        private const val LENGTH_OVER_CARS = "pobiaaa,crongbbb,honuxccc"
    }
}

package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import racingcar.domain.move.StaticMoveStrategy

@ExtendWith()
class RoundTest {

    private lateinit var round: Round
    private lateinit var cars: MutableList<Car>

    @BeforeEach
    fun setUp() {
        round = Round()
        cars = mutableListOf()
        initCars()
    }

    private fun initCars() {
        val TEST_CAR_NUMBER = 5
        for (i in 0 until TEST_CAR_NUMBER) {
            cars.add(Car(StaticMoveStrategy()))
        }
    }

    @Test
    fun `라운드가 시작되면 자동차는 모두 1칸 이동`() {
        round.execute(cars)

        for (car in cars) {
            assertThat(car.location).isEqualTo(1)
        }
    }
}

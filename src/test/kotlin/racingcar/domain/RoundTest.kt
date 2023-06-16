package racingcar.domain

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith()
class RoundTest {

    private lateinit var round: Round
    private lateinit var cars: ArrayList<Car>

    @BeforeEach
    fun setUp() {
        round = Round()
        cars = ArrayList()
        initCars()
    }

    private fun initCars() {
        val TEST_CAR_NUMBER = 5
        for (i in 0 until TEST_CAR_NUMBER) {
            cars.add(Car(RandomMoveStrategy()))
        }
    }

    @Test
    fun `라운드 결과`() {
        round.execute(cars)
    }
}

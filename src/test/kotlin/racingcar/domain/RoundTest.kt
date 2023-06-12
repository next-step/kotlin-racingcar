package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import racingcar.view.OutputView
import kotlin.collections.ArrayList

class RoundTest {

    private lateinit var round: Round

    private lateinit var cars: ArrayList<Car>

    @BeforeEach
    fun setUp() {
        round = Round(outputView = OutputView())
        cars = ArrayList()
    }

    fun `라운드 시작`() {
        assertThat(cars)
    }

    private fun initCars() {
        val TEST_CAR_NUMBER = 5
        for (i in 0 until TEST_CAR_NUMBER) {
            cars.add(Car())
        }
    }
}

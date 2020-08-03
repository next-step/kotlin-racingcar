package racingCar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingCar.domain.RacingCar
import racingCar.domain.RacingCar.Companion.racingCars

class RacingTest {

    private var racingCarNames = listOf<String>()
    private lateinit var racingCarResult: RacingCar

    private fun setup() {
        racingCarNames = mutableListOf("찬희", "코틀린")
        racingCarResult = RacingCar(racingCarNames)
    }

    @Test
    fun `check input randomNumber over 4`() {
        setup()
        racingCars[0].changeStateRacingCar(8)
        assertTrue(racingCars[0].distance == 1)
    }

    @Test
    fun `check input randomNumber below 4`() {
        setup()
        racingCars[0].changeStateRacingCar(3)
        assertTrue(racingCars[0].distance == 0)
    }
}

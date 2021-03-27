package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingResultTest {

    @Test
    fun `결과에서 winner 찾기`() {
        val result = RacingResult()
        val car = Car(Name("test"))
        val movedCar = car.move(Number(4))
        val cars = Cars(listOf(movedCar, car))

        result.add(cars)

        assertThat(result.winner).isEqualTo(Winner(listOf(movedCar)))
    }
}

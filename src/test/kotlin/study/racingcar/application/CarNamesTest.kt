package study.racingcar.application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import study.racingcar.domain.RacingCar.Companion.DEFAULT_POSITION

class CarNamesTest {

    @Test
    fun `입력받은 CarNames 로 RacingCars 를 생성한다`() {
        // given
        val carNames = CarNames(listOf(CarName("car1"), CarName("car2"), CarName("car3")))

        // when
        val actual = carNames.prepareForRace()

        // then
        actual.racingCars.forEach { racingCar ->
            assertEquals(DEFAULT_POSITION, racingCar.currentPosition)
        }
    }
}

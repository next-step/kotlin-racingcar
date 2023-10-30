package race.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingCarTest {
    @Test
    fun `자동차의 초기 위치는 0칸`() {
        val car = RacingCar(name = "")

        assertEquals(0, car.space)
    }

    @Test
    fun `자동차가 1칸 전진`() {
        val car = RacingCar(name = "")
        car.go()

        assertEquals(1, car.space)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `자동차가 N칸 전진`(input: Int) {
        val car = RacingCar(name = "")

        for (i in 1..input) {
            car.go()
        }

        assertEquals(input, car.space)
    }

    @Test
    fun `자동차가 우승`() {
        val car = RacingCar(name = "")

        car.win()

        assertEquals(true, car.isWinner)
    }
}

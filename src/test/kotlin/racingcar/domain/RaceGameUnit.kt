package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceGameUnit {

    @Test
    fun `Cars_크기_테스트`() {
        val raceGame = RaceGame()
        raceGame.addCar(Car())
        assertThat(raceGame.cars.size).isEqualTo(1)
    }
}
package study

import domain.Car
import domain.Race
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `자동차 전진 값 확인`() {
        val car = Car()
        var position = 0
        val isMoving = car.isMoving()
        if (isMoving) position += 1
        assertThat(Race().carRace(car, isMoving)).isEqualTo(position)
    }
}
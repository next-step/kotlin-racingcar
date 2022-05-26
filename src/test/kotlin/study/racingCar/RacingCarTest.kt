package study.racingCar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.racingCar.domain.Car

class RacingCarTest {

    @Test
    fun `주어진 횟수동안 전진 혹은 멈춘다`() {
        val car = Car()
        (0..4).forEach { car.moveOneStep() }
        assertThat(car.tryCounts).isEqualTo(5)
    }

    @Test
    fun `무작위 수가 4이상일 경우에만 전진한다`() {
        val car = Car()
        val initialMovedSteps = car.movedSteps

        car.moveOneStep(4).movedSteps
        assertThat(car.movedSteps).isEqualTo(initialMovedSteps + 1)
    }

    @Test
    fun `무작위 수가 4미만인 경우에는 전진하지 않는다`() {
        val car = Car()
        val initialMovedSteps = car.movedSteps

        car.moveOneStep(1).movedSteps
        assertThat(car.movedSteps).isEqualTo(initialMovedSteps)
    }
}
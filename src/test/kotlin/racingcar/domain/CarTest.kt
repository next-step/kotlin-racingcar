package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.strategy.FairMovingStrategy

internal class CarTest {
    private val car = Car(0, "car", FairMovingStrategy())

    @BeforeEach
    fun setUp() {
        for (i in 0 until 5) {
            car.moveForward()
        }
    }

    @Test
    fun getName() {
        assertThat(car.getName()).isEqualTo("No.0 car")
    }

    @Test
    fun getMovingPath() {
        assertThat(car.getMovingPath()).isEqualTo("-----")
    }

    @Test
    fun isWinner() {
        assertThat(car.isWinner(5)).isTrue()
    }

    @Test
    fun compareTo() {
        val other = Car(1, "", FairMovingStrategy()).apply { moveForward() }
        assertThat(car.compareTo(other)).isEqualTo(1)
    }
}

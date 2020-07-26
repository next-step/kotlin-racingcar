package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarTest {
    @Test
    fun `result size`() {
        val result = RacingCar.race(3, 5)
        assertThat(result.size).isEqualTo(3)
        assertThat(result[0].size).isEqualTo(5)
    }

    @Test
    fun `result history values must be between zero and tries`() {
        val tries = 5
        val result = RacingCar.race(3, tries)
        val resultHistoryValues = result[0]
        val actual = resultHistoryValues.all {
            it in 0..tries
        }
        assertThat(actual).isTrue()
    }

    @Test
    fun `can move false`() {
        val car = RacingCar.Car()
        val canMoveMethod = car.javaClass.getDeclaredMethod("canMove", Int::class.java)
        canMoveMethod.trySetAccessible()
        assertThat(canMoveMethod.canAccess(car)).isTrue()
        val actual = canMoveMethod.invoke(car, 3) as Boolean
        assertThat(actual).isFalse()
    }

    @Test
    fun `can move true`() {
        val car = RacingCar.Car()
        val canMoveMethod = car.javaClass.getDeclaredMethod("canMove", Int::class.java)
        canMoveMethod.trySetAccessible()
        assertThat(canMoveMethod.canAccess(car)).isTrue()
        val actual = canMoveMethod.invoke(car, 4) as Boolean
        assertThat(actual).isTrue()
    }
}

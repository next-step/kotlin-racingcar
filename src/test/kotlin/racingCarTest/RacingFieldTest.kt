package racingCarTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingCar.RacingField

class RacingFieldTest {
    @Test
    fun racingFieldCreateCarsTest() {
        val racingField = RacingField(3, 0)
        assertThat(racingField.getCarCount()).isEqualTo(3)
    }

    @Test
    fun racingFieldSetGameCountTest() {
        val racingField = RacingField(0, 5)
        assertThat(racingField.getGameCount()).isEqualTo(5)
    }

    @Test
    fun racingFieldGameStartTest() {
        val carCount = 5
        val gameCount = 100
        val racingField = RacingField(carCount, gameCount)

        repeat(gameCount) {
            racingField.gameStart()
            assertThat(racingField.getCarsDistance().stream().allMatch { it in 0..gameCount })
        }
    }
}

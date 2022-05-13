package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import racingcar.model.movement.AlwaysGoMovement
import racingcar.model.movement.AlwaysNotGoMovement

internal class RacingGameTest {

    @Test
    internal fun testForAlwaysGo() {

        // given
        val numberOfCar = 3
        val stepsToTry = 5
        val movement = AlwaysGoMovement() // Always Go
        val racingGame = RacingGame(numberOfCar, stepsToTry, movement)

        // when
        val gameRecord = racingGame.runGame()

        // then
        assertAll(
            { assertThat(racingGame.carList.size).isEqualTo(numberOfCar) },
            { assertThat(gameRecord.carRecordList.size).isEqualTo(numberOfCar) },
            { assertThat(gameRecord.stepToTry).isEqualTo(stepsToTry) },
            {
                assertThat(gameRecord.latestRecord.joinToString(""))
                    .isEqualTo(stepsToTry.toString().repeat(numberOfCar))
            }
        )
    }

    @Test
    internal fun testForAlwaysNotGo() {

        // given
        val numberOfCar = 10
        val stepsToTry = 5
        val movement = AlwaysNotGoMovement() // Always Not Go
        val racingGame = RacingGame(numberOfCar, stepsToTry, movement)

        // when
        val gameRecord = racingGame.runGame()

        // then
        assertAll(
            { assertThat(racingGame.carList.size).isEqualTo(numberOfCar) },
            { assertThat(gameRecord.carRecordList.size).isEqualTo(numberOfCar) },
            { assertThat(gameRecord.stepToTry).isEqualTo(stepsToTry) },
            {
                assertThat(gameRecord.latestRecord.joinToString(""))
                    .isEqualTo("0".repeat(numberOfCar))
            }
        )
    }

    @Test
    internal fun testForRandomGame() {

        // given
        val numberOfCar = 10
        val stepsToTry = 5
        val racingGame = RacingGame(numberOfCar, stepsToTry)

        // when
        val gameRecord = racingGame.runGame()

        // then
        assertAll(
            { assertThat(racingGame.carList.size).isEqualTo(numberOfCar) },
            { assertThat(racingGame.currentStep).isEqualTo(stepsToTry) },
            { assertThat(racingGame.isOver).isTrue },
            { assertThat(gameRecord.carRecordList.size).isEqualTo(numberOfCar) }
        )
    }
}

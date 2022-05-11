package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import racingcar.model.movement.AlwaysGoMovement
import racingcar.model.movement.AlwaysNotGoMovement

internal class RacingGameTest {

    @Test
    internal fun testForAlwaysGo() {

        val numberOfCar = 3
        val stepsToTry = 5
        val movement = AlwaysGoMovement() // Always Go
        val racingGame = RacingGame(numberOfCar, stepsToTry, movement)

        assertThat(racingGame.carList.size).isEqualTo(numberOfCar)
        racingGame.runGame { game ->
            game.carList.forEach { car ->
                assertThat(car.position).isEqualTo(game.currentStep) // always == step
            }
        }
    }

    @Test
    internal fun testForAlwaysNotGo() {

        val numberOfCar = 10
        val stepsToTry = 5
        val movement = AlwaysNotGoMovement() // Always Not Go
        val racingGame = RacingGame(numberOfCar, stepsToTry, movement)

        assertThat(racingGame.carList.size).isEqualTo(numberOfCar)
        racingGame.runGame { game ->
            game.carList.forEach { car ->
                assertThat(car.position).isEqualTo(0) // always == 0
            }
        }
    }

    @Test
    internal fun testForRandomGame() {

        val numberOfCar = 10
        val stepsToTry = 5
        val racingGame = RacingGame(numberOfCar, stepsToTry)
        racingGame.runGame()

        assertAll(
            { assertThat(racingGame.carList.size).isEqualTo(numberOfCar) },
            { assertThat(racingGame.currentStep).isEqualTo(stepsToTry) },
            { assertThat(racingGame.isOver).isTrue }
        )
    }

    @Test
    internal fun testForNoProgressFunction() {
        val numberOfCar = 10
        val stepsToTry = 5
        val racingGame = RacingGame(numberOfCar, stepsToTry)
        racingGame.runGame()

        assertThat(racingGame.currentStep)
            .isEqualTo(stepsToTry)
    }
}

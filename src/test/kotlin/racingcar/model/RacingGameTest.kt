package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.movement.AlwaysGoMovement
import racingcar.model.movement.AlwaysNotGoMovement

internal class RacingGameTest {

    @Test
    internal fun testForAlwaysGo() {

        val numberOfCar = 3
        val stepsToTry = 5
        val movement = AlwaysGoMovement() // Always Go

        RacingGame(numberOfCar, stepsToTry, movement).runGame { game ->
            assertThat(game.carList.size).isEqualTo(numberOfCar)
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

        RacingGame(numberOfCar, stepsToTry, movement).runGame { game ->
            assertThat(game.carList.size).isEqualTo(numberOfCar)
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
        racingGame.runGame { game ->
            assertThat(game.currentStep).isLessThan(stepsToTry + 1)
            assertThat(game.carList.size).isEqualTo(numberOfCar)
        }
        assertThat(racingGame.currentStep).isEqualTo(stepsToTry)
        assertThat(racingGame.isOver).isTrue
    }

    @Test
    internal fun testForNoProgressFunction() {
        val numberOfCar = 10
        val stepsToTry = 5
        assertThat(RacingGame(numberOfCar, stepsToTry).runGame().currentStep)
            .isEqualTo(stepsToTry)
    }
}

package racinggame.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `check making car`() {
        val carName = "first,sec,third"
        val moving = 5
        val game = Game.createGame(carName, moving)

        assertThat(game.cars.size).isEqualTo(3)
    }

    @Test
    fun verifyCallbackInvocation() {
        val carName = "first,sec,third"
        val moving = 5
        val game = Game.createGame(carName, moving)

        var callbackNum = 0
        val mockCallback: (Int, List<RacingCar>) -> Unit = { turn, cars ->
            callbackNum++
        }
        game.startGame(mockCallback)

        callbackNum shouldBe moving
    }

    @Test
    fun checkGetResultTest() {
        val carName = "first,sec,third"
        val moving = 2
        val movingGenerator =
            object : RandomNumberStrategy {
                private var callCount = 0

                override fun generate(): Int {
                    return if (callCount++ % 3 == 0) 5 else 0
                }
            }

        val game = Game.createGame(carName, moving, movingGenerator)
        val mockCallback: (Int, List<RacingCar>) -> Unit = { turn, cars -> }

        game.startGame(mockCallback)
        val result = game.getResult()

        result.size shouldBe 1
        result[0].carName shouldBe "first"
        result[0].getCurrentPosition() shouldBe 2
    }
}

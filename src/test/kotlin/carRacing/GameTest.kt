package carRacing

import carRacing.Game.Companion.INVALID_CAR_NUMBER
import carRacing.Game.Companion.INVALID_NUM_MOVEMENT
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class GameTest : FreeSpec({

    "init" - {

        "유효하지 않은 자동차 수가 들어올 경우 IllegalArgumentException" {
            val numCar = -1
            val numMovement = 5
            val exception = shouldThrow<IllegalArgumentException> {
                Game(numCar, numMovement)
            }
            exception.message shouldBe INVALID_CAR_NUMBER
        }

        "유효하지 않은 시도 횟수가 들어올 경우 IllegalArgumentException" {
            val numCar = 1
            val numMovement = 0
            val exception = shouldThrow<IllegalArgumentException> {
                Game(numCar, numMovement)
            }
            exception.message shouldBe INVALID_NUM_MOVEMENT
        }
    }

    "run" - {

        "오류 없이 실행되어야한다." {
            // given
            val numCar = 2
            val numMovement = 5
            val game = Game(numCar, numMovement)

            // when
            game.run()

            // then
            game.recordList.size shouldBe numMovement
            game.recordList.forEach {
                it.positions.size shouldBe numCar
            }
        }
    }
})

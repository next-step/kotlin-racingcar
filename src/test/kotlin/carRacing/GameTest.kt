package carRacing

import carRacing.controller.Game
import carRacing.controller.Game.Companion.INVALID_CAR_LIST
import carRacing.controller.Game.Companion.INVALID_NUM_MOVEMENT
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class GameTest : FreeSpec({

    "init" - {

        "유효하지 않은 자동차 이름 입력이 들어올 경우 IllegalArgumentException" {
            val carNameList: List<String> = listOf()
            val numMovement = 5
            val exception = shouldThrow<IllegalArgumentException> {
                Game(carNameList, numMovement)
            }
            exception.message shouldBe INVALID_CAR_LIST
        }

        "유효하지 않은 시도 횟수가 들어올 경우 IllegalArgumentException" {
            val carNameList = listOf("uju")
            val numMovement = 0
            val exception = shouldThrow<IllegalArgumentException> {
                Game(carNameList, numMovement)
            }
            exception.message shouldBe INVALID_NUM_MOVEMENT
        }
    }

    "run" - {

        "오류 없이 실행되어야한다." {
            // given
            val carNameList = listOf("uju", "test")
            val numMovement = 5
            val game = Game(carNameList, numMovement)

            // when
            game.run()

            // then
            game.recordList.size shouldBe numMovement
            game.recordList.forEach {
                it.positions.size shouldBe carNameList.size
            }
        }
    }
})

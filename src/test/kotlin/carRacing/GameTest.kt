package carRacing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class GameTest : FreeSpec({

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

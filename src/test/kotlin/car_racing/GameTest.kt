package car_racing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class GameTest : FreeSpec({

    "run" - {

        "오류 없이 실행되어야한다." {
            val game = Game(1, 1)

            game.run() shouldBe Unit
        }
    }
})

package car.racing

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class GameTest : FreeSpec({
    "경기" - {
        "시작하면 결과를 반환" {
            val result = Game(10, 20).play()
            result shouldNotBe null
            result.records.isNotEmpty() shouldBe true
        }
        "드라이버가 0명일 경우 IllegalArgumentException 발생" {
            shouldThrowExactly<IllegalArgumentException> {
                Game(0, 100)
            }
        }
        "이동횟수가 0경우 IllegalArgumentException 발생" {
            shouldThrowExactly<IllegalArgumentException> {
                Game(10, 0)
            }
        }
    }
})

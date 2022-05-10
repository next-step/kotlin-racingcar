package car.racing

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldNotBe

class CarRacingTest : FreeSpec({
    "자동차 경주" - {
        val racing = CarRacing()

        "새 게임을 생성하고 시작하면" - {
            val game = racing.newGame(drivers = 1, moves = 1)
            "완료하고 결과를 반환" {
                val result = game.play()
                result.records.size shouldNotBe 0
            }
        }

        "드라이버가 명수가 유효하지 않은 경우 IllegalArgumentException 발생" {
            shouldThrowExactly<IllegalArgumentException> {
                racing.newGame(drivers = 0, moves = 1)
            }
        }

        "시도 횟수가 유효하지 않은 경우 IllegalArgumentException 발생" {
            shouldThrowExactly<IllegalArgumentException> {
                racing.newGame(drivers = 1, moves = 0)
            }
        }
    }
})

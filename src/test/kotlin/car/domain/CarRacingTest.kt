package car.domain

import car.domain.CarRacing
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldNotBe

class CarRacingTest : FreeSpec({
    val driverNames = listOf("크림", "히어로")
    "자동차 경주" - {
        "새 게임을 생성하고 시작하면" - {
            val game = CarRacing.newGame(driverNames = driverNames, moves = 1)
            "완료하고 결과를 반환" {
                val result = game.play()
                result.records.size shouldNotBe 0
            }
        }

        "드라이버가 명수가 유효하지 않은 경우 IllegalArgumentException 발생" {
            shouldThrowExactly<IllegalArgumentException> {
                CarRacing.newGame(driverNames = emptyList(), moves = 1)
            }
        }

        "시도 횟수가 유효하지 않은 경우 IllegalArgumentException 발생" {
            shouldThrowExactly<IllegalArgumentException> {
                CarRacing.newGame(driverNames = driverNames, moves = 0)
            }
        }
    }
})

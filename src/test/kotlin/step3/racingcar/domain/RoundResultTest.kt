package step3.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class RoundResultTest : BehaviorSpec({
    val round = 1
    given("RoundResult : 단일 라운드의 경주 결과 반환") {
        val randomNumber = 4
        `when`("전진/멈춤 결과를 판별하면") {
            val actual = RoundResult(round, MoveStatus.match(randomNumber))
            then("해당 라운드의 경주 결과를 반환한다.") {
                actual.round shouldBe round
                actual.moveStatus shouldBe MoveStatus.ACCELERATION
            }
        }
    }

    given("RoundResult : 특정 라운드에 3이 주어지고") {
        val randomNumber = 3
        `when`("전진/멈춤 결과를 판별하면") {
            val actual = RoundResult(round, MoveStatus.match(randomNumber))
            then("해당 라운드의 경주 결과를 반환한다.") {
                actual.round shouldBe round
                actual.moveStatus shouldBe MoveStatus.BREAK
            }
        }
    }
})

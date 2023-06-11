package racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@DisplayName("레이싱 심판")
class RacingRefereeTest : StringSpec({

    "경주 기록으로 생성" {
        shouldNotThrowAny {
            RacingReferee(listOf(RacingCars(listOf(ONLY_GO_RACING_CAR))))
        }
    }

    "경주 기록은 필수" {
        shouldThrowExactly<IllegalArgumentException> {
            RacingReferee(listOf())
        }
    }

    "마지막 기록에서 멀리간 자동차가 우승자" {
        // given
        val expectedWinner: RacingCar = ONLY_GO_RACING_CAR
        val loser: RacingCar = ONLY_STOP_RACING_CAR

        val history: RacingHistory = listOf(
            RacingCars(listOf(expectedWinner, loser)),
            RacingCars(listOf(expectedWinner, loser)).nextMoved
        )
        // when
        val winners: RacingCars = RacingReferee(history).winners
        // then
        winners shouldBe RacingCars(listOf(ONLY_GO_RACING_CAR.nextMoved))
    }
})

package racingcar.model

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

@DisplayName("레이싱 경기장")
class RacingStadiumTest : StringSpec({

    "바퀴 수로 생성 가능" {
        listOf(1, 10, Int.MAX_VALUE).forAll {
            shouldNotThrowAny { RacingStadium(it) }
        }
    }

    "바퀴 수는 반드시 0 또는 양수" {
        listOf(Int.MIN_VALUE, -1).forAll {
            shouldThrowExactly<IllegalArgumentException> { RacingStadium(it) }
        }
    }

    "주어진 자동차들은 바퀴 수 만큼 경기 내용을 기록" {
        // given
        val onlyGoCars = RacingCars((1..3).map { (RacingCar(OnlyGoMoveStrategy)) })
        val oneLabsStadium = RacingStadium(1)
        // when
        val history: RacingHistory = oneLabsStadium racing onlyGoCars
        // then
        assertSoftly(history) {
            it shouldHaveSize 1
            it.first().cars.forAll { car ->
                car shouldBe RacingCar(
                    OnlyGoMoveStrategy,
                    MovingStatuses(listOf(MovingStatus.GO))
                )
            }
        }
    }
})

package racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@DisplayName("레이싱 자동차들")
class RacingCarsTest : StringSpec({

    "자동차들로 생성" {
        shouldNotThrowAny { RacingCars(listOf(ONLY_GO_RACING_CAR, ONLY_GO_RACING_CAR)) }
    }

    "빈 자동차들로 생성" {
        shouldNotThrowAny { RacingCars(listOf()) }
    }

    "다음 이동한 상태들 반환" {
        // given
        val initializedCars = RacingCars(listOf(ONLY_GO_RACING_CAR))
        // when
        val movedCars: RacingCars = initializedCars.nextMoved
        // then
        movedCars shouldBe RacingCars(listOf(RacingCar(SAMPLE_NAME, OnlyGoMoveStrategy, MovingStatuses(listOf(MovingStatus.GO)))))
    }
})

package racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

@DisplayName("레이싱 자동차")
class RacingCarTest : StringSpec({

    "초기 움직임 상태들로 생성 가능" {
        shouldNotThrowAny {
            RacingCar(
                SAMPLE_NAME,
                OnlyGoMoveStrategy,
                MovingStatuses(listOf(MovingStatus.GO, MovingStatus.STOP))
            )
        }
    }

    "초기 기록이 없다면 움직인 기록은 없음" {
        RacingCar(SAMPLE_NAME, OnlyGoMoveStrategy) shouldBe RacingCar(SAMPLE_NAME, OnlyGoMoveStrategy, MovingStatuses())
    }

    "다음 움직임 상태 추가" {
        // given
        val emptyMovedStatues = RacingCar(SAMPLE_NAME, OnlyGoMoveStrategy)
        // when
        val nextMoved: RacingCar = emptyMovedStatues.nextMoved
        // then
        nextMoved shouldBe RacingCar(SAMPLE_NAME, OnlyGoMoveStrategy, MovingStatuses(listOf(MovingStatus.GO)))
    }

    "움직인 횟수만큼 반환" {
        listOf(
            MovingStatuses(listOf(MovingStatus.STOP, MovingStatus.STOP)) to 0,
            MovingStatuses(listOf(MovingStatus.GO, MovingStatus.STOP)) to 1,
            MovingStatuses(listOf(MovingStatus.GO, MovingStatus.GO)) to 2,
        ).forAll { (movedStatuses, expectedWentSize) ->
            RacingCar(SAMPLE_NAME, OnlyGoMoveStrategy, movedStatuses).wentDistance shouldBe expectedWentSize
        }
    }
})

val ONLY_GO_RACING_CAR: RacingCar = RacingCar(SAMPLE_NAME, OnlyGoMoveStrategy)
val ONLY_STOP_RACING_CAR: RacingCar = RacingCar(SAMPLE_NAME, OnlyStopMoveStrategy)

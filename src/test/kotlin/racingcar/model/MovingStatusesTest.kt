package racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@DisplayName("움직인 상태들")
class MovingStatusesTest : StringSpec({

    "콜렉션으로 생성" {
        shouldNotThrowAny { MovingStatuses(listOf(MovingStatus.GO)) }
    }

    "기본 인자인 빈 컬렉션 생성" {
        shouldNotThrowAny { MovingStatuses() }
    }

    "이동한 만큼 계산" {
        MovingStatuses(listOf(MovingStatus.GO, MovingStatus.STOP)).wentSize shouldBe 1
    }
})

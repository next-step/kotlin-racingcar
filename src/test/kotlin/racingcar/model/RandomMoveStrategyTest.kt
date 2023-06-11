package racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlin.random.Random

@DisplayName("랜덤 움직임 전략")
class RandomMoveStrategyTest : StringSpec({

    "랜덤 객체로 생성 가능" {
        shouldNotThrowAny { RandomMoveStrategy(Random(10)) }
    }

    "기본 인자로 생성 가능" {
        shouldNotThrowAny { RandomMoveStrategy() }
    }

    "랜덤 객체가 4이상인 경우에만 움직이는 상태 반환" {
        listOf(
            2 to MovingStatus.STOP,
            3 to MovingStatus.STOP,
            4 to MovingStatus.GO,
            5 to MovingStatus.GO
        ).forAll {
            // given
            val nextInt: Random = mockk<Random> { every { nextInt(any()) } returns it.first }
            // when, then
            RandomMoveStrategy(nextInt).movedStatus shouldBe it.second
        }
    }
})

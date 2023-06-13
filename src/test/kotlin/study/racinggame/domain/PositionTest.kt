package study.racinggame.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PositionTest : StringSpec({
    "위치 생성 시, 1보다 작은 값이 입력되면 오류가 발생 한다." {
        // given
        val value = -1

        // when & then
        shouldThrow<CanNotNegativePositionException> { Position(value) }
    }
})

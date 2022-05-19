package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PositionTest : StringSpec({
    "Position이 허용하는 최솟값(0)보다 작으면 Position 객체 생성시 예외를 발생시킨다." {
        // given
        val position = -1

        // when // then
        shouldThrowExactly<IllegalStateException> { Position(position) }
    }

    "Position을 +1 증가시킨다." {
        // given
        val position = Position(1)

        // when
        val actual = position.next()

        // then
        actual shouldBe Position(2)
    }
})

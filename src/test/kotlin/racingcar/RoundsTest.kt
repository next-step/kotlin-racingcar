package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class RoundsTest : FunSpec({
    test("객체를 생성할 때 값이 1보다 작으면 예외가 발생한다.") {
        // given
        val value = 0

        // when then
        val exception = shouldThrow<IllegalArgumentException> { Rounds(value) }
        exception.message shouldBe "경주는 1회이상 진행해야 합니다. Rounds.value: $value"
    }
})

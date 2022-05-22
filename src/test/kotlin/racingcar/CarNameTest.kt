package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class CarNameTest : FunSpec({
    context("객체를 생성할 때") {
        test("이름 값이 빈 값이면, 예외가 발생한다.") {
            // when then
            val exception = shouldThrow<IllegalArgumentException> { CarName("") }
            exception.message shouldBe "자동차의 이름은 빈 값이나 공백이 될 수 없습니다. name: "
        }

        test("이름 값이 공백이면, 예외가 발생한다.") {
            // when then
            val exception = shouldThrow<IllegalArgumentException> { CarName("  ") }
            exception.message shouldBe "자동차의 이름은 빈 값이나 공백이 될 수 없습니다. name:   "
        }
    }
})

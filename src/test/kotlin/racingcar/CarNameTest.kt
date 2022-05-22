package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class CarNameTest : FunSpec({
    context("of를 호출하여 객체를 생성할 때") {
        test("이름 값이 빈 값이면, 예외가 발생한다.") {
            // when then
            val exception = shouldThrow<IllegalArgumentException> { CarName.of("") }
            exception.message shouldBe "자동차의 이름은 빈 값이나 공백이 될 수 없습니다. name: "
        }

        test("이름 값이 공백이면, 예외가 발생한다.") {
            // when then
            val exception = shouldThrow<IllegalArgumentException> { CarName.of("  ") }
            exception.message shouldBe "자동차의 이름은 빈 값이나 공백이 될 수 없습니다. name:   "
        }

        test("이름 값의 전후에 공백이 존제하면 제거하고 객체를 생성한다.") {
            // given
            val value = "  charlie "

            // when
            val sut = CarName.of(value)

            // then
            sut.value shouldBe "charlie"
        }
    }
})

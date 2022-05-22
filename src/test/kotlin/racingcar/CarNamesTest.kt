package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class CarNamesTest : FunSpec({

    context("자동차 이름들의 문자열을 입력받아 객체를 생성할 때") {
        test("입력받은 문자열이 빈 값이면, 예외가 발생한다.") {
            // when then
            val exception = shouldThrow<IllegalArgumentException> { CarNames.of("") }
            exception.message shouldBe "차 이름들의 값은 빈 값이거나 공백일 수 없습니다. carNames: "
        }

        test("입력받은 문자열에 공백이 존재하면, 예외가 발생한다.") {
            // when then
            val exception = shouldThrow<IllegalArgumentException> { CarNames.of("  ") }
            exception.message shouldBe "차 이름들의 값은 빈 값이거나 공백일 수 없습니다. carNames:   "
        }
    }
})

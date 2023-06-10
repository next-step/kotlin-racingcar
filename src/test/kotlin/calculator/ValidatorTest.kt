package calculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ValidatorTest : StringSpec({

    "입력값이 null이면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Validator.validate(null)
        }.message shouldBe "입력값이 null입니다."
    }

    "입력값에 숫자나 사칙연산 이외의 값이 들어가면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Validator.validate("1 + 3 @ 4")
        }.message shouldBe "입력값에 올바르지 않은 문자가 포함되어 있습니다."
    }

    "입력값이 올바르면 예외가 발생하지 않는다." {
        shouldNotThrowAny {
            Validator.validate("1 + 3 * 4")
        }
    }
})

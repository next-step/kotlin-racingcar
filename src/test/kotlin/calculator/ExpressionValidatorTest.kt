package calculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData

internal class ExpressionValidatorTest : FunSpec({
    context("입력된 수식이 올 바른지 검증 한다.") {
        withData(
            "2 + 3 + 10 + 11",
            "2.2 + 3 - 10.3 + 11",
            "9 - 0 + 1 + 100.1",
            "9 - 0 + 1 + 100.1",
            "9 - 0 + 1 + 100.1",
        ) { data ->
            shouldNotThrowAny { ExpressionValidator.validate(data) }
        }
    }

    context("수식이 올 바른지 않으면 예외를 터 트린다.") {
        withData(
            "+ 2 + 3 + 10 + 11",
            "2.2 $ 3 $ 10.3 $ 11",
            "9 - 0 + 1 +",
            "9 -",
            "9 - 0 + 1 + 100.1 @",
        ) { data ->
            shouldThrow<IllegalArgumentException> { ExpressionValidator.validate(data) }
        }
    }
})

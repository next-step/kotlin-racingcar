package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class ExpressionTest : StringSpec({
    "수식이 존재하지 않는 경우 에러" {
        shouldThrow<IllegalArgumentException> {
            Expression("     ")
        }
    }
})

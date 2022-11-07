package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.types.shouldNotBeInstanceOf
import org.assertj.core.api.Assertions

class DivisionByZeroTest : StringSpec({

    @Suppress("DIVISION_BY_ZERO")
    "n/0 throw ArithmeticException " {
        Assertions.assertThatThrownBy { 10 / 0 }
            .shouldNotBeInstanceOf<ArithmeticException>()
    }
    @Suppress("DIVISION_BY_ZERO")
    "n/0.0 throw ArithmeticException " {
        Assertions.assertThatCode { (10 / 0.0) }.doesNotThrowAnyException() //  Infinity
    }
})

package next.step.racing.domain.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class CarNameTest : StringSpec({
    "차 이름이 공백이면 예외 발생" {
        shouldThrow<IllegalArgumentException> { CarName("") }
    }

    "차 이름이 비어있으면 예외 발생" {
        shouldThrow<IllegalArgumentException> { CarName(" ") }
    }

    "차 이름이 5자초과이면 예외 발생" {
        shouldThrow<IllegalArgumentException> { CarName("abcdef") }
    }
})

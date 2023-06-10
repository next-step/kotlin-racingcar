package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class CarNameKoTest : StringSpec({
    "자동차 이름이 5자리를 초과하면 에러" {
        shouldThrow<IllegalArgumentException> {
            Car("AAAAAA")
        }
    }
})

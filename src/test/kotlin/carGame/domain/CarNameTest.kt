package carGame.domain

import carGame.test.FakeGenerator
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class CarNameTest : StringSpec({
    "자동차 이름이 5자를 초과하면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            FakeGenerator.generateCarName(size = 6)
        }
    }

    "자동차 이름이 5자이하면 예외를 던지지 않는다." {
        shouldNotThrowAny {
            FakeGenerator.generateCarName(size = 5)
            FakeGenerator.generateCarName(size = 4)
        }
    }
})

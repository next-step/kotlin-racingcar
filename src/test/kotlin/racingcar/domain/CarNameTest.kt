package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarNameTest : StringSpec({

    "Car 이름은 5자이면 정상적으로 생성된다." {
        val carName = CarName("test1")
        carName.name shouldBe "test1"
    }

    "Car 이름이 5자 초과하면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            CarName("test1234")
        }
    }
})

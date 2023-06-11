package step3.racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class CarsTest : StringSpec({
    "Cars는 Car list가 비어있을 때, 예외를 던진다." {
        val emptyCars = emptyList<Car>()

        shouldThrow<IllegalArgumentException> {
            Cars(emptyCars)
        }
    }
})

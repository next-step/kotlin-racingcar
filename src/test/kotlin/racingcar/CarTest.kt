package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    "전진하는 조건을 만족하면 자동차는 전진한다. " {
        val range = listOf(4, 5, 6, 7, 8, 9)
        range.forAll {
            val carName = "정명구"
            val car = Car(carName)

            car.move(it)

            car.moveCount shouldBe 1
        }
    }

    "전진하는 조건을 만족하지 못하면 자동차는 전진하지 않는다" {
        val range = listOf(1, 2, 3)
        range.forAll {
            val carName = "정명구"
            val car = Car(carName)

            car.move(it)

            car.moveCount shouldBe 0
        }
    }

    "이름의 길이가 지정한 범위 보다 크면 예외가 발생한다." {
        val carName = "정명구정명구"

        shouldThrow<IllegalArgumentException> {
            Car(carName)
        }
    }
})

package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "위치를 가진다" {
        forAll(
            row(0),
            row(1),
            row(5),
            row(10),
            row(100),
        ) { value ->
            val car = Car(CarName("name"), CarPosition(value))
            car.getPositionValue() shouldBe value
        }
    }

    "전진할 수 있다." {
        forAll(
            row(0, 1),
            row(1, 2),
            row(5, 6),
            row(10, 11),
            row(100, 101),
        ) { beforeValue, afterValue ->
            val car = Car(CarName("name"), CarPosition(beforeValue))
            car.move()
            car.getPositionValue() shouldBe afterValue
        }
    }
})

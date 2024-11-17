package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racingcar.domain.vo.CarName
import racingcar.domain.vo.CarPosition

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
            car.getUnmodifiablePosition() shouldBe CarPosition(value)
        }
    }

    "전전 또는 정지할 수 있다." {
        forAll(
            row(0, 4, 1),
            row(1, 0, 1),
            row(5, 3, 5),
            row(10, 9, 11),
            row(100, 7, 101),
        ) { beforeValue, number, afterValue ->
            val car = Car(CarName("name"), CarPosition(beforeValue))
            car.moveOrStand { number }
            car.getUnmodifiablePosition() shouldBe CarPosition(afterValue)
        }
    }
})

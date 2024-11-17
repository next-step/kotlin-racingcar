package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    "4 이상의 숫자를 인자로 받으면 1칸 이동한 Car 객체를 반환한다." {
        val car = Car(1)
        car.move(4)
        car.moveCount shouldBe 2
    }

    "4 미만의 숫자를 인자로 받으면 1칸 이동한 Car 객체를 반환한다." {
        val car = Car(1)
        car.move(3)
        car.moveCount shouldBe 1
    }
})

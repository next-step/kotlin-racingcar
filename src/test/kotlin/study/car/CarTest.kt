package study.car

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest: StringSpec({
    "자동차를 생성할수 있다" {
        shouldNotThrow<Throwable> { Car() }
    }

    "자동차를 생성하면 위치가 0으로 초기회 된다" {
        val car = Car()

        car.position shouldBe 0
    }

    "자동차가 전진하는 경우 Position 값을 증가 시킨다." {
        val car = Car()
        car.move()

        car.position shouldBe 1
    }

    "자동차가 전진하지 않으면 Position 값이 증가하지 않는다." {
        val car = Car()
        car.move()

        car.position shouldBe 0
    }
})

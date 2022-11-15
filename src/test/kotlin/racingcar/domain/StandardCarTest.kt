package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StandardCarTest : StringSpec({
    "입력 값이 4이상이면 자동차가 전진한다" {
        val expected = Position(1)

        IntRange(4, 9).toList()
            .forAll {
                val car = StandardCar(name = Name("hi"))

                car.move(it)

                car.position shouldBe expected
            }
    }

    "입력 값이 4미만이면 자동차는 멈춘다" {
        IntRange(0, 3).toList()
            .forAll {
                val car = StandardCar(name = Name("hi"))

                car.move(it)

                car.position shouldBe Position.ZERO
            }
    }

    "기본 생성자로 자동차를 생성하면 초기 위치는 0이다" {
        StandardCar(name = Name("hi")).position shouldBe Position.ZERO
    }
})

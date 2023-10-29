package racingcar.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarsTest : StringSpec({

    "자동차 갯수를 입력 하면 입력한 갯수 만큼의 자동차 객체가 생성 된다" {
        val cars = Cars.createCar(3)

        cars.cars.size shouldBe 3
    }

    "4 이상인 경우 자동차 객체가 이동 한다" {
        val cars = Cars.createCar(1)
        val result = cars.move(MoveStrategy(InputNumberGenerator(7)))

        result.cars[0].position shouldBe 1
    }

    "4 미만인 경우 자동차 객체가 이동하지 않는다" {
        val cars = Cars.createCar(1)
        val result = cars.move(MoveStrategy(InputNumberGenerator(1)))

        result.cars[0].position shouldBe 0
    }
})

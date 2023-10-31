package racingcar.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarsTest : StringSpec({

    "자동차 이름을 쉼표(,)를 기준으로 생성한다" {
        val cars = Cars.from("pobi,crong,honux")

        cars.cars.size shouldBe 3
    }

    "4 이상인 경우 자동차 객체가 이동 한다" {
        val cars = Cars.from("pobi,crong,honux")
        val result = cars.move(SuccessMovement())

        result[0].position shouldBe 1
    }

    "4 미만인 경우 자동차 객체가 이동하지 않는다" {
        val cars = Cars.from("pobi,crong,honux")
        val result = cars.move(FailMovement())

        result[0].position shouldBe 0
    }
})

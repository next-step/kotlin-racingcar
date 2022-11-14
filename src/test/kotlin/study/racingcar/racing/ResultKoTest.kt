package study.racingcar.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racingcar.car.Car

internal class ResultKoTest : StringSpec({
    "Car를 통해 생성" {
        val car = Car("자동차")
        val result = Result(car)

        result.name shouldBe car.name
        result.location shouldBe car.currentLocation
    }

    "기본 인자" {
        val result = Result("자동차", 1)

        result.name shouldBe "자동차"
        result.location shouldBe 1
    }
})

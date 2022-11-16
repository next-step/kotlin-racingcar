package study.racingcar.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racingcar.car.Car

internal class RecordKoTest : StringSpec({
    "Car만을 통해서 Record를 생성할 수 있따" {
        val car = Car("자동차")
        val record = Record(car)

        record.name shouldBe car.name
        record.location shouldBe car.currentLocation
    }

    "기본 생성자를 통해서 Record를 생성할 수 있다" {
        val record = Record("자동차", 1)

        record.name shouldBe "자동차"
        record.location shouldBe 1
    }
})

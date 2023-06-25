package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RacingCarsTest : StringSpec({

    "random 결과가 4 미만일 경우 전진을 하지 못한다." {
        val racingCar = RacingCar(1, "tony")
        val result = racingCar.carProgress { 3 }
        result.progress shouldBe 1
    }

    "random 결과가 4 이상일 경우 전진을 한다." {
        val racingCar = RacingCar(1, "tony")
        val result = racingCar.carProgress { 5 }
        result.progress shouldBe 2
    }

    "driver는 5자 이하여아 한다." {
        shouldThrow<IllegalArgumentException> {
            RacingCar(driver = "tonytony")
        }.message shouldBe "문자열의 길이가 6자 이상인 항목이 있습니다."
    }

    "getWinners는 progress가 가장 높은 driver를 반환한다." {
        val racingCars = RacingCars(
            listOf(
                RacingCar(progress = 3, driver = "tony"),
                RacingCar(progress = 2, driver = "dana"),
                RacingCar(progress = 1, driver = "bako"),
            )
        )
        racingCars.getWinners() shouldBe listOf("tony")
    }

    "getWinners는 progress가 가장 높은 동점의 driver를 반환한다." {
        val racingCars = RacingCars(
            listOf(
                RacingCar(progress = 3, driver = "tony"),
                RacingCar(progress = 3, driver = "dana"),
                RacingCar(progress = 1, driver = "bako"),
            )
        )
        racingCars.getWinners() shouldBe listOf("tony", "dana")
    }
})

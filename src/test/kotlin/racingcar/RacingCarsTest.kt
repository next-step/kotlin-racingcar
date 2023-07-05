package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain

class RacingCarsTest : StringSpec({
    "RacingCars에 자동차가 추가할수 있다." {
        val actual = RacingCar("pavlo")
        val racingCars = RacingCars.of(listOf(actual))
        racingCars.getCars() shouldContain actual
    }
})

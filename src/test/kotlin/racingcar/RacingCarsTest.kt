package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain

class RacingCarsTest : StringSpec({
    "RacingCars에 자동차가 추가할수 있다." {
        val racingCars = RacingCars()
        val actual = RacingCar("pavlo")
        racingCars.addCars(listOf(actual))
        racingCars.cars shouldContain actual
    }
})

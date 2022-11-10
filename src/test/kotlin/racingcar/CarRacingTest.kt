package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec

class CarRacingTest : StringSpec({
    "참여 인원이 존재하면 자동차 경주를 생성할 수 있다" {
        shouldNotThrowAny { CarRacing(carRacers = listOf(CarRacer(StandardCar(), RandomCarControl()))) }
    }

    "참여 인원이 없으면 자동차 경주를 생성할 수 없다" {
        shouldThrowAny { CarRacing(carRacers = emptyList()) }
    }
})

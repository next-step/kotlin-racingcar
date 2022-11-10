package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class CarRacingTest : StringSpec({
    "참여 인원이 존재하면 자동차 경주를 생성할 수 있다" {
        shouldNotThrowAny { CarRacing(carRacers = listOf(CarRacer(StandardCar(), RandomCarControl()))) }
    }

    "참여 인원이 없으면 자동차 경주를 생성할 수 없다" {
        shouldThrowAny { CarRacing(carRacers = emptyList()) }
    }

    "종료된 경주는 다시 시작할 수 없다" {
        val carRacing = CarRacing(
            carRacers = listOf(CarRacer(StandardCar(), RandomCarControl())),
            status = Status.FINISHED
        )

        shouldThrowAny { carRacing.start() }
    }

    "시도할 횟수가 0이하면 경주를 시작할 수 없다" {
        listOf(0, -1, -2)
            .forAll {
                val carRacing = CarRacing(carRacers = listOf(CarRacer(StandardCar(), RandomCarControl())))

                shouldThrowAny { carRacing.start(it) }
            }
    }

    "시도할 횟수가 1이상이고 준비상태면 경주를 시작할 수 있다" {
        listOf(1, 2, 3)
            .forAll {
                val carRacing = CarRacing(carRacers = listOf(CarRacer(StandardCar(), RandomCarControl())))

                shouldNotThrowAny { carRacing.start(it) }
            }
    }
})

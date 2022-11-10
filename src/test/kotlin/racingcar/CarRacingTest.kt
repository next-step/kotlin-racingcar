package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

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

    "종료된 경주가 아니면 결과를 확인할 수 없다" {
        val carRacing = CarRacing(carRacers = listOf(CarRacer(StandardCar(), RandomCarControl())))

        shouldThrowAny { carRacing.result() }
    }

    "종료된 경주면 결과를 확인할 수 있다" {
        val carRacing = CarRacing(
            carRacers = listOf(CarRacer(StandardCar(), RandomCarControl())),
            status = Status.FINISHED
        )

        shouldNotThrowAny { carRacing.result() }
    }

    "자동차 경주 결과가 정상적으로 반환된다" {
        val forwardCarControl = object : CarControl {
            override fun power(): Int = 4
        }

        val stopCarControl = object : CarControl {
            override fun power(): Int = 3
        }

        val carRacing = CarRacing(
            carRacers = listOf(
                CarRacer(StandardCar(), forwardCarControl),
                CarRacer(StandardCar(), stopCarControl)
            ),
            status = Status.READY
        )

        carRacing.start(2)

        val result = carRacing.result()

        result.size shouldBe 2
        result[0]!![0].position shouldBe Position(1)
        result[0]!![1].position shouldBe Position.ZERO
        result[1]!![0].position shouldBe Position(2)
        result[1]!![1].position shouldBe Position.ZERO
    }
})

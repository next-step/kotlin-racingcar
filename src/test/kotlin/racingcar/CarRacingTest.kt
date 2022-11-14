package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CarRacingTest : StringSpec({
    "참여 인원이 존재하면 자동차 경주를 생성할 수 있다" {
        shouldNotThrowAny {
            CarRacing(
                carRacers = listOf(
                    CarRacer(
                        StandardCar(name = Name("hi")),
                        RandomCarControl()
                    )
                )
            )
        }
    }

    "참여 인원이 없으면 자동차 경주를 생성할 수 없다" {
        shouldThrowAny { CarRacing(carRacers = emptyList()) }
    }

    "시도할 횟수가 0이하면 경주를 시작할 수 없다" {
        listOf(0, -1, -2)
            .forAll {
                shouldThrowAny {
                    CarRacing(
                        carRacers = listOf(CarRacer(StandardCar(name = Name("hi")), RandomCarControl())),
                        count = it
                    )
                }
            }
    }

    "시도할 횟수가 1이상이고 준비상태면 경주를 시작할 수 있다" {
        listOf(1, 2, 3)
            .forAll {
                shouldNotThrowAny {
                    CarRacing(
                        carRacers = listOf(CarRacer(StandardCar(name = Name("hi")), RandomCarControl())),
                        count = it
                    )
                }
            }
    }

    "자동차 경주 결과가 정상적으로 반환된다" {
        val carRacing = CarRacing(
            carRacers = listOf(
                CarRacer(StandardCar(name = Name("hi")), ForwardCarControl),
                CarRacer(StandardCar(name = Name("bye")), StopCarControl)
            ),
            count = 2
        )

        val result = carRacing.race()

        val map = result.toMap()

        map.size shouldBe 2
        map[0]!![0].position shouldBe Position(1)
        map[0]!![1].position shouldBe Position.ZERO
        map[1]!![0].position shouldBe Position(2)
        map[1]!![1].position shouldBe Position.ZERO
    }
})

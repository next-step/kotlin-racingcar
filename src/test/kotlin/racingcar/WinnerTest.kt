package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinnerTest : StringSpec({
    "위치 가장 큰 자동차가 우승한다" {
        val carRacing = CarRacing(
            carRacers = listOf(
                CarRacer(StandardCar(name = Name("A")), ForwardCarControl),
                CarRacer(StandardCar(name = Name("B")), StopCarControl),
                CarRacer(StandardCar(name = Name("C")), ForwardCarControl),
            ),
            count = 3
        )

        Winner(carRacing).names() shouldBe listOf(Name("A"), Name("C"))
    }
})

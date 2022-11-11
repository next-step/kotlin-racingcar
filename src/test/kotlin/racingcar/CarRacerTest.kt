package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThan

class CarRacerTest : StringSpec({
    "4를 입력하여 자동차를 운전하면 전진한다" {
        val carRacer = CarRacer(StandardCar(), InputCarControl(4))

        val previous = carRacer.position

        carRacer.drive()

        carRacer.position.value shouldBeGreaterThan previous.value
    }
})

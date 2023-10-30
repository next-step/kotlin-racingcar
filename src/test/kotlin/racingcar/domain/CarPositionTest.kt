package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarPositionTest : StringSpec({
    "차의 위치를 1 증가시킨다" {
        val carPosition = CarPosition(1)
        carPosition.add() shouldBe CarPosition(2)
    }
})

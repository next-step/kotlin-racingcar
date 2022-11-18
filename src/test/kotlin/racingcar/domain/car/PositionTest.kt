package racingcar.domain.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

internal class PositionTest : StringSpec({
    "위치 값이 같으면 두 위치는 동등성이 보장된다" {
        val first = Position()
        val second = Position()
        first shouldBe second
    }

    "위치 값이 다르면 두 위치는 다르게 표현된다" {
        val position = Position()
        val movedPosition = position.forward()
        position shouldNotBe movedPosition
    }
})

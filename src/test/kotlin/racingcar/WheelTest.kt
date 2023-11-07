package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class WheelTest : FunSpec({
    context("바퀴에 4 이상의 힘을 가하면 1을 반환한다") {
        withData(listOf(4, 5, 6, 7, 8, 9)) { power ->
            val wheel = Wheel()
            wheel.nextLocation(power) shouldBe 1
        }
    }

    context("바퀴에 4 미만의 힘을 가하면 0을 반환한다") {
        withData(listOf(0, 1, 2, 3)) { power ->
            val wheel = Wheel()
            wheel.nextLocation(power) shouldBe 0
        }
    }

    context("바퀴에 0 미만, 9 초과의 힘을 가하면 예외가 발생한다") {
        withData(listOf(-1, -2, 10, 11)) { power ->
            val wheel = Wheel()
            shouldThrow<IllegalArgumentException> { wheel.nextLocation(power) }
        }
    }
})

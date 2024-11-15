package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class VehicleTest : StringSpec({
    "자동차의 시작 위치는 0 미만이라면 IllegalArgumentException이 발생한다" {
        val exception =
            shouldThrow<IllegalArgumentException> {
                Car.from(sequence = 0, position = -1)
            }

        exception.message shouldBe "시작 위치는 0 이상이어야 합니다."
    }

    "자동차는 4 이상의 숫자가 주어지면 전진한다" {
        val sut = Car.from(sequence = 0, position = 0)

        sut.move(4)

        sut.getPosition() shouldBe 1
    }

    "자동차는 3 이하의 숫자가 주어지면 전진하지 않는다" {
        val sut = Car.from(sequence = 0, position = 0)

        sut.move(3)

        sut.getPosition() shouldBe 0
    }
})

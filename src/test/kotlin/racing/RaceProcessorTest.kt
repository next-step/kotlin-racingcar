package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class RaceProcessorTest : StringSpec({
    val countGenerator = RandomCountGenerator()
    val carFactory = CarFactory
    val sut = RaceProcessor(carFactory, countGenerator)

    "입력받은 차의 개수와 라운드만큼 레이스를 진행하고 결과를 반환한다" {
        val carQuantity = 3
        val round = 5

        val actual = sut.execute(carQuantity, round)

        actual.shouldNotBeNull()
        actual.getCarCount() shouldBe carQuantity
        actual.getRoundCount() shouldBe round
    }

    "차의 개수가 0 이하일 경우 IllegalArgumentException을 던진다" {
        val carQuantity = 0
        val round = 5

        shouldThrow<IllegalArgumentException> {
            sut.execute(carQuantity, round)
        }
    }

    "라운드가 0 이하일 경우 IllegalArgumentException을 던진다" {
        val carQuantity = 3
        val round = 0

        shouldThrow<IllegalArgumentException> {
            sut.execute(carQuantity, round)
        }
    }
})

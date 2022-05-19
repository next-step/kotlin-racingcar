package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : DescribeSpec({
    describe("RacingGame") {
        it("이름 리스트를 받아 driver 리스트를 만든다.") {
            val drivers = listOf<Driver>(
                Driver("pico", Car()),
                Driver("papi", Car()),
                Driver("inf", Car())
            )

            val game = RacingGame(drivers, 4)

            game.drivers.map { it.name } shouldBe listOf("pico", "papi", "inf")
        }

        it("자동차는 2대 이상이여야 한다.") {
            val drivers = listOf<Driver>(
                Driver("paco", Car()),
            )
            val exception = shouldThrow<RuntimeException> { RacingGame(drivers, 4) }

            exception.message shouldBe "자동차는 최소 2대 이상 입력해주세요"
        }

        it("우승자를 반환한다.") {
            val drivers = listOf<Driver>(
                Driver("paco", Car(1)),
                Driver("papi", Car(2)),
                Driver("copi", Car(3)),
            )
            val game = RacingGame(drivers, 4)

            game.getWinner() shouldBe listOf("copi")
        }

        it("우승자는 2명 이상일 수 있다.") {
            val drivers = listOf<Driver>(
                Driver("paco", Car(1)),
                Driver("papi", Car(3)),
                Driver("copi", Car(3)),
            )
            val game = RacingGame(drivers, 4)

            game.getWinner() shouldBe listOf("papi", "copi")
        }
    }
})

package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : DescribeSpec({
    describe("RacingGame") {
        it("이름 리스트를 받아 driver 리스트를 만든다.") {
            val game = RacingGame(listOf("pico", "papi", "inf"), 4)

            game.drivers.map { it.name } shouldBe listOf("pico", "papi", "inf")
        }

        it("자동차는 2대 이상이여야 한다.") {
            val exception = shouldThrow<RuntimeException> { RacingGame(listOf("pico"), 4) }

            exception.message shouldBe "자동차는 최소 2대 이상 입력해주세요"
        }
    }
})

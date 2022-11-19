package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class GameJudgmentTest : StringSpec({
    "가장 멀리 이동한 자동차가 우승한다." {
        val cars = listOf(
            Car("a", 5),
            Car("b", 10)
        )
        val winners = GameJudgment(cars).getWinners()

        winners.first() shouldBe "b"
    }

    "우승자는 여러명일 수 있다." {
        val cars = listOf(
            Car("a", 10),
            Car("b", 10),
            Car("c", 1)
        )
        val winners = GameJudgment(cars).getWinners()

        winners.size shouldBe 2
    }
})

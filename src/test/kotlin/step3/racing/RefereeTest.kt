package step3.racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class RefereeTest : DescribeSpec({
    describe("findWinnerNames") {
        it("1등이 한명일 경우 1등의 이름을 반환한다.") {
            val winner = Car("a").apply { run(10) }
            val racers = listOf(winner, Car("b"), Car("c"))

            val result = Referee.findWinnerNames(racers)

            result.size shouldBe 1
            result[0] shouldBe winner.name
        }

        it("1등이 두명일 경우 1등의 이름을 반환한다.") {
            val winner1 = Car("a").apply { run(10) }
            val winner2 = Car("d").apply { run(10) }
            val racers = listOf(winner1, Car("b"), Car("c"), winner2)

            val result = Referee.findWinnerNames(racers)

            result.size shouldBe 2
            result shouldContain winner1.name
            result shouldContain winner2.name
        }
    }
})

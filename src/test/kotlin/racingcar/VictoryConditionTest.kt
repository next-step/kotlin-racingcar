package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class VictoryConditionTest : BehaviorSpec({

    given("자동차들[aaa:4, bbb:6, ccc:2]와 승리조건으로 Longest 주어진 상태") {
        val aaa = Car("aaa", 4)
        val bbb = Car("bbb", 6)
        val ccc = Car("ccc", 2)
        val cars = listOf(aaa, bbb, ccc)

        val condition = VictoryCondition.Longest
        `when`("우승자를 발표하면") {
            val winner = condition.announceWinner(cars)
            then("bbb의 단독 우승이다") {
                winner shouldBe listOf(bbb)
                winner.size shouldBe 1
            }
        }
    }

    given("자동차들[aaa:6, bbb:6, ccc:2]와 승리조건으로 Longest 주어진 상태") {
        val aaa = Car("aaa", 6)
        val bbb = Car("bbb", 6)
        val ccc = Car("ccc", 2)
        val cars = listOf(aaa, bbb, ccc)

        val condition = VictoryCondition.Longest
        `when`("우승자를 발표하면") {
            val winner = condition.announceWinner(cars)
            then("aaa, bbb의 공동 우승이다") {
                winner shouldBe listOf(aaa, bbb)
                winner.size shouldBe 2
            }
        }
    }

    given("자동차들[aaa:4, bbb:6, ccc:2]와 승리조건으로 Shortest 주어진 상태") {
        val aaa = Car("aaa", 4)
        val bbb = Car("bbb", 6)
        val ccc = Car("ccc", 2)
        val cars = listOf(aaa, bbb, ccc)

        val condition = VictoryCondition.Shortest
        `when`("우승자를 발표하면") {
            val winner = condition.announceWinner(cars)
            then("ccc 단독 우승이다") {
                winner shouldBe listOf(ccc)
                winner.size shouldBe 1
            }
        }
    }

    given("자동차들[aaa:2, bbb:6, ccc:2]와 승리조건으로 Shortest 주어진 상태") {
        val aaa = Car("aaa", 2)
        val bbb = Car("bbb", 6)
        val ccc = Car("ccc", 2)
        val cars = listOf(aaa, bbb, ccc)

        val condition = VictoryCondition.Shortest
        `when`("우승자를 발표하면") {
            val winner = condition.announceWinner(cars)
            then("aaa와 ccc의 공동 우승이다") {
                winner shouldBe listOf(aaa, ccc)
                winner.size shouldBe 2
            }
        }
    }
})

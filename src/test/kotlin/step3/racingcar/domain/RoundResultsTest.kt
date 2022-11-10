package step3.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

internal class RoundResultsTest : BehaviorSpec({
    given("RoundResults : 각 라운드의 경주 결과 누적") {
        var round = 0
        val given = RoundResults()
        `when`("첫번째 라운드에 4가 주어지면") {
            val matchResult = MoveStatus.match(4)
            val roundResult = RoundResult(++round, matchResult)
            given.accumulate(roundResult)
            then("전진 상태가 누적 된다.") {
                extractMoveStatues(given).shouldContainExactly(MoveStatus.ACCELERATION)
            }
        }
        `when`("두번째 라운드에 3이 주어지면") {
            val matchResult = MoveStatus.match(3)
            val roundResult = RoundResult(++round, matchResult)
            given.accumulate(roundResult)
            then("멈춤 상태가 누적 된다.") {
                extractMoveStatues(given).shouldContainExactly(MoveStatus.ACCELERATION, MoveStatus.BREAK)
            }
        }
        `when`("세번째 라운드에 6이 주어지면") {
            val matchResult = MoveStatus.match(6)
            val roundResult = RoundResult(++round, matchResult)
            given.accumulate(roundResult)
            then("전진 상태가 누적 된다.") {
                extractMoveStatues(given).shouldContainExactly(MoveStatus.ACCELERATION, MoveStatus.BREAK, MoveStatus.ACCELERATION)
            }
        }
        `when`("레이스가 종료되면") {
            then("진행한 라운드 수만큼 결과가 누적된다.") {
                given.size() shouldBe round
            }
        }
    }
})

fun extractMoveStatues(given: RoundResults) =
    given.elements()
        .map { it.moveStatus }
        .toList()

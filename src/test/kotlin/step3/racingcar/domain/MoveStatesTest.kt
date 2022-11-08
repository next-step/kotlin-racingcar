package step3.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

internal class MoveStatesTest : BehaviorSpec({
    given("MoveStates : 주어진 숫자에 따른 전진/멈춤 상태 누적") {
        val given = MoveStates()
        `when`("첫번째 라운드에 4가 주어지면") {
            given.progressRound(4)
            then("전진 상태가 누적 된다.") {
                given.getElements().shouldContainExactly(MoveStatus.ACCELERATION)
            }
        }
        `when`("두번째 라운드에 3이 주어지면") {
            given.progressRound(3)
            then("멈춤 상태가 누적 된다.") {
                given.getElements().shouldContainExactly(MoveStatus.ACCELERATION, MoveStatus.BREAK)
            }
        }
        `when`("세번째 라운드에 6이 주어지면") {
            given.progressRound(6)
            then("전진 상태가 누적 된다.") {
                given.getElements().shouldContainExactly(MoveStatus.ACCELERATION, MoveStatus.BREAK, MoveStatus.ACCELERATION)
            }
        }
        `when`("레이스가 종료된 후") {
            then("누적된 전진 횟수는 2이다.") {
                given.calculateMoveCount() shouldBe 2
            }
        }
    }
})

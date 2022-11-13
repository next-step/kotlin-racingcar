package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class MovingJudgeRuleTest : BehaviorSpec({

    given("무작위로 선택한 숫자가") {

        `when`("4 이상이면") {
            val randNumber = 4
            val strategy = MovingJudgeRule.judge(randNumber)

            then("ADVANCE_RULE을 반환한다.") {
                strategy shouldBe MovingJudgeRule.ADVANCED_RULE
            }
        }

        `when`("4 미만이면") {
            val randNumber = 3
            val strategy = MovingJudgeRule.judge(randNumber)

            then("STOP_RULE을 반한한다.") {
                strategy shouldBe MovingJudgeRule.STOP_RULE
            }
        }
    }
})

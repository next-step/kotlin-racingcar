package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.dto.CarInfo
import racingcar.dto.Record

internal class RecordTest : BehaviorSpec({
    Given("차 기록들이 주어지고, ") {
        val givenForFirstTest = Record(
            listOf(
                CarInfo(name = "car1", position = 1),
                CarInfo(name = "car2", position = 2),
                CarInfo(name = "car3", position = 3)
            )
        )
        When("선두 주자를 출력하는 메서드를 사용하면, ") {
            val frontRunner = givenForFirstTest.findFrontRunner()
            Then("정상 동작한다.") {
                frontRunner shouldHaveSize 1
                frontRunner.all { it.position == 3 } shouldBe true
            }
        }

        val givenForSecondTest = Record(
            listOf(
                CarInfo(name = "car1", position = 1),
                CarInfo(name = "car2", position = 3),
                CarInfo(name = "car3", position = 3)
            )
        )
        When("선두 주자를 출력하는 메서드를 사용하면, ") {
            val frontRunner = givenForSecondTest.findFrontRunner()
            Then("정상 동작한다.") {
                frontRunner shouldHaveSize 2
                frontRunner.all { it.position == 3 } shouldBe true
            }
        }
    }
})

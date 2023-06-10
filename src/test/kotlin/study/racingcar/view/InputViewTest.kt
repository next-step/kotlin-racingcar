package study.racingcar.view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class InputViewTest : BehaviorSpec({

    val systemIn = System.`in`
    val systemOut = System.out
    val outputStream = ByteArrayOutputStream()

    Given("가상으로 입력을 받도록 할 때") {
        System.setOut(PrintStream(outputStream))
        val input = "pobi,crong,honux\n5\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()

        When("차량 이름과 시도 횟수를 입력받는 경우") {
            val carNames = inputView.getCarNames()
            val attempts = inputView.getNumberOfAttempts()

            Then("반환된 차량 이름과 시도 횟수는 가상의 입력과 일치해야 한다.") {
                carNames shouldBe listOf("pobi", "crong", "honux")
                attempts shouldBe 5
                System.setIn(systemIn)
                System.setOut(systemOut)
            }
        }
    }
})

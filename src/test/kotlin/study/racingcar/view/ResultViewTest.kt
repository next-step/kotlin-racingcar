package study.racingcar.view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import study.racingcar.race.CarState
import study.racingcar.race.RaceResult
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ResultViewTest : BehaviorSpec({

    val output = System.out
    val outputSteam = ByteArrayOutputStream()

    Given("ResultView가 경주 결과를 출력해야 하는 경우") {
        System.setOut(PrintStream(outputSteam))
        val raceResults = listOf(
            RaceResult(
                listOf(
                    CarState("pobi", 3),
                    CarState("crong", 2),
                    CarState("honux", 4)
                )
            )
        )
        val resultView = ResultView() // ResultView 인스턴스 생성

        When("경주 결과를 ResultView에 전달하면") {
            resultView.printRaceResults(raceResults) // 인스턴스 메소드를 사용

            Then("출력된 내용이 경주 결과와 일치해야 한다.") {
                val expectedOutput = "\n실행 결과\n" +
                    "pobi : ---\n" +
                    "crong : --\n" +
                    "honux : ----\n\n"
                outputSteam.toString().trim() shouldBe expectedOutput.trim()
                System.setOut(output)
            }
        }
    }
})

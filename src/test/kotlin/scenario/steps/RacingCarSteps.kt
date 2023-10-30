package scenario.steps

import game.RacingCarGame
import game.domain.FixedMoveConditionGenerator
import game.domain.MoveConditionGenerator
import game.view.ConsoleInputHandler
import game.view.UserInputHandler
import game.view.UserMessageDisplay
import game.view.UserOutputHandler
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions

class RacingCarSteps {
    private var inputCarName1: String = ""
    private var inputCarName2: String = ""
    private var inputCarName3: String = ""
    private var retryCount: Int = 0
    private var moveConditionGenerator: MoveConditionGenerator = FixedMoveConditionGenerator(0)
    private var userInputHandler: UserInputHandler = ConsoleInputHandler()
    private var userOutputHandler: UserOutputHandler = UserMessageDisplay()
    private var result: String = ""
    private var advanceCount: Int = 0

    @Given("자동차 이름 {string},{string},{string}를 입력하고")
    fun `자동차 이름 {CarName1},{CarName2},{CarName3}를 입력하고`(
        inputCarName1: String,
        inputCarName2: String,
        inputCarName3: String
    ) {
        this.inputCarName1 = inputCarName1
        this.inputCarName2 = inputCarName2
        this.inputCarName3 = inputCarName3
    }

    @And("시도할 횟수 {int}회를 입력하고")
    fun `시도할 횟수 {회수}회를 입력한다고 가정한다`(retryCount: Int) {
        this.retryCount = retryCount
        userInputHandler = object : UserInputHandler {
            override fun askForCarNames(): String {
                return "$inputCarName1,$inputCarName2,$inputCarName3"
            }

            override fun askForRetryCount(): String {
                return retryCount.toString()
            }
        }
    }

    @And("모든 자동차가 전진조건이 고정 {int}라고 가정하고")
    fun `모든 자동차가 전진조건이 고정 {조건}라고 가정하고`(moveCondition: Int) {
        moveConditionGenerator = FixedMoveConditionGenerator(moveCondition)
    }

    @And("우승자를 저장한다면")
    fun `우승자를 저장한다면`() {
        userOutputHandler = UserOutputHandler { history ->
            history.rounds.lastIndex.let { it ->
                advanceCount = history.rounds[it].maxOf { it.position }
            }
            result = history.winners.joinToString()
        }
    }

    @And("{string}는 전진조건이 {int}이고 {string}는 전진조건이 {int}이며 {string}는 전진조건이 {int}라고 가정하고")
    fun `{CarName1}는 전진조건이 {조건1}이고 {CarName2}는 전진조건이 {조건2}이며 {CarName3}는 전진조건이 {조건3}라고 가정하고`(
        inputCarName1: String,
        condition1: Int,
        inputCarName2: String,
        condition2: Int,
        inputCarName3: String,
        condition3: Int
    ) {
        class CyclingMoveConditionGenerator : MoveConditionGenerator {
            private val conditions = listOf(condition1, condition2, condition3)
            private var currentIndex = 0

            override fun generate(): Int {
                val condition = conditions[currentIndex]
                currentIndex = (currentIndex + 1) % conditions.size
                return condition
            }
        }
        moveConditionGenerator = CyclingMoveConditionGenerator()
    }

    @When("게임을 진행한다")
    fun `게임을 진행한다`() {
        RacingCarGame(userInputHandler, userOutputHandler, moveConditionGenerator).let {
            it.start()
        }
    }

    @Then("모든 자동차는 우승자이며 {int}만큼 전진한다")
    fun `모든 자동차는 우승자이며 {이동거리}만큼 전진한다`(retryCount: Int) {
        Assertions.assertAll(
            { assertThat(result).contains(inputCarName1, inputCarName2, inputCarName3) },
            { assertThat(advanceCount).isEqualTo(retryCount) }
        )
    }

    @Then("우승자는 {string}이며 {int}만큼 전진한다")
    fun `우승자는 {우승자}"이며 {이동거리}만큼 전진한다`(winner: String, retryCount: Int) {
        Assertions.assertAll(
            { assertThat(result).contains(winner.split(",")) },
            { assertThat(advanceCount).isEqualTo(retryCount) }
        )
    }
}

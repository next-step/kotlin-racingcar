package scenario.steps

import game.Car
import game.ConsoleInputHandler
import game.FixedMoveConditionGenerator
import game.MoveConditionGenerator
import game.RacingCarGame
import game.UserInputHandler
import game.UserMessageDisplay
import game.UserOutputHandler
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class RacingCarSteps {
    var carCount: Int = 0
    var retryCount: Int = 0
    private var moveConditionGenerator: MoveConditionGenerator = FixedMoveConditionGenerator(0)
    private var userInputHandler: UserInputHandler = ConsoleInputHandler()
    private var userOutputHandler: UserOutputHandler = UserMessageDisplay()
    private var result: MutableList<Car> = mutableListOf()

    @Given("자동차 수 {int}대와 시도할 횟수 {int}번 입력받고")
    fun `자동차 수 {int}대와 시도할 횟수 {int}번 입력받고`(inputCarCount: Int, inputRetryCount: Int) {
        carCount = inputCarCount
        retryCount = inputRetryCount
        userInputHandler = object : UserInputHandler {
            override fun askForCarCount(): Int = carCount
            override fun askForRetryCount(): Int = retryCount
        }
        userOutputHandler = object : UserOutputHandler {
            override fun display(cars: List<Car>) {
                result.clear()
                result.addAll(cars)
            }
        }
    }

    @When("고정 이동조건이 {int}이면")
    fun `고정 이동조건이 {int}이면`(moveConditionCount: Int) {
        moveConditionGenerator = FixedMoveConditionGenerator(moveConditionCount)
    }

    @Then("자동차는 {int}대 생성되고 모든 자동차는 {int}번씩 이동한다")
    fun `자동차는 {int}대 생성되고 모든 자동차는 {int}번 이동한다`(expectedCarCount: Int, expectedPosition: Int) {

        val racingCarGame =
            RacingCarGame(userInputHandler, userOutputHandler, moveConditionGenerator)
        racingCarGame.start()
        result.forEach {
            assert(it.isSamePosition(expectedPosition))
        }
    }

    @When("자동차 수를 {String}으로 잘못 입력하면")
    fun `자동차 수를 {String}으로 잘못 입력하면`(inputCarCount: String) {
        userInputHandler = object : UserInputHandler {
            override fun askForCarCount(): Int = inputCarCount.toInt()
            override fun askForRetryCount(): Int = retryCount
        }
    }
}

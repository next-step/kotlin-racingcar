package racingcar.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import racingcar.mock.InputViewMock

class PromptServiceTest : StringSpec({
    val promptService = PromptServiceImpl(inputView = InputViewMock(), resultView = ResultView())

    "자동차 이름은 쉼표(,)를 기준으로 구분한다" {
        // arrange
        val names = listOf("one", "two", "three")
        val joinedNamesWithComma = names.joinToString(",")

        // act
        val nameOfCars = promptService.getNameOfCars(joinedNamesWithComma)

        // assert
        nameOfCars shouldHaveSize names.size
    }
})

package racingcar

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat

class CarRacingSpec : StringSpec({
    "자동차수와 움직임수를 지정하면 자동차 경주를 실행하여 결과를 반환한다" {
        // arrange
        val numberOfCars = 3
        val numberOfMoves = 5

        val carFactory = CarFactory()
        val carRacing = CarRacing(
            carFactory = carFactory,
            promptService = PromptService(inputView = InputViewMock(), resultView = ResultView())
        )
        val cars = carFactory.create(numberOfCars)

        // act
        val result = carRacing.startRace(cars = cars, moves = numberOfMoves)

        // assert
        assertThat(result).hasSize(numberOfMoves)
            .allMatch {
                it.size == numberOfCars
            }

        result.forEach {
            it.forEach { distance ->
                assertThat(distance).isLessThanOrEqualTo(numberOfMoves)
            }
        }
    }
})

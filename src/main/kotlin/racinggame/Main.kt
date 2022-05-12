package racinggame

import racinggame.domain.car.RandomEngineCarFactory
import racinggame.view.InputLayout
import racinggame.view.InputView
import racinggame.view.RacingGameLayout
import racinggame.view.ResultView
import racinggame.view.converter.NameConverter
import racinggame.view.converter.StringToIntConverter
import racinggame.view.validator.NameLengthValidator
import racinggame.view.validator.NumberRangeValidator

private const val INPUT_MESSAGE_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val INPUT_MESSAGE_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?"

fun main() {
    val racingGameLayout = RacingGameLayout(
        inputLayout = InputLayout(
            carInputView = InputView(
                INPUT_MESSAGE_NAME_OF_CARS,
                NameConverter(),
                NameLengthValidator
            ),
            attemptInputView = InputView(
                INPUT_MESSAGE_NUMBER_OF_ATTEMPTS,
                StringToIntConverter(),
                NumberRangeValidator
            )
        ),
        resultView = ResultView
    )
    racingGameLayout.execute(RandomEngineCarFactory)
}

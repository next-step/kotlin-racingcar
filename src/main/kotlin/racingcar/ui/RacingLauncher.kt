package racingcar.ui

import input.SystemInputStrategy
import racingcar.Car
import racingcar.Cars
import racingcar.Game
import racingcar.RandomMovingStrategy

fun main() {
    Game(
        Cars(
            attemptToGetInput("자동차의 이름을 알려주세요(ex. 철수, 영희, 영진, 상우).", NameInputParser())
                .map {
                    Car(it, RandomMovingStrategy())
                }
        ),
        attemptToGetInput("시도할 횟수는 몇 회인가요?", IntegerInputParser())
    ).start()
}

private fun <T> attemptToGetInput(question: String, parser: InputParser<T>): T {
    return try {
        parser.parse(InputView(question, SystemInputStrategy()).value)
    } catch (e: Exception) {
        attemptToGetInput(question, parser)
    }
}

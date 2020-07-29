package racingcar

const val FIRST_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
const val SECOND_QUESTION = "시도할 횟수는 몇 회인가요?"

fun main() {
    val carNames = InputView.getCarNames(FIRST_QUESTION)
    val tryCount = InputView.getAnswerTo(SECOND_QUESTION)
    val winners = RacingCar(carNames).race(tryCount)
    ResultView.viewWinner(winners)
}

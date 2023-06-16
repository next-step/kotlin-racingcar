package racing.domain

import io.kotest.core.spec.style.AnnotationSpec
import racing.InputParser
import racing.view.ResultView

class RacingGameTest : AnnotationSpec() {

    @Test
    fun `전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다`() {
        val carNames = "pobi,crong,honux"
        val cars = InputParser.parse(carNames).map { Car(it) }
        RacingGame.raceStart(cars)
        ResultView.showSkidMarks(cars)
    }

    @Test
    fun ` 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다`() {
        val carNames = "pobi,crong,honux"
        val cars = InputParser.parse(carNames).map { Car(it) }
        RacingGame.raceStart(cars)
        ResultView.showWinner(cars)
    }
}

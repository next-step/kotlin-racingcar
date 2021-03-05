package racingcar_winner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar_winner.model.Cars
import racingcar_winner.model.Recorder

class RecorderTest {

    val POSSIBLE_TO_MOVE_NUMBER = 5
    val IMPOSSIBLE_TO_MOVE_NUMBER = 0
    val PHOBI = 0
    val JOHN = 1
    val JAMES = 2

    val recorder = Recorder()
    val carNames = listOf("Phobi", "John", "James")
    val listOfCars = Cars.convertNamesToCar(carNames)

    @Test
    fun `차들이 전진하고 나서 차의 정보들이 제대로 출력되는지 확인`() {
        listOfCars[PHOBI].tryToMoveForward(POSSIBLE_TO_MOVE_NUMBER)
        listOfCars[JOHN].tryToMoveForward(POSSIBLE_TO_MOVE_NUMBER)
        listOfCars[JAMES].tryToMoveForward(IMPOSSIBLE_TO_MOVE_NUMBER)
        val cars = Cars.makeCars(listOfCars)
        recorder.recordCurrentState(cars)

        assertThat(recorder.record).isEqualTo("Phobi : -\nJohn : -\nJames : \n\n")
    }
}

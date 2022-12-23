package racingcar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.data.CarMoves
import racingcar.domain.MoveHistory

class MoveHistoryTest {

    @Test
    fun `이동한 정보를 기록한다`() {
        val carName = "자동차1"
        val carMoves = CarMoves(carName, listOf(1))
        val moveHistory = MoveHistory(listOf(carMoves))

        assertTrue(moveHistory.moveHistory.size == 1)
    }

    @Test
    fun `자동차 이름에 매칭하여 이동한 정보를 기록한다`() {
        val carName = "자동차1"
        val carMoves = CarMoves(carName, listOf(1, 1))
        val moveHistory = MoveHistory(listOf(carMoves))

        assertTrue(moveHistory.moveHistory[0].moves.size == 2)
    }

    @Test
    fun `이동한 정보를 통해 우승자 이름들을 가져온다`() {
        val carName1 = "자동차1"
        val carName2 = "자동차2"
        val carMoves1 = CarMoves(carName1, listOf(1, 2))
        val carMoves2 = CarMoves(carName2, listOf(1, 1))
        val moveHistory = MoveHistory(listOf(carMoves1, carMoves2))

        assertTrue(moveHistory.getWinningCarNames().size == 1)
        assertTrue(moveHistory.getWinningCarNames()[0].equals(carName1, false))
    }
}

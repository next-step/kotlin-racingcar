package racingcar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.data.MoveHistory
import racingcar.data.MoveInfo

class MoveHistoryTest {

    @Test
    fun `이동한 정보를 기록한다`() {
        val carName = "자동차1"
        val moveHistory = MoveHistory()

        moveHistory.addMove(MoveInfo(carName, 1))

        assertTrue(moveHistory.getMoveHistory().size == 1)
    }

    @Test
    fun `자동차 이름에 매칭하여 이동한 정보를 기록한다`() {
        val carName = "자동차1"
        val moveHistory = MoveHistory()

        moveHistory.addMove(MoveInfo(carName, 1))
        moveHistory.addMove(MoveInfo(carName, 1))

        assertTrue(moveHistory.getMoveHistory()[carName]?.size == 2)
    }

    @Test
    fun `이동한 정보를 통해 우승자 이름들을 가져온다`() {
        val carName1 = "자동차1"
        val carName2 = "자동차2"
        val moveHistory = MoveHistory()

        moveHistory.addMove(MoveInfo(carName1, 1))
        moveHistory.addMove(MoveInfo(carName1, 2))
        moveHistory.addMove(MoveInfo(carName2, 1))

        assertTrue(moveHistory.getWinningCarNames().size == 1)
        assertTrue(moveHistory.getWinningCarNames()[0].equals(carName1, false))
    }
}

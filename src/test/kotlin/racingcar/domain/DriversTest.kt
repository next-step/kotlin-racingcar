package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.strategy.AlwaysFalseMoveStrategy
import racingcar.domain.strategy.AlwaysTrueMoveStrategy
import racingcar.domain.strategy.NameLengthLimitStrategy
import racingcar.dto.MoveResults
import racingcar.exception.InvalidDriverNameException

class DriversTest {

    @Test
    fun `드라이버에 생성시 기본으로 Car 이름 전략이 설정된다`() {
        val validCarName = "valid"
        val invalidCarName = "invalid"
        assertThrows<InvalidDriverNameException> {
            Drivers(
                listOf(validCarName, invalidCarName),
                AlwaysTrueMoveStrategy(),
                NameLengthLimitStrategy()
            )
        }

        assertThrows<InvalidDriverNameException> {
            Drivers(
                listOf(invalidCarName),
                AlwaysTrueMoveStrategy(),
                NameLengthLimitStrategy()
            )
        }
    }

    @Test
    fun `드라이버의 전략이 true면 차가 움직일 수 있다`() {
        // given
        val alwayMoveDriver = Drivers(listOf("car"), AlwaysTrueMoveStrategy(), NameLengthLimitStrategy())

        // when
        val moveCount = 100
        val expectedDistance = 100
        repeat(moveCount) {
            alwayMoveDriver.driveAll()
        }

        // then
        val moveResults = alwayMoveDriver.getMoveResults()
        val moveDistance = moveResults.data[0].moveDistance

        assertThat(moveDistance).isEqualTo(expectedDistance)
    }

    @Test
    fun `드라이버의 전략이 false면 차가 움직일 수 없다`() {
        // given
        val alwayMoveDriver = Drivers(
            listOf("car"),
            AlwaysFalseMoveStrategy(),
            NameLengthLimitStrategy()
        )

        // when
        val moveCount = 100
        val expectedDistance = 0
        repeat(moveCount) {
            alwayMoveDriver.driveAll()
        }

        // then
        val moveResults = alwayMoveDriver.getMoveResults()
        val moveDistance = moveResults.data[0].moveDistance

        assertThat(moveDistance).isEqualTo(expectedDistance)
    }

    @Test
    fun `우승자의 이동결과를 반환한다`() {
        val drivers = Drivers(listOf("pang", "yohan"), AlwaysTrueMoveStrategy(), NameLengthLimitStrategy())

        drivers.driveAll()

        val winnerResults = drivers.getWinnerResults()
        val expectedWinnerResults =
            listOf(
                MoveResults.MoveResult("pang", 1),
                MoveResults.MoveResult("yohan", 1),

            )

        assertThat(winnerResults).isEqualTo(expectedWinnerResults)
    }
}

package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MoveResultTest {

    @Test
    fun `가장 먼 거리의 차 이름을 반환한다`() {
        val moveResults = MoveResults(
            listOf(
                MoveResults.MoveResult("pang", 5),
                MoveResults.MoveResult("yohan", 4),
                MoveResults.MoveResult("lucy", 3),
                MoveResults.MoveResult("jayden", 2)
            )
        )
        val expectedNames = listOf("pang")
        Assertions.assertThat(moveResults.farthestDistanceCarNames).isEqualTo(expectedNames)
    }

    @Test
    fun `가장 먼 거리가 같으면, 여러 차 이름을 반환한다`() {
        val moveResults = MoveResults(
            listOf(
                MoveResults.MoveResult("pang", 5),
                MoveResults.MoveResult("yohan", 4),
                MoveResults.MoveResult("lucy", 3),
                MoveResults.MoveResult("jayden", 5)
            )
        )
        val expectedNames = listOf("pang", "jayden")
        Assertions.assertThat(moveResults.farthestDistanceCarNames).isEqualTo(expectedNames)
    }
}

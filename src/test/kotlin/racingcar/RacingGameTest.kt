package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `moveCondition이 항상 참이면 tryMoveCount 만큼 차가 이동한다`(count: Int) {
        val moveCondition = OnlyTrueMoveCondition()
        val cars = listOf(Car(moveCondition))
        val tryMoveCount: Int = count
        val gameRecorder = RacingGameRecorder()

        RacingGame().play(cars, tryMoveCount, gameRecorder)

        assertThat(cars.first().position).isEqualTo(count)
    }

    @Test
    fun `이동 횟수가 0인 경우 차는 이동하지 않는다`() {
        val moveCondition = OnlyTrueMoveCondition()
        val cars = listOf(Car(moveCondition))
        val tryMoveCount = 0
        val gameRecorder = RacingGameRecorder()

        val originalCarPosition = cars.first().position

        RacingGame().play(cars, tryMoveCount, gameRecorder)

        val movedCarPosition = cars.first().position

        assertThat(originalCarPosition).isEqualTo(movedCarPosition)
    }

    @Test
    fun `moveCondition에 따라 각각 차의 이동 거리가 다를 수 있다`() {
        val cars = listOf(
            Car(OnlyTrueMoveCondition()),
            Car(OnlyFalseMoveCondition()),
        )
        val tryMoveCount = 1
        val gameRecorder = RacingGameRecorder()

        RacingGame().play(cars, tryMoveCount, gameRecorder)

        assertThat(cars[0].position).isNotEqualTo(cars[1].position)
    }
}

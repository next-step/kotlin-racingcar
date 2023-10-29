package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `moveCondition이 항상 참이면 tryMoveCount 만큼 차가 이동한다`(count: Int) {
        val cars = arrayOf(Car())
        val tryMoveCount: Int = count
        val moveCondition = OnlyTrueMoveCondition()

        RacingGame().play(cars, tryMoveCount, moveCondition)

        assertThat(cars.first().position).isEqualTo(count)
    }

    @Test
    fun `이동 횟수가 0인 경우 차는 이동하지 않는다`() {
        val cars = arrayOf(Car())
        val tryMoveCount = 0
        val moveCondition = OnlyTrueMoveCondition()

        val originalCarPosition = cars.first().position

        RacingGame().play(cars, tryMoveCount, moveCondition)

        val movedCarPosition = cars.first().position

        assertThat(originalCarPosition).isEqualTo(movedCarPosition)
    }

    @Test
    fun `moveCondition에 따라 각각 차의 이동 거리가 다를 수 있다`() {
        val cars = arrayOf(Car(), Car())
        val tryMoveCount = 1
        val moveCondition = OnlyFirstConditionTrueMoveCondition()

        RacingGame().play(cars, tryMoveCount, moveCondition)

        assertThat(cars[0].position).isNotEqualTo(cars[1].position)
    }

    private class OnlyTrueMoveCondition : MoveCondition {
        override fun canForward(): Boolean {
            return true
        }
    }

    private class OnlyFirstConditionTrueMoveCondition : MoveCondition {
        var condition = true
        override fun canForward(): Boolean {
            val originCondition = condition
            condition = false

            return originCondition
        }
    }
}

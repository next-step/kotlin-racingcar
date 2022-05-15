package game.racingcar.domain

import game.racingcar.strategy.MoveStrategy
import game.racingcar.strategy.MustOneMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("경주용 자동차")
internal class CarTest {

    @Test
    fun `처음 위치는 0`() {
        // given
        val car = Car()
        val expected = 0

        // when
        // then
        assertThat(car.position).isEqualTo(expected)
    }

    @Test
    fun `1씩 10번 이동`() {
        // given
        val car = Car()
        val expected = 10

        // when
        for (i in 1..expected) {
            car.move(MustOneMoveStrategy())
        }

        // then
        assertThat(car.position).isEqualTo(expected)
    }

    @Test
    fun `2씩 10번 이동`() {
        // given
        val car = Car()
        val expected = 20

        // when
        for (i in 1..10) {
            car.move(object : MoveStrategy {
                override fun move(current: Int): Int {
                    return current + 2
                }
            })
        }

        // then
        assertThat(car.position).isEqualTo(expected)
    }

    @Test
    fun `자동차 히스토리 길이`() {
        // given
        val car = Car()
        val expected = 10

        // when
        for (i in 1..expected) {
            car.move(MustOneMoveStrategy())
        }

        // then
        assertThat(car.blackBox.size).isEqualTo(expected)
    }
}

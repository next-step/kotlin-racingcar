package game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    private val advanceCount = 4

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `자동차는 4이상 9이하일때 한칸 전진한다`(moveCondition: Int) {
        // given
        var car = Car.of("honux")

        // when
        car = car.move(moveCondition)

        // then
        assertThat(car.isSamePosition(1)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 10])
    fun `자동차는 4미만 9초과하면 전진하지 않는다`(moveCondition: Int) {
        // given
        var car = Car.of("honux")

        // when
        car.move(moveCondition)

        // then
        assertThat(car.isSamePosition(0)).isTrue()
    }

    @ParameterizedTest
    @CsvSource(value = ["0:false", "1:true", "2:false"], delimiter = ':')
    fun `자동차 위치와 비교하여 같으면 true를 반환하고 다르면 false를 반환한다`(position: Int, expected: Boolean) {
        // given
        var car = Car.of("honux")
        car = car.move(advanceCount)

        // when
        val actual = car.isSamePosition(position)

        // then
        assertThat(actual).isEqualTo(expected)
    }
}

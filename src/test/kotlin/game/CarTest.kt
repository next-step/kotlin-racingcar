package game

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
        car.move(moveCondition)

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
    @CsvSource(value = ["pobi,3,pobi : ---", "crong,2,crong : --", "honux,1,honux : -"])
    fun `자동차 이름과 이동거리를 그린다`(name: String, retryCount: Int, expected: String) {
        // given
        var car = Car.of(name)
        for (i in 1..retryCount) {

            car.move(advanceCount)
        }

        // when
        val actual = car.draw()

        // then
        assertThat(actual).contains(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["0:false", "1:true", "2:false"], delimiter = ':')
    fun `자동차 위치와 비교하여 같으면 true를 반환하고 다르면 false를 반환한다`(position: Int, expected: Boolean) {
        // given
        var car = Car.of("honux")
        car.move(advanceCount)

        // when
        val actual = car.isSamePosition(position)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["0:1", "1:1", "2:2"], delimiter = ':')
    fun `자동차 위치를 비교하여 더 큰 위치를 반환한다`(position: Int, expected: Int) {
        // given
        var car = Car.of("honux")
        car.move(advanceCount)

        // when
        val actual = car.maxPosition(position)

        // then
        assertThat(actual).isEqualTo(expected)
    }
}

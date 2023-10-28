package game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

private const val i1 = 4

class CarTest {
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
    fun `자동차들을 자동차이름과 이동거리를 그린다`(name: String, retryCount: Int, expected: String) {
        // given
        var car = Car.of(name)
        for (i in 1..retryCount) {
            val advanceCount = 4
            car.move(advanceCount)
        }

        // when
        val actual = car.draw()

        // then
        assertThat(actual).contains(expected)
    }
}

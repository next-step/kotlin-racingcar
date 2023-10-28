package game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @ParameterizedTest
    @CsvSource(value = ["1:4:2", "4:5:5", "0:9:1"], delimiter = ':')
    fun `자동차는 4이상 9이하일때 한칸 전진한다`(position: Int, moveCondition: Int, expected: Int) {
        // given
        var car = Car(position)

        // when
        car.move(moveCondition)

        // then
        assertThat(car.isSamePosition(expected)).isTrue()
    }

    @ParameterizedTest
    @CsvSource(value = ["1:3", "4:10"], delimiter = ':')
    fun `자동차는 4미만 9초과하면 전진하지 않는다`(position: Int, moveCondition: Int) {
        // given
        var car = Car(position)

        // when
        car.move(moveCondition)

        // then
        assertThat(car.isSamePosition(position)).isTrue()
    }
}

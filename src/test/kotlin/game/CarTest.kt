package game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @ParameterizedTest
    @CsvSource(value = ["1:4:5", "4:5:9", "0:9:9"], delimiter = ':')
    fun `자동차는 4이상 9이하일때 전진한다`(position: Int, movement: Int, expected: Int) {
        // given
        var car = Car(position)

        // when
        car.move(movement)

        // then
        assertThat(car.position).isEqualTo(expected)
    }
}

package game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @ParameterizedTest
    @CsvSource(value = ["1:2:3", "4:5:9", "0:8:8"], delimiter = ':')
    fun `자동차는 주어지 숫자만큼 전진`(position: Int, movement: Int, expected: Int) {
        // given
        var car = Car(position)

        // when
        car.move(movement)

        // then
        assertThat(car.position).isEqualTo(expected)
    }
}

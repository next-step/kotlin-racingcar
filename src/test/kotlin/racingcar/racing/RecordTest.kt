package racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.racing.car.CarLocation
import racingcar.racing.car.CarName

internal class RecordTest {
    @ParameterizedTest
    @CsvSource(
        "Benz, 0",
        "BMW, 3",
        "제네시스, 2"
    )
    fun `기록은 생성될 때의 차의 이름과 위치를 그대로 반환한다`(name: String, location: Int) {
        val record = Record(CarName(name), CarLocation(location))
        assertAll(
            { assertThat(record.name).isEqualTo(CarName(name)) },
            { assertThat(record.location).isEqualTo(CarLocation(location)) }
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 3, 138938, Int.MAX_VALUE])
    fun `두 location이 같으면 isSameAsLocation(other)은 true`(location: Int) {
        val one = Record(CarName("one"), CarLocation(location))
        val other = Record(CarName("other"), CarLocation(location))
        assertThat(one.isSameLocationAs(other)).isTrue()
    }

    @ParameterizedTest
    @CsvSource("2, 1", "1, 0", "138, 784", "47438, 42")
    fun `두 location이 다르면 isSameAsLocation(other)은 false`(oneLocation: Int, otherLocation: Int) {
        val one = Record(CarName("one"), CarLocation(oneLocation))
        val other = Record(CarName("other"), CarLocation(otherLocation))
        assertThat(one.isSameLocationAs(other)).isFalse()
    }
}

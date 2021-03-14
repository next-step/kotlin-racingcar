package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.car.CarLocation
import racingcar.domain.car.CarName

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
    fun `다른 기록의 위치와 같으면 true를 반환한다`(location: Int) {
        val one = Record("one", location)
        val other = Record("other", location)
        assertThat(one.isSameLocationAs(other)).isTrue()
    }

    @ParameterizedTest
    @CsvSource(
        "Benz, 0",
        "BMW, 3",
        "제네시스, 2"
    )
    fun `Record는 객체가 달라도 값이 같으면 동일하다`(name: String, location: Int) {
        assertThat(Record(name, location)).isEqualTo(Record(CarName(name), CarLocation(location)))
    }

    @ParameterizedTest
    @CsvSource("2, 1", "1, 0", "138, 784", "47438, 42")
    fun `다른 기록의 위치와 다르면 false를 반환한다`(oneLocation: Int, otherLocation: Int) {
        val one = Record("one", oneLocation)
        val other = Record("other", otherLocation)
        assertThat(one.isSameLocationAs(other)).isFalse()
    }
}

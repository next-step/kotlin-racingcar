package racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
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
}

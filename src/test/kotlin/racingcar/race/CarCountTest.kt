package racingcar.race

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.count.CarCount

class CarCountTest {
    @ParameterizedTest
    @CsvSource("2,2", "3,2", "10,5")
    fun `최소조건 이상의 숫자가 입력되었을 경우 value 를 통해 해당 값을 얻을 수 있다`(count: Int, min: Int) {
        Assertions.assertThat(CarCount(count, min).value).isEqualTo(count)
    }

    @ParameterizedTest
    @CsvSource("-2,2", "2,3", "1,5")
    fun `최소조건 미만의 숫자가 입력되었을 경우 에러처리`(count: Int, min: Int) {
        Assertions.assertThatThrownBy { CarCount(count, min) }
    }
}

package racingCar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = ["ffffffff", "flammmmeeeee", "eeeeeeeeeee"])
    fun `자동차 이름이 지정 된 글자가 넘으면 에러처리`(input: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { CarName(input) }
            .withMessageContaining("자를 초과할 수 없습니다.")
    }
}

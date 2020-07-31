package racingcar

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {

    @Test
    fun `자동차에 5글자 이상 이름 입력`() {
        assertThatIllegalArgumentException().isThrownBy {
            Car("abcdef")
        }
    }

    @Test
    fun `차가 전진한 경우`() {
    }
}

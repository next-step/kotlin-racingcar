package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarNameTest {

    @Test
    fun `자동차 이름이 5글자 이상이면 에러가 발생한다`() {
        Assertions.assertThatThrownBy {
            CarName("123456")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
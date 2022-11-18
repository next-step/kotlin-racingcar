package racingCar.domain

import org.junit.jupiter.api.Assertions.assertThrowsExactly
import org.junit.jupiter.api.Test

class CarNameTest {

    @Test
    fun `사용자 이름은 빈값이 아닙니다`() {
        assertThrowsExactly(IllegalArgumentException::class.java, { CarName("") })
    }
}

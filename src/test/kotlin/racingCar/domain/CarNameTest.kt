package racingCar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNameTest {

    @Test
    fun `사용자 이름은 제약조건을 만족합니다`() {
        assertThrows<IllegalArgumentException> { CarName("") }
        assertThrows<IllegalArgumentException> { CarName("loongName") }
    }
}

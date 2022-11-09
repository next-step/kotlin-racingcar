package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class CarsTest {

    @Test
    fun `자동차 댓수를 입력 받아 컬렉션 생성`() {
        assertDoesNotThrow {
            Cars(2)
        }
    }
}

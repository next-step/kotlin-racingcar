package racingcar.domain

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차 이름 목록을 입력 받아 컬렉션 생성`() {
        assertDoesNotThrow {
            Cars(CarNames("pobi,crong,honux"))
        }
    }
}

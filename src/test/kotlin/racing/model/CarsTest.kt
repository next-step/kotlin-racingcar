package racing.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차 컬렉션 테스트")
class CarsTest {

    @Test
    fun `자동차가 1대 미만이면 예외 발생`() {
        // given, when, then
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            Cars.of(0)
        }
        Assertions.assertEquals("자동차 대수는 최소 1대 이어야 합니다. (carCount: 0)", exception.message)
    }
}
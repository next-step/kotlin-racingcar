package camp.nextstep.edu.step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RacingTest {

    @DisplayName("자동차 경주를 시작하기 위한 새로운 인스턴스를 생성할 수 있다.")
    @Test
    fun newRacing() {
        Racing.new(10, 10)
        TODO()
    }

    @DisplayName("자동차 경주를 시작할 수 있다.")
    @Test
    fun startRacing() {
        Racing.new(10, 10).start()
        TODO()
    }

    @DisplayName("자동차 경주가 끝나면 결과를 확인할 수 있다.")
    @Test
    fun getResultRacing() {
        val racing = Racing.new(10, 10)
        racing.start()

        val resultMap = racing.result()
        assertNotNull(resultMap)
        assertEquals(10, resultMap.size)
    }
}

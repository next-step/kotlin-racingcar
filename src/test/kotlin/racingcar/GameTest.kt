package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GameTest {
    @ParameterizedTest
    @CsvSource(
        "1,0",
        "2,0",
        "3,0",
        "4,0",
        "5,0"
    )
    fun `차량 생성 테스트`(carCount: Int, playCount: Int) {
        Assertions.assertEquals(carCount, Game(carCount).playGameOnce().size)
    }
}

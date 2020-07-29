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

    @ParameterizedTest
    @CsvSource(
        "1,1",
        "1,2",
        "1,3",
        "1,4",
        "1,5"
    )
    fun `랜덤 이동 횟수 테스트`(carCount: Int, playCount: Int) {
        val game = Game(carCount)
        var playCounting = 0
        for (count in 1..playCount) {
            playCounting = game.playGameOnce()[0].randomMovingCount
        }
        Assertions.assertEquals(playCount, playCounting)
    }
}

package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.dto.RacingResult

class RacingGameTest {

    @CsvSource("pobi, 4, 1", "crong, 3, 0", "honux, 10, 1")
    @ParameterizedTest
    fun `레이싱 한다`(name: String, randomValue: Int, position: Int) {
        assertEquals(RacingResult(name, position), RacingGame().race(Car(name), randomValue))
    }
}

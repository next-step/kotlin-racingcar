package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.manager.RacingManager

class RacingManagerTest {

    private lateinit var racingManager: RacingManager

    @ParameterizedTest(name = "Test {index}: value == {0} result == {1}")
    @CsvSource(value = ["1, 1", "2, 2", "3, 3"])
    fun `race() 중인 Car 사이즈 테스트`(carSize: Int, expected: Int) {
        racingManager = RacingManager(carSize, 3)
        racingManager.race {
            assertThat(it.size).isEqualTo(expected)
        }
    }

    @ParameterizedTest(name = "Test {index}: value == {0} result == {1}")
    @CsvSource(value = ["1, 1", "2, 2", "3, 3"])
    fun `race() 몇 회 attempt 하는지 테스트`(attempts: Int, expected: Int) {
        racingManager = RacingManager(3, attempts)
        var count = 0
        racingManager.race { cars ->
            count++
        }
        assertThat(count).isEqualTo(expected)
    }
}

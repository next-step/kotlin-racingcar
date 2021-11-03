package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.domain.engine.CarEngine

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EngineTest {

    @ParameterizedTest(name = "Test {index}: value == {0} result == {1}")
    @CsvSource(value = ["0, false", "1, false", "2, false", "3, false", "4, true", "5, true", "6, true"])
    fun `randomNumber 4 이상일 경우 Engine 작동하는지 테스트`(value: Int, expected: Boolean) {
        // given
        val carEngine = object : CarEngine {
            override fun execute(): Boolean {
                return value >= 4
            }
        }

        // when
        val isExecute = carEngine.execute()

        // then
        assertThat(isExecute).isEqualTo(expected)
    }
}

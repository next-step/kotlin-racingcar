package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.engine.CarEngine

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EngineTest {

    class MockCarEngine : CarEngine {

        private var randomNumber = 0

        override fun execute(): Boolean {
            return randomNumber >= RACING_CAR_MOVE_CRITERIA
        }

        fun setRandomNum(num: Int) {
            this.randomNumber = num
        }

        companion object {
            const val RACING_CAR_MOVE_CRITERIA = 4
        }
    }

    private lateinit var mockCarEngine: MockCarEngine

    @BeforeAll
    fun setCarEngine() {
        mockCarEngine = MockCarEngine()
    }

    @ParameterizedTest(name = "Test {index}: value == {0} result == {1}")
    @CsvSource(value = ["0, false", "1, false", "2, false", "3, false", "4, true", "5, true", "6, true"])
    fun `randomNumber 4 이상일 경우 Engine 작동하는지 테스트`(value: Int, expected: Boolean) {
        mockCarEngine.setRandomNum(value)
        assertThat(mockCarEngine.execute()).isEqualTo(expected)
    }
}

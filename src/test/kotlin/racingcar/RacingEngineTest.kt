package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class RacingEngineTest {
    @ParameterizedTest
    @CsvSource(
        "0, 0, MOVE",
        "3, 0, STOP",
        "3, 1, STOP",
        "3, 2, STOP",
        "3, 3, MOVE",
        "3, 4, MOVE",
        "3, ${Int.MAX_VALUE}, MOVE"
    )
    fun `threshold보다 낮으면 회전력(Torque)이 0 나오고, threshold보다 높으면 회전력(Torque)이 1 나온다`(
        threshold: Int,
        force: Int,
        torque: Torque
    ) {
        val engine = RacingEngine(
            threshold = Force(threshold),
            forceGenerator = object : ForceGenerator {
                override fun generate() = Force(force)
            }
        )

        assertThat(engine.run()).isEqualTo(torque)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -4824, Int.MIN_VALUE])
    fun `threshold는 0보다 커야 한다`(threshold: Int) {
        assertThatIllegalArgumentException()
            .isThrownBy { RacingEngine(Force(threshold)) }
            .withMessage("Threshold must be positive or zero.")
    }
}

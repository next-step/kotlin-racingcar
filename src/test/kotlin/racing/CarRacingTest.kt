package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarRacingTest {

    private val output = ByteArrayOutputStream()

    @BeforeEach
    private fun setup() {
        output.reset()
        System.setOut(PrintStream(output))
    }

    @Test
    fun `유저입력에 따라 게임이 진행되고, 게임의 진행 과정과 결과를 출력한다`() {
        CarRacing(
            powerStrategy = StaticPowerStrategy(power = 10)
        ).run(UserInput(carNames = listOf("Andy", "Bruce"), moveCount = 2))

        val expect =
            """
                |Andy : -
                |Bruce : -
                |
                |Andy : --
                |Bruce : --
                |
                |Andy : ---
                |Bruce : ---
                |
                |Andy, Bruce가 최종 우승했습니다.
                |
            """.trimMargin()

        Assertions.assertThat(output.toString()).isEqualTo(expect)
    }
}
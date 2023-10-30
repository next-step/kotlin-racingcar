package step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step4.data.RacingCar
import step4.presentation.InputView

class InputViewTest {
    @Test
    fun `차 이름들을 적으면 리스트로 뽑아준다`() {
        val line = "kotlin,python,java"
        assertThat(InputView.enterCars(line)).isEqualTo(
            listOf(
                RacingCar("kotlin"),
                RacingCar("python"),
                RacingCar("java")
            )
        )
    }
}

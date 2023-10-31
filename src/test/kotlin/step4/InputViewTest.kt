package step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step4.domain.InputSupplier
import step4.domain.RacingCar
import step4.domain.RacingCars
import step4.presentation.InputView

class InputViewTest {
    private val testInputSupplier = object : InputSupplier {
        override fun read(): String {
            return "kotlin,python,java"
        }
    }

    @Test
    fun `차 이름들을 적으면 리스트로 뽑아준다`() {
        assertThat(InputView(testInputSupplier).enterCars()).isEqualTo(
            RacingCars(
                listOf(
                    RacingCar("kotlin"),
                    RacingCar("python"),
                    RacingCar("java")
                )
            )
        )
    }
}

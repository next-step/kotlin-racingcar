package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import step3.ui.Input
import java.util.InputMismatchException

class CarsTest {

    @Test
    fun `자동차 대수 Input Test`() {
        Assertions.assertThatThrownBy { Cars(Input.getCountOfCar()) }
            .isInstanceOf(InputMismatchException::class.java)
    }

    @Test
    fun `시도할 횟수 Input Test`() {
        Assertions.assertThatThrownBy { Round(Input.getNumberOfRound()) }
            .isInstanceOf(InputMismatchException::class.java)
    }
}

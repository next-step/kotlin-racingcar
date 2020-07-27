package onestep.racingcar.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InputViewTest {

    @Test
    fun `Happy Case`() {
        InputView {
            return@InputView "3"
        }.run {
            Assertions.assertThat(this.showInput()).isEqualTo(Pair(3, 3))
        }
    }

    @Test
    fun `Should Exception(Wrong Input) When text is entered`() {
        InputView {
            return@InputView "Test"
        }.run {
            Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
                this.showInput()
            }
        }
    }

    @Test
    fun `Should Exception(Input Only Positive integer) When negativeNumBer is entered`() {
        InputView {
            return@InputView "-3"
        }.run {
            Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
                this.showInput()
            }
        }
    }

    @Test
    fun `Should Exception(Input Only Positive integer) When Zero(0) is entered`() {
        InputView {
            return@InputView "0"
        }.run {
            Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
                this.showInput()
            }
        }
    }

    @Test
    fun `Should Exception(Input Only Positive integer) When Null is entered`() {
        InputView {
            return@InputView null
        }.run {
            Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
                this.showInput()
            }
        }
    }

    fun `Should Exception(), When input Wrong value - CarName's Size more than 5`() {
        return
    }
}

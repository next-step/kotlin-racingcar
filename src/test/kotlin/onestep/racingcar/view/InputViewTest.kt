package onestep.racingcar.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InputViewTest {

    @Test
    fun `Happy Case`() {
        // given
        val input = InputView(getNameOfCarsInput = { "CAR1,CAR2,CAR3" }, getNumberOfTryInput = { "3" })
        // then : result is  3 SizeList , 3
        Assertions.assertThat(input.getInputs().first.size).isEqualTo(3)
        Assertions.assertThat(input.getInputs().second).isEqualTo(3)
    }

    @Test
    fun `Should Exception(Wrong Input) When Input is not Integer Type`() {
        // given
        val input = InputView(getNameOfCarsInput = { "CAR1,CAR2,CAR3" }, getNumberOfTryInput = { "" })
        // when
        // then
        Assertions.catchThrowable {
            input.getInputs()
        }
    }

    @Test
    fun `Should Exception(Input Only Positive integer) When negativeNumBer is entered`() {
        // given
        val input = InputView(getNameOfCarsInput = { "CAR1,CAR2,CAR3" }, getNumberOfTryInput = { "-3" })
        // when
        // then : IllegalArgumentException(Input Only Positive integer)
        Assertions.catchThrowable {
            input.getInputs()
        }
    }

    @Test
    fun `Should Exception(Input Only Positive integer) When Zero(0) is entered`() {
        // given : getNumberOfTryInput is negativeNumBer
        val input = InputView(getNameOfCarsInput = { "CAR1,CAR2,CAR3" }, getNumberOfTryInput = { "0" })
        // when
        // then : IllegalArgumentException(Input Only Positive integer)
        Assertions.catchThrowable {
            input.getInputs()
        }
    }

    @Test
    fun `Should Exception(Wrong Input( null )) When Null is entered`() {
        // given : getNumberOfTryInput is Null
        val input = InputView(getNameOfCarsInput = { "CAR1,CAR2,CAR3" }, getNumberOfTryInput = { null })
        // when
        // then : IllegalArgumentException(Wrong Input( null ))
        Assertions.catchThrowable {
            input.getInputs()
        }
    }

    @Test
    fun `Should Exception(), When input Wrong value - CarName's Size more than 5`() {
        // given : input more than 5 Size CarName in getNameOfCarsInput
        val input = InputView(getNameOfCarsInput = { "CARCARCAR1,CAR2,CAR3" }, getNumberOfTryInput = { "3" })
        // when
        // then : IllegalArgumentException( CarName's Length can not more than 5 )
        Assertions.catchThrowable {
            input.getInputs()
        }
    }
}

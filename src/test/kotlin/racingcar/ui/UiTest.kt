package racingcar.ui

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStreamReader
import java.util.function.Consumer
import java.util.function.Supplier

class UiTest {

    @ParameterizedTest
    @CsvSource(value = ["3, 5"])
    fun `InputView test`(numOfPlayer: String, numOfRepetition: String) {
        val inputView = InputView.builder()
            .player(Consumer(::println), Supplier { numOfPlayer })
            .repetition(Consumer(::println), Supplier { numOfRepetition })
            .build()

        assertThat(inputView.numOfCar).isEqualTo(3)
        assertThat(inputView.numOfRepetition).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `ResultView draw test`(position: Int) {
        val drawResult = ResultView().draw(position)
        System.setIn(ByteArrayInputStream(drawResult.toByteArray()))
        assertThat(drawResult).isEqualTo(readCommandLines())
    }

    @ParameterizedTest
    @ValueSource(strings = ["레이싱 시작합니다", "레이싱 종료합니다", "결과"])
    fun `ResultView showMessage test`(message: String) {
        ResultView().showMessage(message)
        System.setIn(ByteArrayInputStream(message.toByteArray()))
        assertThat(message).isEqualTo(readCommandLines())
    }

    @Throws(IOException::class)
    fun readCommandLines(): String = BufferedReader(InputStreamReader(System.`in`)).readLine()

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `ResultView getFinishStepTitle test`(step: Int) {
        val stepTitle = ResultView().getFinishStepTitle(step)
        System.setIn(ByteArrayInputStream(stepTitle.toByteArray()))
        assertThat(stepTitle).isEqualTo(readCommandLines())
    }
}

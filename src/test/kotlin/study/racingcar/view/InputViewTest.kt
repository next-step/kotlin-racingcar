package study.racingcar.view

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.doReturn
import org.mockito.kotlin.mock

class InputViewTest {
    private val inputProvider = mock<InputProvider>()

    @Test
    fun `get number of cars from user`() {
        val inputView = InputView(inputProvider)
        doReturn("3").`when`(inputProvider).provideInput()
        val numberOfCars = inputView.getNumberOfCars()
        assertThat(numberOfCars).isEqualTo(3)
    }

    @Test
    fun `get number of rounds from user`() {
        val inputView = InputView(inputProvider)
        doReturn("5").`when`(inputProvider).provideInput()
        val numberOfRounds = inputView.getNumberOfRounds()
        assertThat(numberOfRounds).isEqualTo(5)
    }

    @Test
    fun `get car names from user`() {
        val inputView = InputView(inputProvider)
        doReturn("hong,lee,kim").`when`(inputProvider).provideInput()
        val carNames = inputView.getCarNames()
        assertThat(carNames).isEqualTo(listOf("hong", "lee", "kim"))
    }
}

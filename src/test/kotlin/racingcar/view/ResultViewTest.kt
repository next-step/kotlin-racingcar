package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ResultViewTest {

    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    @DisplayName("자동차 이름이 홍길동이고 현재 위치가 5일경우 홍길동 : ----- 값을 반환해야함")
    fun `Returns a ------value if the current location is 5`() {
        ResultView.presentSituation("홍길동", 5)
        assertThat(outputStreamCaptor.toString().trim { it <= ' ' }).isEqualTo("홍길동 : -----")
    }

    @Test
    @DisplayName("A인 자동차가 우승할 경우 A가 최종 우승했습니다.")
    fun `If a car wins, A wins the final victory`() {
        ResultView.presentWinner(listOf(Car("A")))
        assertThat(outputStreamCaptor.toString().trim { it <= ' ' }).isEqualTo("A가 최종 우승했습니다.")
    }
}

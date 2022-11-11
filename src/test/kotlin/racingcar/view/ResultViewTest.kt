package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
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
    @DisplayName("현재 위치가 5일경우 ----- 값을 반환해야함")
    fun `Returns a ------value if the current location is 5`() {
        ResultView.presentSituation(5)
        assertThat(outputStreamCaptor.toString().trim { it <= ' ' }).isEqualTo("-----")
    }
}

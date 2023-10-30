package game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class UserMessageDisplayTest {

    private val originalOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun displayHistory() {
        // given
        val userMessageDisplay = UserMessageDisplay()

        // when
        userMessageDisplay.displayHistory(
            History().apply {
                addRound(listOf(Car.of("a", 1), Car.of("b", 1)))
                addRound(listOf(Car.of("a", 1), Car.of("b", 2)))
                setWinners(listOf("b"))
            }
        )

        // then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(
            """
            a : -
            b : -
            
            a : -
            b : --
            
            b가 최종 우승했습니다.
            """.trimIndent()
        )
    }
}

package camp.nextstep.edu.view

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayInputStream

class InputHandlerTest {

    private val standardIn = System.`in`

    @BeforeEach
    fun setUp() {
        // 각 테스트 전에 표준 입력을 null로 설정하여 readlnOrNull()이 null을 반환하지 않도록 함
        System.setIn(ByteArrayInputStream("".toByteArray()))
    }

    @AfterEach
    fun tearDown() {
        System.setIn(standardIn)
    }

    @Test
    fun getCarNames_validInput() {
        provideInput("car,jun")
        val names = InputHandler.readCarNames()
        assertEquals(listOf("car", "jun"), names)
    }

    @Test
    fun getCarNames_nameTooLong() {
        provideInput("tooLongName,car")
        assertThrows(IllegalArgumentException::class.java) {
            InputHandler.readCarNames()
        }.apply {
            assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.", message)
        }
    }

    @Test
    fun getCarNames_emptyNameIncluded() {
        provideInput("car,,jun")
        assertThrows(IllegalArgumentException::class.java) {
            InputHandler.readCarNames()
        }.apply {
            assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.", message)
        }
    }

    @Test
    fun getCarNames_blankNameIncluded() {
        provideInput("car, ,jun")
        assertThrows(IllegalArgumentException::class.java) {
            InputHandler.readCarNames()
        }.apply {
            assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.", message)
        }
    }

    @Test
    fun getNumberOfMoves_validInput() {
        provideInput("3")
        val moves = InputHandler.getNumberOfMoves()
        assertEquals(3, moves)
    }

    @Test
    fun getNumberOfMoves_invalidInputNotNumber() {
        provideInput("abc")
        assertThrows(IllegalArgumentException::class.java) {
            InputHandler.getNumberOfMoves()
        }.apply {
            assertEquals("[ERROR] 유효한 숫자를 입력해야 합니다.", message) // JVM의 기본 메시지
        }
    }

    @Test
    fun getNumberOfMoves_invalidInputZero() {
        provideInput("0")
        assertThrows(IllegalArgumentException::class.java) {
            InputHandler.getNumberOfMoves()
        }.apply {
            assertEquals("[ERROR] 시도 횟수는 1 이상이어야 합니다.", message)
        }
    }

    @Test
    fun getNumberOfMoves_invalidInputNegative() {
        provideInput("-1")
        assertThrows(IllegalArgumentException::class.java) {
            InputHandler.getNumberOfMoves()
        }.apply {
            assertEquals("[ERROR] 시도 횟수는 1 이상이어야 합니다.", message)
        }
    }

    // Helper function to provide input to System.in
    private fun provideInput(data: String) {
        System.setIn(ByteArrayInputStream(data.toByteArray()))
    }
}
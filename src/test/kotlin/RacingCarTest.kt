import com.racingCar.mainKt.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream

class RacingCarTest {
    @Test
    fun `Should inputCarNames return list of car names`() {
        val input = "car1,car2,car3\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val result = inputCarNames()
        assertEquals(listOf("car1", "car2", "car3"), result)
    }

    @Test
    fun `Should inputCarNames throw IllegalArgumentException`() {
        val input = "car1,car2222,car3\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThrows<IllegalArgumentException> {
            inputCarNames()
        }
    }

    @Test
    fun `Should inputCarNames throw exception for empty input`() {
        val input = ""
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThrows<IllegalArgumentException> {
            inputCarNames()
        }
    }

    @Test
    fun `Should initRaces initialize races with car names`() {
        // 입력 스트림 설정
        val input = "car1,car2\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val result = initRaces()
        assertEquals(mapOf("car1" to 0, "car2" to 0), result)
    }

    @Test
    fun `Should runRaces update race scores`() {
        val races = mutableMapOf("car1" to 0, "car2" to 0)
        runRaces(races, 1)

        assertTrue(races["car1"]!! >= 0)
        assertTrue(races["car2"]!! >= 0)
    }

    @Test
    fun `Should getWinners return multiple winners if tied`() {
        val races = mutableMapOf("car1" to 5, "car2" to 5)
        val winners = getWinners(races)
        assertEquals("car1, car2", winners)
    }

    @Test
    fun `Should get random values between 0~1`() {
        val value = getRandValue()
        assert(value in 0..1)
    }
}
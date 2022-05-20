package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MoveDecisionMakerTest {
    val moveDecisionMaker = MoveDecisionMaker()

    @Test
    fun `test getRandomDigit`() {
        val res = (0..1000)
            .map { moveDecisionMaker.getRandomDigit() }
            .groupingBy { it }
            .eachCount()

        (0..9).forEach {
            Assertions.assertThat(res.get(it)).isGreaterThan(50)
        }
    }

    @Test
    fun `test canMove`() {
        Assertions.assertThat(moveDecisionMaker.canMove(4)).isEqualTo(false)
        Assertions.assertThat(moveDecisionMaker.canMove(5)).isEqualTo(true)
    }
}

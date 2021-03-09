package racing

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racing.domain.Probability

class ProbabilityTest {

    @Test
    fun `낮은 확률일때는 전진할수 없다`() {
        assertFalse(LowProbabilityProxy().canGo())
    }

    @Test
    fun `높은 확률일때는 전진할수 있다`() {
        assertTrue(HighProbabilityProxy().canGo())
    }
}

class LowProbabilityProxy : Probability() {
    override fun getProbability(): Int {
        return 3
    }
}

class HighProbabilityProxy : Probability() {
    override fun getProbability(): Int {
        return 7
    }
}

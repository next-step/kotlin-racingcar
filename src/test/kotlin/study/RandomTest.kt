package study

import org.junit.jupiter.api.Test
import kotlin.random.Random

class RandomTest {

    @Test
    fun `Random Learning Test`() {
        for (i in 0..100)
            println(Random.nextInt(1))
    }
}

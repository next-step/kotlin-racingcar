package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomTest {
    @Test
    fun random() {
        for(i in 0..1000) {
            val randomNumber = (0..9).random()
            assertThat(randomNumber).isBetween(0, 9)
        }
    }
}

package step3.study

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.random.Random

/**
 *
 * @author Leo
 */
class RandomTest {

    @Test
    fun rangeTest() {
        val underTen = IntRange(0, 9).toList()
        for (num in 1..1000) {
            val number = Random.nextInt(10)
            assertTrue(underTen.contains(number))
        }
    }

    @Test
    fun forTest() {
        for (num in 1..10) {
            println(num)
        }
    }

}
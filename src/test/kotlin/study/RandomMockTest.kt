package study

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.random.Random

class RandomMockTest {

    @Test
    fun mockkingRandomNextInt() {
        val random = mockk<Random>()
        every { random.nextInt() } returns 1

        assertEquals(1, random.nextInt())
        assertEquals(1, random.nextInt())
        assertEquals(1, random.nextInt())
        assertEquals(1, random.nextInt())
        assertEquals(1, random.nextInt())
        assertEquals(1, random.nextInt())
    }

    @Test
    fun randomFromSeed() {
        val randomFromSeed = Random(1)
        val firstRandomInt = randomFromSeed.nextInt()
        val secondRandomInt = randomFromSeed.nextInt()

        val anotherRandomSameSeed = Random(1)
        assertEquals(firstRandomInt, anotherRandomSameSeed.nextInt())
        assertEquals(secondRandomInt, anotherRandomSameSeed.nextInt())
    }

    @Test
    fun mockkingSeedRandom() {
        // given
        val mockkRandom = mockk<Random>()
        every { mockkRandom.nextInt() } returnsMany listOf(10, 20, 30, 40, 50)

        val seed = 1
        mockkStatic("kotlin.random.RandomKt")
        every { Random(seed) } returns mockkRandom

        // when
        val predictableRandom = Random(seed)

        // then
        assertEquals(10, predictableRandom.nextInt())
        assertEquals(20, predictableRandom.nextInt())
        assertEquals(30, predictableRandom.nextInt())
        assertEquals(40, predictableRandom.nextInt())
        assertEquals(50, predictableRandom.nextInt())
    }
}

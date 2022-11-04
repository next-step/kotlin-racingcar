package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MemoryTest {
    @Test
    fun `기본 인자`() {
        assertThat(Memory()).isEqualTo(Memory(emptyList(), 0))
    }

    @Test
    fun `store`() {
        var memory = Memory()
        memory.store(listOf("1", "+", "3"))
        assertThat(memory).isEqualTo(Memory(listOf("1", "+", "3"), 1))
    }

    @Test
    fun `size`() {
        var memory = Memory()
        memory.store(listOf("1", "+", "3"))
        assertThat(memory.size()).isEqualTo(3)
    }

    @Test
    fun `fetch`() {
        var memory = Memory()
        memory.store(listOf("1", "+", "3"))
        assertThat(memory.fetch(0)).isEqualTo("1")
    }

    @Test
    fun `reset`() {
        var setMemory = Memory(listOf("1", "+", "3"), 5)
        val emptyMemory = Memory()

        setMemory.reset()
        assertThat(setMemory).isEqualTo(emptyMemory)
    }
}

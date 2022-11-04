package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MemoryTest {
    @Test
    fun `생성자에 인자로 아무 값도 넣지 않으면, 빈 배열과 0을 가진 메모리가 생성된다`() {
        assertThat(Memory()).isEqualTo(Memory(emptyList(), 0))
    }

    @Test
    fun `store()는 메모리에 배열과 함께 배열의 첫 값이 누산기에 저장된다`() {
        var memory = Memory()
        memory.store(listOf("1", "+", "3"))
        assertThat(memory).isEqualTo(Memory(listOf("1", "+", "3"), 1))
    }

    @Test
    fun `size()는 메모리 길이를 반환한다`() {
        var memory = Memory()
        memory.store(listOf("1", "+", "3"))
        assertThat(memory.size()).isEqualTo(3)
    }

    @Test
    fun `fetch()는 원하는 주소의 값을 불러온다`() {
        var memory = Memory()
        memory.store(listOf("1", "+", "3"))
        assertThat(memory.fetch(0)).isEqualTo("1")
    }

    @Test
    fun `reset()은 배열과 누산기의 값을 초기 상태로 만든다`() {
        var setMemory = Memory(listOf("1", "+", "3"), 5)
        val emptyMemory = Memory()

        setMemory.reset()
        assertThat(setMemory).isEqualTo(emptyMemory)
    }
}

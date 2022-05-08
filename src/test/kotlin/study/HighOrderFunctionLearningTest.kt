package study

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("코틀린 고차함수 학습 테스트")
class HighOrderFunctionLearningTest {

    @Test
    fun `fold 사용법`() {
        listOf(1, 2, 3, 10, 20)
            .fold(0) { acc: Int, i: Int ->
                print("acc = $acc, i = $i, ")
                val result = acc + i
                println("result = $result")
                result
            }
    }

    @Test
    fun `reduce 사용법`() {
        listOf(1, 2, 3, 10, 20)
            .drop(1)
            .reduce { acc: Int, i: Int ->
                print("acc = $acc, i = $i, ")
                val result = acc + i
                println("result = $result")
                result
            }
    }

    @Test
    fun `windowed 사용법`() {
        val windowed = listOf(1, 2, 3, 10, 20)
            .drop(1)
            .windowed(2, 2, true)

        println(windowed.take(6).toList())

        windowed
            .map { ints -> ints[0] + ints[1] }
            .reduce { acc, i ->
                print("acc = $acc, i = $i, ")
                val result = acc + i
                println("result = $result")
                result
            }
    }
}

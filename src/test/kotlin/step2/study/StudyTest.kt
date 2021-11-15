package step2.study

import org.junit.jupiter.api.Test

/**
 *
 * @author Leo
 */
class StudyTest {

    @Test
    fun `withIndex 실제 동작 확인`() {
        val arr = listOf("a", "b", "c", "d", "e")
        arr.withIndex().forEach { (index, param) ->
            println("index : $index || param : $param")
        }
    }
}

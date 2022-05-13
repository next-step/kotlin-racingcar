package racingcar.study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConstructorLikeFunctionsTest {
    @Test
    fun `construct-like functions 으로 초기화값 생성 테스트`() {
        val testList = List(3) { it }

        assertThat(testList[0]).isEqualTo(0)
        assertThat(testList[1]).isEqualTo(1)
        assertThat(testList[2]).isEqualTo(2)

        val doubled = List(3) { index -> index * 2 }

        assertThat(doubled[0]).isEqualTo(0)
        assertThat(doubled[1]).isEqualTo(2)
        assertThat(doubled[2]).isEqualTo(4)

        val stringList = List(3) { it.toString() }

        assertThat(stringList[0]).isEqualTo("0")
        assertThat(stringList[1]).isEqualTo("1")
        assertThat(stringList[2]).isEqualTo("2")
    }
}

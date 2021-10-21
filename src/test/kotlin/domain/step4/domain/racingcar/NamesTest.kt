package domain.step4.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class NamesTest {

    @Test
    fun `1개 이상의 값을 가진 콜렉션이 입력되면 생성 가능하다`() {
        val names = Names.ofList(listOf(Name("test")))

        assertAll(
            { assertThat(names).isNotNull },
            { assertThat(names).isExactlyInstanceOf(Names::class.java) }
        )
    }

    @ParameterizedTest(name = "이름들 : {0}, 예상 사이즈값 : {1}")
    @MethodSource("nameArguments")
    fun `여러 이름들이 들어오면 조건을 통해 각각의 이름으로 나눌 수 있다`(nameStrings: String, expected: Int) {
        val names = Names.ofStringWithSplitStrategy(nameStrings) { target -> target.split(",") }
        assertThat(names.size()).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun nameArguments() = listOf(
            Arguments.of("a", 1),
            Arguments.of("a,ab", 2),
            Arguments.of("a,ab,abc", 3),
            Arguments.of("a,ab,abc,abcd", 4),
            Arguments.of("a,ab,abc,abcd,abcde", 5)
        )
    }
}

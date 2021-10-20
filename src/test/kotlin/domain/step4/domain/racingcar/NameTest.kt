package domain.step4.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NameTest {

    @ParameterizedTest(name = "이름 : {0}")
    @ValueSource(strings = ["a", "ab", "abc", "abcd", "abcd"])
    fun `길이가 5이하인 이름이 들어오면 생성 가능하다`(nameString: String) {
        val name = Name(nameString)

        assertAll(
            { assertThat(name).isNotNull },
            { assertThat(name).isExactlyInstanceOf(Name::class.java) },
        )
    }

    @Test
    fun `길이가 5 초과인 이름인 들어오면 생성 가능하다`() {

    }

}
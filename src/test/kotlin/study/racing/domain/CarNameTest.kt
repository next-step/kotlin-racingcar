package study.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CarNameTest {

    @ParameterizedTest
    @ValueSource(
        strings = [
            "a", "ab", "abc", "abcd", "!a", "?!ab", "@abc", "   a", " a b"
        ]
    )
    fun `최대 4글자인 자동차의 이름을 생성 한다`(
        carName: String
    ) {
        // Given & When
        val actual = CarName(carName)

        // Then
        assertThat(actual.name).isEqualTo(carName)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "     a", "123ab", "abcdf", "!@#@#@a", "?!%%%^#$^^#ab",
        ]
    )
    fun `5글자를 넘어가는 자동차의 이름을 주입하면 에러를 반환한다`(
        carName: String
    ) {
        assertThrows<IllegalArgumentException> {
            CarName(carName)
        }
    }

    @ParameterizedTest
    @EmptySource
    fun `자동차 이름에 빈문자열이 오면 에러를 반환한다`(
        carName: String
    ) {
        assertThrows<IllegalArgumentException> {
            CarName(carName)
        }
    }
}

package racingcar.domain.engine

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class ForceTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 234, Int.MAX_VALUE])
    fun `Force는 객체가 달라도 값이 같으면 동일하다`(force: Int) {
        assertThat(Force(force)).isEqualTo(Force(force))
    }

    @ParameterizedTest
    @CsvSource(
        "1, 2, true, false, false",
        "2, 2, false, true, false",
        "3, 2, false, false, true"
    )
    fun `Force는 대소 비교가 가능하다`(
        one: Int,
        other: Int,
        lessThanOther: Boolean,
        equalToOther: Boolean,
        moreThanOther: Boolean
    ) {
        assertAll(
            { assertThat(Force(one) < Force(other)).isEqualTo(lessThanOther) },
            { assertThat(Force(one) == Force(other)).isEqualTo(equalToOther) },
            { assertThat(Force(one) > Force(other)).isEqualTo(moreThanOther) }
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -4824, Int.MIN_VALUE])
    fun `force 값은 0보다 커야 한다`(threshold: Int) {
        assertThatIllegalArgumentException()
            .isThrownBy { Force(threshold) }
            .withMessage("Force must be positive or zero.")
    }
}

package racingcar.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource

internal class RacingCarNameTest : AnnotationSpec() {

    @ParameterizedTest
    @EmptySource
    @CsvSource(value = ["123456"])
    fun `자동차 이름은 1자 보다 적거나, 5자를 초과할 수 없다`(accepted: String) {
        // given
        // when
        // then
        assertThrows<IllegalArgumentException> { RacingCarName(accepted) }
            .message shouldBe "자동차 이름은 1자 이상이고, 5자를 초과할 수 없습니다."
    }
}

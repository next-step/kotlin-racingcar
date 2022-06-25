package racingcar.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class MovementTest : AnnotationSpec() {

    @ParameterizedTest
    @CsvSource(value = ["-1"])
    fun `이동거리는 0 보다 작을 수 없다`(accepted: Int) {
        // given
        // when
        // then
        assertThrows<IllegalArgumentException> { Movement(accepted) }
            .message shouldBe "이동거리는 0 보다 작을 수 없습니다."
    }
}

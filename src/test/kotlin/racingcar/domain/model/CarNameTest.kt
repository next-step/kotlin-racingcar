package racingcar.domain.model

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.AssertionsForClassTypes

internal class CarNameTest : StringSpec({
    "이름이 5자를 초과할 수 없다" {
        AssertionsForClassTypes.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                CarName("1234567890")
            }
    }
})

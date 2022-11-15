package racing.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec

class NameTest : StringSpec() {
    init {
        "이름은 5글자를 넘을 수 없다" {
            shouldThrowExactly<IllegalArgumentException> {
                Name("5글자넘었음")
            }
        }
    }
}

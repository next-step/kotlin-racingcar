package step3.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row

class CarNameTest : FreeSpec({
    "자동차 이름은 6글자 이상으로 설정할 수 없다." - {
        forAll(
            row("abcdef"),
            row("abcdefasdfsadf"),
            row("abcdefcvxcvc"),
            row("abcdeffff"),
            row("abcdefsadf"),
            row("abcdefasfsdafasdfsdaf"),
        ) { nameCandidate ->
            shouldThrowWithMessage<IllegalArgumentException>("이름은 5자 이하여야 합니다") {
                CarName(nameCandidate)
            }
        }
    }
})

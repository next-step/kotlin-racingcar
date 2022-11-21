package racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec

class CarNameTest : FreeSpec({

    "CarName 생성" - {

        "5글자 초과할 경우 에러를 반환한다." {
            shouldThrow<RuntimeException> {
                CarName("가나다라마바")
            }
        }

        "빈값이면 에러를 반환한다." {
            shouldThrow<RuntimeException> {
                CarName("")
            }
        }
    }
})

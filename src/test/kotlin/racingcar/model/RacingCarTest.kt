package racingcar.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row

class RacingCarTest : StringSpec({

    "자동차 이름 예외 확인" {
        forAll(
            row("kimdabomi"),
            row("KDBM"),
            row("kim12"),
        ) { userCarName ->
            shouldThrow<IllegalArgumentException> {
                RacingCar(userCarName)
            }
        }
    }
})

package racingcar

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    "4 이상의 숫자를 인자로 받으면 1칸 이동한 Car 객체를 반환한다." {
        val car = Car("faker", 1)
        car.move(4)
        car.moveCount shouldBe 2
    }

    "4 미만의 숫자를 인자로 받으면 1칸 이동한 Car 객체를 반환한다." {
        val car = Car("faker", 1)
        car.move(3)
        car.moveCount shouldBe 1
    }

    "자동차는 이름을 가질 수 있다." {
        val car = Car("faker", 1)
        car.name shouldBe "faker"
    }

    "자동차를 생성할때 공백이 전달되면 예외를 반환한다." {
        assertSoftly {
            shouldThrow<IllegalArgumentException> {
                Car("", 1)
            }
            shouldThrow<IllegalArgumentException> {
                Car(" ", 1)
            }
        }
    }

    "자동차의 이름이 5글자가 넘으면 예외를 반환한다." {
        shouldThrow<IllegalArgumentException> {
            Car("longname", 1)
        }
    }
})

package car_race.logic.car

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see CarName
 */
class CarNameTest : FunSpec({

    context("CarName 단위 테스트") {

        test("자동차 이름은 ${CarName.NAME_MAX_LENGTH}자를 초과할 수 없습니다.") {
            val goodCarNameList = listOf("a", "bc", "def", "ghij", "klmno")
            val badCarName = "pqrstu"

            shouldNotThrowAny {
                goodCarNameList.forEach { name -> CarName(name) }
            }

            shouldThrowExactly<IllegalArgumentException> { CarName(badCarName) }
        }

        test("fun getName() : 차의 이름을 가져온다.") {
            val defaultCarName = "seven"

            CarName(defaultCarName).name shouldBe defaultCarName
        }
    }
})

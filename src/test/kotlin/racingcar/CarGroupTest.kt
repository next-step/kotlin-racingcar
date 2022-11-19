package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class CarGroupTest : FunSpec({
    test("그룹에 속한 자동차들의 위치를 조회할 수 있다.") {
        // given
        val carA = Car(id = 1, name = CarName(value = "동구"), position = Position(value = 5))
        val carB = Car(id = 2, name = CarName(value = "상근"), position = Position(value = 4))
        val carGroup = CarGroup(cars = listOf(carA, carB))
        // when
        val actual = carGroup.getPositions()
        // then
        actual shouldContainExactly listOf(
            CarPosition.from(car = carA),
            CarPosition.from(car = carB),
        )
    }
})

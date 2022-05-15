package racingCar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class DrawerTest : DescribeSpec({
    describe("paint") {
        it("화면에 출력할 view 를 그린다.") {
            val drawer = Drawer()

            val expectView = drawer.paint(listOf(1, 2, 3))

            expectView shouldBe "-\n" + "--\n" + "---"
        }
    }
})
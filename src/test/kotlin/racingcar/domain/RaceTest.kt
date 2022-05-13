package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RaceTest : DescribeSpec({

    describe("init") {
        it("carCount만큼 Car 클래스가 생성된다") {
            val expect = 3
            val sut = Race(3)

            sut.carsSize shouldBe expect
        }
    }

    describe("run") {
        it("생성된 모든 Car는 move가 실행된다") {
            val car = StubCar()
            val sut = Race(listOf(car))

            sut.run()

            car.position shouldBe 1
        }
    }

    describe("allMovingDistance") {
        it("생성된 Car의 이동거리가 반환된다 ") {
            val expect = 2
            val car = StubCar()
            for (i in 1..expect) car.move()

            val sut = Race(listOf(car))

            sut.allMovingDistance.size shouldBe 1
            sut.allMovingDistance[0] shouldBe expect
        }
    }
})

class StubCar : Car() {
    override fun move(movePoint: Int) {
        super.position++
    }
}

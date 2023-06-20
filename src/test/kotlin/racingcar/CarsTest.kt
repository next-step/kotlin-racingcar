package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarsTest : FunSpec({
    context("자동차들을 추가할 수 있다") {
        val cars = Cars()
        cars.add(Car("pobi"))
        cars.add(Car("crong"))
        cars.add(Car("honux"))
        cars.getSize() shouldBe 3
    }

    context("자동차들의 이름과 위치를 구할수 있다") {
        val cars = Cars()
        cars.add(Car("pobi"))
        cars.add(Car("crong"))
        cars.add(Car("honux"))
        cars.getNamesAndPositions() shouldBe listOf(
            Pair("pobi", 0),
            Pair("crong", 0),
            Pair("honux", 0),
        )
    }

    context("자동차들 중 승자를 구할 수 있다") {
        val cars = Cars()
        val pobiCar = Car("pobi")
        val crongCar = Car("crong")
        val honuxCar = Car("honux")

        cars.add(pobiCar)
        cars.add(crongCar)
        cars.add(honuxCar)

        pobiCar.move(4)

        cars.getWinners() shouldBe listOf(
            pobiCar,
        )
    }

    context("모든 자동차들을 전진시킬 수 있다") {
        val cars = Cars()
        val pobiCar = Car("pobi")
        val crongCar = Car("crong")
        val honuxCar = Car("honux")

        cars.add(pobiCar)
        cars.add(crongCar)
        cars.add(honuxCar)

        cars.moveAllCars(object : ConditionGenerator {
            override fun generate(): Int {
                return 4
            }
        })

        cars.getNamesAndPositions() shouldBe listOf(
            Pair("pobi", 1),
            Pair("crong", 1),
            Pair("honux", 1),
        )
    }
})

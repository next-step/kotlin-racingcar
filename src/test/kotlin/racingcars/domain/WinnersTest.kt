package racingcars.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class WinnersTest : DescribeSpec({
    describe("find racing car game winner") {
        it("should be return winners") {
            val carList =
                listOf(
                    Car(id = 1, name = "name1", _position = 5),
                    Car(id = 2, name = "name2", _position = 3),
                    Car(id = 3, name = "name3", _position = 1),
                )

            val find = Winners.find(carList)
            find.size shouldBe 1
            find[0].position shouldBe 5
        }

        context("when there are multiple winners") {
            it("should return all winners with the highest position") {
                val carList = listOf(
                    Car(id = 1, name = "name1", _position = 5),
                    Car(id = 2, name = "name2", _position = 5),
                    Car(id = 3, name = "name3", _position = 3),
                )

                val find = Winners.find(carList)
                find.size shouldBe 2
                find.map { it.position }.all { it == 5 } shouldBe true
                find.map { it.name } shouldContainExactly listOf("name1", "name2")
            }
        }
    }
})

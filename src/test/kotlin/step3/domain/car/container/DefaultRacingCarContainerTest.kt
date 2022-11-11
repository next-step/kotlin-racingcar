package step3.domain.car.container

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import step3.domain.car.policy.CarNamePolicyDataSet

class DefaultRacingCarContainerTest : FunSpec({

    context("totalCarCount가 1 이상일때, DefaultRacingCarContainer 정상적으로 생성") {
        table(
            headers("totalCarCount"),
            *(1..100).map { row(it) }.toTypedArray()
        ).forAll { totalCarCount ->
            test("totalCarCount: $totalCarCount => OK") {
                assertDoesNotThrow {
                    DefaultRacingCarContainer(totalCarCount) shouldNotBe null
                }
            }
        }
    }

    context("totalCarCount가 0 이하일때, throw IllegalArgumentException") {
        table(
            headers("totalCarCount"),
            *(0 downTo -20).map { row(it) }.toTypedArray()

        ).forAll { totalCarCount ->
            test("totalCarCount: $totalCarCount => thrown IllegalArgumentException") {
                assertThrows<IllegalArgumentException> {
                    DefaultRacingCarContainer(totalCarCount)
                }
            }
        }
    }

    context("addRacingCar() : OK") {
        val testTotalCarCount = 5

        table(
            headers("totalCarCount", "addCarCount"),
            *(listOf(listOf(testTotalCarCount), (1..testTotalCarCount))).cartesianProduct()
                .map { row(it[0], it[1]) }
                .toTypedArray()
        ).forAll { totalCarCount, addCarCount ->
            test("totalCarCount: $totalCarCount, addCarCont: $addCarCount => OK") {
                val racingCarContainer = DefaultRacingCarContainer(totalCarCount)
                repeat(addCarCount) {
                    assertDoesNotThrow {
                        racingCarContainer.addRacingCar(CarNamePolicyDataSet.randomValidCarName())
                    }
                }
            }
        }
    }

    context("addRacingCar() : totalCarCount 초과 호출시: thrown IllegalStateException") {
        val testTotalCarCount = 5

        table(
            headers("totalCarCount", "addCarCount"),
            *(listOf(listOf(testTotalCarCount), (testTotalCarCount + 1..testTotalCarCount + 10))).cartesianProduct()
                .map { row(it[0], it[1]) }
                .toTypedArray()
        ).forAll { totalCarCount, addCarCount ->
            test("totalCarCount: $totalCarCount, addCarCont: $addCarCount => thrown IllegalStateException") {
                val racingCarContainer = DefaultRacingCarContainer(totalCarCount)
                assertThrows<IllegalStateException> {
                    repeat(addCarCount) {
                        racingCarContainer.addRacingCar(CarNamePolicyDataSet.randomValidCarName())
                    }
                }
            }
        }
    }

    context("When racingCarList is not full, then isFullRacingCar() should be false and isNotFullRacingCar() should be true") {
        val testTotalCarCount = 5

        table(
            headers("totalCarCount", "addCarCount"),
            *(listOf(listOf(testTotalCarCount), (0 until testTotalCarCount))).cartesianProduct()
                .map { row(it[0], it[1]) }
                .toTypedArray()
        ).forAll { totalCarCount, addCarCount ->
            test("totalCarCount: $totalCarCount, addCarCont: $addCarCount => isFull: false") {
                // Given
                val racingCarContainer = DefaultRacingCarContainer(totalCarCount)
                repeat(addCarCount) {
                    racingCarContainer.addRacingCar(CarNamePolicyDataSet.randomValidCarName())
                }

                // Expected
                racingCarContainer.isFullRacingCar() shouldBe false
                racingCarContainer.isNotFullRacingCar() shouldBe true
            }
        }
    }

    context(
        "When racingCarList is full, then isFullRacingCar() should be true " +
            "and isNotFullRacingCar() should be false"
    ) {
        val testTotalCarCount = 5

        table(
            headers("totalCarCount", "addCarCount"),
            row(testTotalCarCount, testTotalCarCount)
        ).forAll { totalCarCount, addCarCount ->
            test("totalCarCount: $totalCarCount, addCarCont: $addCarCount => isFull: true") {
                // Given
                val racingCarContainer = DefaultRacingCarContainer(totalCarCount)
                repeat(addCarCount) {
                    racingCarContainer.addRacingCar(CarNamePolicyDataSet.randomValidCarName())
                }

                // Expected
                racingCarContainer.isFullRacingCar() shouldBe true
                racingCarContainer.isNotFullRacingCar() shouldBe false
            }
        }
    }
})

private fun <T> Collection<Iterable<T>>.cartesianProduct(): List<List<T>> =
    if (isEmpty()) {
        emptyList()
    } else {
        drop(1)
            .fold(first().map(::listOf)) { acc, iterable ->
                acc.flatMap { list ->
                    iterable.map(list::plus)
                }
            }
    }

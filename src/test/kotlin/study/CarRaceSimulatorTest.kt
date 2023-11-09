package study

import carRace.CarRaceSimulator
import carRace.domain.Car
import carRace.domain.CarLapRunner
import carRace.domain.CarMovingStrategy
import carRace.domain.CarRaceResult
import carRace.domain.Cars
import carRace.view.ManualInputView
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeSorted
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldStartWith
import java.lang.IllegalArgumentException
import java.lang.RuntimeException

class CarRaceSimulatorTest : StringSpec({
    val drivers = listOf("aaa", "bbb", "ccc", "ddd", "eee")

    "car name max length is 5" {
        shouldThrow<IllegalArgumentException> {
            Car("long name", 0, AlwaysMovingStrategy)
        }.message shouldStartWith "Invalid driver name"
    }

    "car traveled increases by 1 each time car drive succeeds" {
        val originalPosition = 1
        val car = Car("anony", originalPosition, AlwaysMovingStrategy)

        val driveCount = 1

        repeat(driveCount) {
            car.drive()
        }

        val expectedDistance = originalPosition + driveCount
        val actualDistance = car.traveled

        expectedDistance shouldBe actualDistance
    }

    "carRaceSimulatorAlwaysMovingTest" {
        val iterationCount = 5
        val simulator = CarRaceSimulator(ManualInputView(drivers, iterationCount))
        val result = simulator.simulate(AlwaysMovingStrategy)

        result.cars.carList.forEach {
            it.traveled shouldBe iterationCount
        }
    }

    "cars always drive test" {
        val initialPosition = 0
        val cars = Cars(
            listOf(
                Car("a", initialPosition, AlwaysMovingStrategy)
            )
        )

        cars.driveCars()

        cars.carList[0].traveled shouldBe initialPosition + 1
    }

    "cars always not drive test" {
        val initialPosition = 0
        val cars = Cars(
            listOf(
                Car("a", initialPosition, AlwaysNotMovingStrategy)
            )
        )

        cars.driveCars()

        cars.carList[0].traveled shouldBe initialPosition
    }

    "car lap runner lap should be updated after runLaps" {
        val raceResult = CarRaceResult(
            Cars(
                listOf(
                    Car("win", 10, AlwaysNotMovingStrategy),
                    Car("lose", 0, AlwaysNotMovingStrategy)
                )
            )
        )

        val lapCount = 3
        val carLapRunner = CarLapRunner(raceResult, lapCount)

        carLapRunner.runLaps()

        carLapRunner.currentLap shouldBe lapCount
    }

    "car lap runner runLaps should be called only once" {
        shouldThrow<RuntimeException> {
            val raceResult = CarRaceResult(
                Cars(
                    listOf(
                        Car("win", 10, AlwaysNotMovingStrategy),
                        Car("lose", 0, AlwaysNotMovingStrategy)
                    )
                )
            )

            val lapCount = 3
            val carLapRunner = CarLapRunner(raceResult, lapCount)

            carLapRunner.runLaps()
            carLapRunner.runLaps()
        }.message shouldContain "runLaps should be called only once"
    }

    "carRaceSimulatorAlwaysNotMovingTest" {
        val iterationCount = 5
        val simulator = CarRaceSimulator(ManualInputView(drivers, iterationCount))
        val result = simulator.simulate(AlwaysNotMovingStrategy)

        result.cars.carList.forEach {
            it.traveled shouldBe 0
        }
    }

    "carRaceResultHistoryUpdateTest" {
        val iterationCount = 5
        val simulator = CarRaceSimulator(ManualInputView(drivers, iterationCount))
        val raceResult = simulator.simulate(AlwaysNotMovingStrategy)

        raceResult.history shouldHaveSize 5
        raceResult.updateHistory(iterationCount + 1)
        raceResult.history shouldHaveSize 6
    }

    "carRaceResultHistoryValueUpdateTest" {
        val iterationCount = 5
        val simulator = CarRaceSimulator(ManualInputView(drivers, iterationCount))
        val raceResult = simulator.simulate(AlwaysMovingStrategy)

        val sortedLapRecord = raceResult.history.map { carLapResult ->
            Pair(carLapResult.lap, carLapResult.cars.sumOf { it.traveled })
        }.sortedBy { it.first }.map { it.second }

        sortedLapRecord.shouldBeSorted()
    }

    "carRaceWinnerTest" {
        val raceResult = CarRaceResult(
            Cars(
                listOf(
                    Car("win", 10, AlwaysNotMovingStrategy),
                    Car("lose", 0, AlwaysNotMovingStrategy)
                )
            )
        )

        raceResult.updateHistory(1)
        val winners = raceResult.getWinners()

        winners shouldHaveSize 1
        winners[0].driverName shouldBe "win"
    }
})

object AlwaysMovingStrategy : CarMovingStrategy {
    override fun shouldMove(): Boolean = true
}

object AlwaysNotMovingStrategy : CarMovingStrategy {
    override fun shouldMove(): Boolean = false
}

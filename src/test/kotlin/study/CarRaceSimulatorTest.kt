package study

import carRace.Car
import carRace.CarMovingStrategy
import carRace.CarRaceResult
import carRace.CarRaceSimulator
import carRace.ManualInputView
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy
import java.lang.IllegalArgumentException

class CarRaceSimulatorTest : StringSpec({
    val drivers = listOf("aaa", "bbb", "ccc", "ddd", "eee")

    "carNameTest" {
        assertThatThrownBy {
            Car("long name", 0, AlwaysMovingStrategy)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid driver name")
    }

    "carDriveTest" {
        val originalPosition = 1
        val car = Car("anony", originalPosition, AlwaysMovingStrategy)

        val driveCount = 1

        repeat(driveCount) {
            car.drive()
        }

        val expectedDistance = originalPosition + driveCount
        val actualDistance = car.traveled

        expectedDistance.shouldBe(actualDistance)
    }

    "carRaceSimulatorAlwaysMovingTest" {
        val iterationCount = 5
        val simulator = CarRaceSimulator(ManualInputView(drivers, iterationCount))
        val result = simulator.simulate(AlwaysMovingStrategy)

        result.currentCars.forEach {
            it.traveled.shouldBe(iterationCount)
        }
    }

    "carRaceSimulatorAlwaysNotMovingTest" {
        val iterationCount = 5
        val simulator = CarRaceSimulator(ManualInputView(drivers, iterationCount))
        val result = simulator.simulate(AlwaysNotMovingStrategy)

        result.currentCars.forEach {
            it.traveled.shouldBe(0)
        }
    }

    "carRaceWinnerTest" {
        val raceResult = CarRaceResult(
            listOf(
                Car("win", 10, AlwaysNotMovingStrategy),
                Car("lose", 0, AlwaysNotMovingStrategy)
            )
        )

        raceResult.updateHistory(1)
        val winners = raceResult.getWinners()

        winners.shouldHaveSize(1)
        winners[0].driverName.shouldBe("win")
    }
})

object AlwaysMovingStrategy : CarMovingStrategy {
    override fun shouldMove(): Boolean = true
}

object AlwaysNotMovingStrategy : CarMovingStrategy {
    override fun shouldMove(): Boolean = false
}

package study

import CarRaceSimulator
import io.kotest.core.spec.style.StringSpec

class CarRaceSimulatorTest : StringSpec({
    "carRaceSimulatorTest" {
        CarRaceSimulator.simulate(CarRaceSimulator.CarListProvideMethod.Manual(3, 50))
    }
})

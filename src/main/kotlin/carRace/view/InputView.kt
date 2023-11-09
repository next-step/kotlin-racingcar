package carRace.view

import carRace.domain.CarsProvider
import carRace.domain.RaceIterationProvider

sealed class InputView(
    val carsProvider: CarsProvider,
    val iterationProvider: RaceIterationProvider
)

class ManualInputView(carNames: List<String>, iterationCount: Int) : InputView(
    CarsProvider.ManualCarsProvider(carNames),
    RaceIterationProvider.ManualRaceIterationProvider(iterationCount)
)

class UserInputView : InputView(UserInputCarsProvider, UserInputRaceIterationProvider)

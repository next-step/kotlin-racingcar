package carRace

sealed class InputView(
    val carsProvider: CarsProvider,
    val iterationProvider: RaceIterationProvider
)

class ManualInputView(carNames: List<String>, iterationCount: Int) : InputView(
    CarsProvider.Manual(carNames),
    RaceIterationProvider.Manual(iterationCount)
)

class UserInputView : InputView(CarsProvider.UserInput, RaceIterationProvider.UserInput)

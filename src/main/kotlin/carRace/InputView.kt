package carRace

sealed class InputView(val carsProvider: CarsProvider)

class ManualInputView(carNames: List<String>, iterationCount: Int) : InputView(
    CarsProvider.Manual(
        carNames,
        iterationCount
    )
)

class UserInputView : InputView(CarsProvider.UserInput)

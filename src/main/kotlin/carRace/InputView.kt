package carRace

sealed class InputView(val carsProvider: CarsProvider)

class ManualInputView(carCount: Int, iterationCount: Int) : InputView(
    CarsProvider.Manual(
        carCount,
        iterationCount
    )
)

class UserInputView : InputView(CarsProvider.UserInput)

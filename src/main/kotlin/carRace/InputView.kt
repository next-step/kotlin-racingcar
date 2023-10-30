package carRace

sealed class InputView(val raceRegulationProvider: RaceRegulationProvider)

class ManualInputView(carCount: Int, iterationCount: Int) : InputView(
    RaceRegulationProvider.Manual(
        carCount,
        iterationCount
    )
)

class UserInputView : InputView(RaceRegulationProvider.UserInput)

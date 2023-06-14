package racinggame.view

class MockRacingGameInputView(
    private val mockRacingGameInput: Result<RacingGameInput>
) : RacingGameInputView {

    override fun readRacingGameInput(): Result<RacingGameInput> {
        return mockRacingGameInput
    }
}

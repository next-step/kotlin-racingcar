package study.racing

class FakeCountProvider(
    private val count: String
) : CountProvider {
    override fun getCount(): String = count
}
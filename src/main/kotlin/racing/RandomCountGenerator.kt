package racing

class RandomCountGenerator : CountGenerator {
    override fun generate(): Int {
        return (0..9).random()
    }
}

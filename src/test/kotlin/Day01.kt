import org.junit.jupiter.api.Test
import util.readInput
import kotlin.math.abs
import kotlin.test.assertEquals

private fun extractLists(input: List<String>): Pair<MutableList<Int>, MutableList<Int>> {
    var leftList: MutableList<Int> = mutableListOf()
    var rightList = leftList

    input.map {
        val split = it.split(" ")
        leftList.add(split.first().toInt())
        rightList.add(split.last().toInt())
    }
    return leftList to rightList
}

private fun task1(input: List<String>): Int {
    val (leftList, rightList) = extractLists(input)

    leftList.sort()
    rightList.sort()

    return leftList.mapIndexed { index, left -> abs(left.minus((rightList[index]))) }.sum()
}

private fun task2(input: List<String>): Int {
    val (leftList, rightList) = extractLists(input)

    return leftList.sumOf { left ->
        left * rightList.count { right -> left == right}
    }
}

class Day01 {
    @Test
    fun testTask1ExampleInput() {
        val expected = 11
        val input = readInput("day01example")
        val answer = task1(input)

        assertEquals(expected, answer)
    }

    @Test
    fun testTask1Input() {
        val expected = 2756096
        val input = readInput("day01")
        val answer = task1(input)

        assertEquals(expected, answer)
    }

    @Test
    fun testTask2ExampleInput() {
        val expected = 31
        val input = readInput("day01example")
        val answer = task2(input)

        assertEquals(expected, answer)
    }

    @Test
    fun testTask2Input() {
        val expected = 23117829
        val input = readInput("day01")
        val answer = task2(input)

        assertEquals(expected, answer)
    }
}
package com.prmto.inviodocuments

import junit.framework.TestCase.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val dice = Dice(6)
        val rollResult = dice.roll()
        assertTrue("Dice roll result must be between 1 and 6", rollResult in 1..6)
        // The message paramater is the message that will be displayed in the console if this assertion fails.
    }
}
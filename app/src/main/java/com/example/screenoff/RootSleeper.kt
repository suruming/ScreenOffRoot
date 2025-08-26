package com.example.screenoff

import java.io.BufferedWriter
import java.io.OutputStreamWriter

object RootSleeper {

    private fun runSu(vararg cmds: String): Int {
        val p = Runtime.getRuntime().exec("su")
        BufferedWriter(OutputStreamWriter(p.outputStream)).use { w ->
            for (c in cmds) {
                w.write(c)
                w.newLine()
            }
            w.write("exit")
            w.newLine()
            w.flush()
        }
        return p.waitFor() // 0 == success
    }


    /** Try to sleep using KEYCODE_SLEEP (223), returns true if success */
    fun sleepPrefer223(): Boolean {
        return runSu("input keyevent 223") == 0
    }

    /** Fallback: toggle power key (26). If screen was ON, it will turn OFF. */
    fun togglePower(): Boolean {
        return runSu("input keyevent 26") == 0
    }
}
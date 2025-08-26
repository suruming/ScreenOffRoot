package com.example.screenoff

import android.service.quicksettings.TileService
import android.util.Log

class ScreenOffTileService : TileService() {

    override fun onClick() {
        super.onClick()
        try {
            val ok = RootSleeper.sleepPrefer223()
            if (!ok) {
                Log.w("ScreenOffTile", "KEYCODE_SLEEP failed, fallback to POWER key")
                RootSleeper.togglePower()
            }
        } catch (t: Throwable) {
            Log.e("ScreenOffTile", "sleep failed", t)
        }
    }
}
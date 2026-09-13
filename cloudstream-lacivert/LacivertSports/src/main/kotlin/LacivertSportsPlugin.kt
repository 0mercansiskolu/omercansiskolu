package com.lacivertsports

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class LacivertSportsPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(LacivertSportsProvider())
    }
}

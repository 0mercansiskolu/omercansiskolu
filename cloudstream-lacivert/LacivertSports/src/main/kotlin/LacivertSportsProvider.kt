package com.lacivertsports

import com.lagradost.cloudstream3.HomePageResponse
import com.lagradost.cloudstream3.LoadResponse
import com.lagradost.cloudstream3.MainAPI
import com.lagradost.cloudstream3.MainPageRequest
import com.lagradost.cloudstream3.TvType
import com.lagradost.cloudstream3.newHomePageResponse
import com.lagradost.cloudstream3.newLiveSearchResponse
import com.lagradost.cloudstream3.newLiveStreamLoadResponse

class LacivertSportsProvider : MainAPI() {
    override var mainUrl = "https://example.com"
    override var name = "Lacivert Sports"
    override var lang = "tr"

    override val hasMainPage = true
    override val supportedTypes = setOf(TvType.Live)

    override suspend fun getMainPage(
        page: Int,
        request: MainPageRequest
    ): HomePageResponse {
        val items = listOf(
            newLiveSearchResponse(
                name = "Kurulum tamamlandı",
                url = "setup",
                type = TvType.Live,
                fix = false
            )
        )

        return newHomePageResponse("Lacivert Sports", items)
    }

    override suspend fun load(url: String): LoadResponse {
        return newLiveStreamLoadResponse(
            name = "Kurulum tamamlandı",
            url = url,
            dataUrl = ""
        ) {
            plot = "Cloudstream eklenti iskeleti hazır. Bir sonraki adımda yalnızca kendi veya kullanma iznin bulunan yayın kaynaklarını ekleyebilirsin."
            comingSoon = true
        }
    }
}

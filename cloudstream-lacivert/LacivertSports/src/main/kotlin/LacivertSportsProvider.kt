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
    override var mainUrl = "https://monotv547.com"
    override var name = "Lacivert Sports"
    override var lang = "tr"

    override val hasMainPage = true
    override val supportedTypes = setOf(TvType.Live)

    private data class Channel(val id: String, val name: String)

    private val channels = listOf(
        Channel("ex1", "Tabii Spor 1"),
        Channel("ex7", "Tabii Spor 2"),
        Channel("ex3", "Tabii Spor 3"),
        Channel("ex4", "Tabii Spor 4"),
        Channel("ex6", "Tabii Spor 5"),
        Channel("zirve", "beIN Sports 1"),
        Channel("b2", "beIN Sports 2"),
        Channel("b3", "beIN Sports 3"),
        Channel("b4", "beIN Sports 4"),
        Channel("b5", "beIN Sports 5"),
        Channel("bm1", "beIN Max 1"),
        Channel("bm2", "beIN Max 2"),
        Channel("ss", "S Sport 1"),
        Channel("ss2", "S Sport 2"),
        Channel("t1", "Tivibu Spor 1"),
        Channel("t2", "Tivibu Spor 2"),
        Channel("t3", "Tivibu Spor 3"),
        Channel("eu1", "Eurosport 1"),
        Channel("trtspor2", "TRT SPOR YILDIZ"),
        Channel("as", "A SPOR"),
        Channel("trt1", "TRT 1"),
        Channel("atv", "A TV"),
        Channel("tv8", "TV 8"),
        Channel("tv85", "TV 8.5"),
        Channel("eu2", "Eurosport 2"),
        Channel("sm1", "Smart Spor 1"),
        Channel("sm2", "Smart Spor 2")
    )

    override suspend fun getMainPage(
        page: Int,
        request: MainPageRequest
    ): HomePageResponse {
        val items = channels.map { channel ->
            newLiveSearchResponse(
                name = channel.name,
                url = "$mainUrl/channel?id=${channel.id}",
                type = TvType.Live,
                fix = false
            )
        }

        return newHomePageResponse("Yayın Kanalları", items)
    }

    override suspend fun load(url: String): LoadResponse {
        val channel = channels.firstOrNull { url.endsWith("id=${it.id}") }
        val channelName = channel?.name ?: "Canlı Yayın"

        return newLiveStreamLoadResponse(
            name = channelName,
            url = url,
            dataUrl = url
        ) {
            plot = "Bu öğe, kaynak dosyadaki channel?id=... sayfa eşlemesini kullanır. Cloudstream içinde gerçek medya akışını oynatmak için yalnızca kendi veya kullanma iznin bulunan yayınlara ait doğrudan ve yetkili medya kaynağı eklenmelidir."
            comingSoon = true
        }
    }
}

package io.github.fate_grand_critomata.scripts

import io.github.fate_grand_critomata.SupportImageKind
import io.github.fate_grand_critomata.scripts.enums.GameServer
import io.github.fate_grand_critomata.scripts.enums.MaterialEnum
import io.github.lib_automata.Pattern

interface IImageLoader {
    operator fun get(img: Images, gameServer: GameServer? = null): Pattern

    fun loadSupportPattern(kind: SupportImageKind, name: String): List<Pattern>

    fun loadMaterial(material: MaterialEnum): Pattern

    fun clearImageCache()

    fun clearSupportCache()
}
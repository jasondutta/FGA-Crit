package io.github.fate_grand_critomata.scripts.prefs

import io.github.fate_grand_critomata.scripts.enums.BraveChainEnum
import io.github.fate_grand_critomata.scripts.enums.GameServer
import io.github.fate_grand_critomata.scripts.enums.MaterialEnum
import io.github.fate_grand_critomata.scripts.enums.ShuffleCardsEnum
import io.github.fate_grand_critomata.scripts.models.CardPriorityPerWave
import io.github.fate_grand_critomata.scripts.models.ServantPriorityPerWave
import io.github.fate_grand_critomata.scripts.models.ServantSpamConfig
import io.github.fate_grand_critomata.scripts.models.TeamSlot

interface IBattleConfig {
    val id: String
    var name: String
    var skillCommand: String
    var cardPriority: CardPriorityPerWave
    val useServantPriority: Boolean
    val servantPriority: ServantPriorityPerWave
    val rearrangeCards: List<Boolean>
    val braveChains: List<BraveChainEnum>
    val party: Int
    val materials: Set<MaterialEnum>
    val support: ISupportPreferences
    val shuffleCards: ShuffleCardsEnum
    val shuffleCardsWave: Int

    var spam: List<ServantSpamConfig>
    val autoChooseTarget: Boolean

    val server: GameServer?

    val addRaidTurnDelay: Boolean
    val raidTurnDelaySeconds : Int

    // Crit checker
    val cardGateEnabled: Boolean
    val cardGateServant: TeamSlot
    val cardGateMinimum: Int
    // end crit checker

    fun export(): Map<String, *>

    fun import(map: Map<String, *>)
}
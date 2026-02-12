package io.github.fate_grand_critomata.ui.card_priority

import androidx.compose.runtime.MutableState
import io.github.fate_grand_critomata.scripts.enums.BraveChainEnum
import io.github.fate_grand_critomata.scripts.models.CardScore
import io.github.fate_grand_critomata.scripts.models.TeamSlot

data class CardPriorityListItem(
    val scores: MutableList<CardScore>,
    val servantPriority: MutableList<TeamSlot>,
    var rearrangeCards: MutableState<Boolean>,
    var braveChains: MutableState<BraveChainEnum>
)
package io.github.fate_grand_critomata.ui.pref_support

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.fate_grand_critomata.prefs.core.BattleConfigCore
import javax.inject.Inject

@HiltViewModel
class PreferredSupportViewModel @Inject constructor(
    battleConfigCore: BattleConfigCore
): ViewModel() {
    val supportPrefs = battleConfigCore.support
}
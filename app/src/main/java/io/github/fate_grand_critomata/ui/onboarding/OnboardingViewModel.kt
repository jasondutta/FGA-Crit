package io.github.fate_grand_critomata.ui.onboarding

import android.os.PowerManager
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.fate_grand_critomata.prefs.core.PrefsCore
import io.github.fate_grand_critomata.scripts.prefs.IPreferences
import io.github.fate_grand_critomata.util.StorageProvider
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    val prefsCore: PrefsCore,
    val prefs: IPreferences,
    val storageProvider: StorageProvider,
    val powerManager: PowerManager
) : ViewModel() {
}
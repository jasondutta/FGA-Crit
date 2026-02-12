package io.github.fate_grand_critomata.util

import android.os.Build
import dagger.hilt.android.scopes.ServiceScoped
import io.github.fate_grand_critomata.di.service.ServiceCoroutineScope
import io.github.fate_grand_critomata.imaging.DroidCvPattern
import io.github.fate_grand_critomata.scripts.prefs.IPreferences
import io.github.fate_grand_critomata.ui.highlight.HighlightManager
import io.github.lib_automata.HighlightColor
import io.github.lib_automata.Pattern
import io.github.lib_automata.PlatformImpl
import io.github.lib_automata.PlatformPrefs
import io.github.lib_automata.Region
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration

@ServiceScoped
class AndroidImpl @Inject constructor(
    private val preferences: IPreferences,
    private val cutoutManager: CutoutManager,
    private val highlightManager: HighlightManager,
    @ServiceCoroutineScope private val scope: CoroutineScope
) : PlatformImpl {
    override val windowRegion get() = cutoutManager.getCutoutAppliedRegion()

    override val canLongSwipe =
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.O

    override val prefs: PlatformPrefs
        get() = preferences.platformPrefs

    override fun getResizableBlankPattern(): Pattern = DroidCvPattern()

    override fun highlight(region: Region, duration: Duration, color: HighlightColor) {
        scope.launch {
            try {
                highlightManager.add(region, color)
                delay(duration.inWholeMilliseconds)
            } finally {
                highlightManager.remove(region)
            }
        }
    }
}
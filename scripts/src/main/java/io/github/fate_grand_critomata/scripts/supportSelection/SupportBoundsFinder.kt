package io.github.fate_grand_critomata.scripts.supportSelection

import io.github.fate_grand_critomata.scripts.IFgoAutomataApi
import io.github.fate_grand_critomata.scripts.Images
import io.github.fate_grand_critomata.scripts.modules.Support
import io.github.lib_automata.Region
import io.github.lib_automata.dagger.ScriptScope
import javax.inject.Inject

@JvmInline
value class SupportBounds(val region: Region)

@ScriptScope
class SupportBoundsFinder @Inject constructor(
    api: IFgoAutomataApi
) : IFgoAutomataApi by api {
    fun all(): Sequence<SupportBounds> =
        locations.support.confirmSetupButtonRegion
            .findAll(
                images[Images.SupportConfirmSetupButton],
                Support.supportRegionToolSimilarity
            )
            .map {
                SupportBounds(
                    locations.support.defaultBounds
                        .copy(y = it.region.y - 70)
                )
            }.sortedBy {
                it.region
            }
}

package io.github.fate_grand_critomata.scripts.supportSelection
import io.github.fate_grand_critomata.scripts.IFgoAutomataApi
import io.github.fate_grand_critomata.scripts.Images
import io.github.lib_automata.Region
import io.github.lib_automata.dagger.ScriptScope
import javax.inject.Inject

@ScriptScope
class SupportSelectionGrandChecker @Inject constructor(
    api: IFgoAutomataApi
): IFgoAutomataApi by api {
    fun isGrandPresent(region: Region): Boolean {
        return region.exists(images[Images.GrandCeLabel])
    }
}

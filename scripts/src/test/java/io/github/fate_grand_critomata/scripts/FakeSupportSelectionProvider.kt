package io.github.fate_grand_critomata.scripts

import io.github.fate_grand_critomata.scripts.supportSelection.SupportSelectionProvider
import io.github.fate_grand_critomata.scripts.supportSelection.SupportSelectionResult

class FakeSupportSelectionProvider(
    private val func: (Int) -> SupportSelectionResult
) : SupportSelectionProvider {
    private var index = 0

    override fun select() =
        func(index++)
}
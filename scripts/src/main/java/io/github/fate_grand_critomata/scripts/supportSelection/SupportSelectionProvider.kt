package io.github.fate_grand_critomata.scripts.supportSelection

interface SupportSelectionProvider {
    fun select(): SupportSelectionResult
}
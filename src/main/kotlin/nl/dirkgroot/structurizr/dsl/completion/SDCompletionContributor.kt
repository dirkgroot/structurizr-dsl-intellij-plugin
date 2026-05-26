package nl.dirkgroot.structurizr.dsl.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.ProcessingContext
import nl.dirkgroot.structurizr.dsl.StructurizrDSLLanguage


class SDCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            psiElement().withLanguage(StructurizrDSLLanguage),
            SDKeywordCompletionProvider,
        )
    }
}

private object SDKeywordCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet,
    ) {
        val scope = SDContextDetector.detect(parameters.position)
        val keywords = SDKeywordRegistry.keywordsFor(scope)
        if (keywords.isEmpty()) return

        keywords.forEach { result.addElement(it.toLookupElement()) }
    }

    private fun SDKeywordInfo.toLookupElement() =
        LookupElementBuilder.create(text)
            .withTypeText(typeText)
            .withCaseSensitivity(false)
}

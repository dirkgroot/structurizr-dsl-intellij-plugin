package nl.dirkgroot.structurizr.dsl.psi.impl

import com.intellij.psi.util.childrenOfType
import nl.dirkgroot.structurizr.dsl.psi.*

class SDPsiImplUtil {
    companion object {
        @JvmStatic
        fun getElementName(element: SDElementWithName): String =
            element.childrenOfType<SDNameArgument>()
                .first()
                .text.trim('"')

        @JvmStatic
        fun getElementDescription(element: SDElementWithDescription): String? =
            element.childrenOfType<SDDescriptionArgument>()
                .firstOrNull()
                ?.text?.trim('"')

        @JvmStatic
        fun getElementTags(element: SDElementWithTags): Set<String> =
            element.childrenOfType<SDTagsArgument>().firstOrNull()
                ?.text
                ?.trim('"')
                ?.split(',')
                ?.map { it.trim() }
                ?.toSet()
                ?: emptySet()
    }
}

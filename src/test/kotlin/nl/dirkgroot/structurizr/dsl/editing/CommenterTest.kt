package nl.dirkgroot.structurizr.dsl.editing

import com.intellij.codeInsight.actions.MultiCaretCodeInsightAction
import com.intellij.codeInsight.generation.actions.CommentByBlockCommentAction
import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.Test

class CommenterTest : StructurizrDSLCodeInsightTest() {
    @Test
    fun `single line comment`() {
        checkCommentByLineComment(
            "<caret>softwareSystem name",
            "//softwareSystem name",
            CommentByLineCommentAction()
        )
    }

    @Test
    fun `block comment`() {
        checkCommentByLineComment(
            """
                <selection>softwareSystem name1
                softwareSystem name2</selection>
                softwareSystem name3
            """.trimIndent(),
            """
                /*softwareSystem name1
                softwareSystem name2*/
                softwareSystem name3
            """.trimIndent(),
            CommentByBlockCommentAction()
        )
    }

    private fun checkCommentByLineComment(
        initialState: String, expectedState: String,
        action: MultiCaretCodeInsightAction
    ) {
        fixture.configureByText("test.dsl", initialState)
        action.actionPerformedImpl(project, fixture.editor)
        fixture.checkResult(expectedState)
    }
}

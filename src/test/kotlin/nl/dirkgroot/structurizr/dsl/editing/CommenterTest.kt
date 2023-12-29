package nl.dirkgroot.structurizr.dsl.editing

import com.intellij.codeInsight.actions.MultiCaretCodeInsightAction
import com.intellij.codeInsight.generation.actions.CommentByBlockCommentAction
import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest

class CommenterTest : StructurizrDSLCodeInsightTest() {
    fun `test single line comment`() {
        checkCommentByLineComment(
            "<caret>softwareSystem name",
            "//softwareSystem name",
            CommentByLineCommentAction()
        )
    }

    fun `test block comment`() {
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
        myFixture.configureByText("test.dsl", initialState)
        action.actionPerformedImpl(project, myFixture.editor)
        myFixture.checkResult(expectedState)
    }
}

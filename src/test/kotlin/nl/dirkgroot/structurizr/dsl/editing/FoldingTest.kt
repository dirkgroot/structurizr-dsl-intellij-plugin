package nl.dirkgroot.structurizr.dsl.editing

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest

class FoldingTest : StructurizrDSLCodeInsightTest() {
    fun `test regular blocks`() {
        myFixture.testFolding(myFixture.testDataPath + "/folding/regular_blocks.dsl")
    }

    fun `test animation blocks`() {
        myFixture.testFolding(myFixture.testDataPath + "/folding/animation_blocks.dsl")
    }

    fun `test script blocks`() {
        myFixture.testFolding(myFixture.testDataPath + "/folding/script_blocks.dsl")
    }

    fun `test properties blocks`() {
        myFixture.testFolding(myFixture.testDataPath + "/folding/properties_blocks.dsl")
    }
}

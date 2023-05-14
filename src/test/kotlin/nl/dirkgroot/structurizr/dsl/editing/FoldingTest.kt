package nl.dirkgroot.structurizr.dsl.editing

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.Test

class FoldingTest : StructurizrDSLCodeInsightTest() {
    @Test
    fun `regular blocks`() {
        fixture.testFolding(fixture.testDataPath + "/folding/regular_blocks.dsl")
    }

    @Test
    fun `animation blocks`() {
        fixture.testFolding(fixture.testDataPath + "/folding/animation_blocks.dsl")
    }

    @Test
    fun `script blocks`() {
        fixture.testFolding(fixture.testDataPath + "/folding/script_blocks.dsl")
    }

    @Test
    fun `properties blocks`() {
        fixture.testFolding(fixture.testDataPath + "/folding/properties_blocks.dsl")
    }
}

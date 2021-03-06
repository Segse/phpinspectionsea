package com.kalessil.phpStorm.phpInspectionsEA.api;

import com.intellij.codeInsight.intention.IntentionAction;
import com.kalessil.phpStorm.phpInspectionsEA.PhpCodeInsightFixtureTestCase;
import com.kalessil.phpStorm.phpInspectionsEA.inspectors.apiUsage.arrays.InArrayMissUseInspector;

final public class InArrayMissUseInspectorTest extends PhpCodeInsightFixtureTestCase {
    public void testIfFindsAllPatterns() {
        final InArrayMissUseInspector inspector = new InArrayMissUseInspector();
        inspector.PREFER_YODA_STYLE             = true;
        inspector.PREFER_REGULAR_STYLE          = false;
        myFixture.enableInspections(inspector);
        myFixture.configureByFile("fixtures/api/array/in-array-misuse.php");
        myFixture.testHighlighting(true, false, true);

        for (final IntentionAction fix : myFixture.getAllQuickFixes()) {
            myFixture.launchAction(fix);
        }
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("fixtures/api/array/in-array-misuse.fixed.php");
    }
}
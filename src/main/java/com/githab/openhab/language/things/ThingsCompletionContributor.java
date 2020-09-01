package com.githab.openhab.language.things;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import com.githab.openhab.language.things.psi.ThingsTypes;

public class ThingsCompletionContributor extends CompletionContributor {
    public ThingsCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ThingsTypes.THING_KEYWORD_TYPE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("Thing"));
                        resultSet.addElement(LookupElementBuilder.create("Bridge"));
                    }
                }
        );
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ThingsTypes.BINDING_ID_KEYWORD_TYPE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("chromecast"));
                    }
                }
        );
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ThingsTypes.LBRACKET),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("["));
                    }
                }
        );
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ThingsTypes.RBRACKET),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("]"));
                    }
                }
        );
    }
}

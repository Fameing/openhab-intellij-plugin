package com.githab.openhab.ide.actions;

import com.githab.openhab.OpenhabBundle;
import com.githab.openhab.language.things.ThingsIcons;
import com.intellij.codeInsight.actions.ReformatCodeProcessor;
import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.util.ArrayUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Properties;

public class OpenhabTemplatesFactory implements FileTemplateGroupDescriptorFactory {

    @NonNls
    public static final String[] TEMPLATES = {
            OpenhabTemplates.OPENHAB_ITEMS,
            OpenhabTemplates.OPENHAB_PERSIST,
            OpenhabTemplates.OPENHAB_RULES,
            OpenhabTemplates.OPENHAB_SCRIPT,
            OpenhabTemplates.OPENHAB_SERVICES,
            OpenhabTemplates.OPENHAB_SITEMAPS,
            OpenhabTemplates.OPENHAB_THINGS
    };

    private final ArrayList<String> myCustomTemplates = new ArrayList<String>();

    private static class LatexTemplatesFactoryHolder {
        private static final OpenhabTemplatesFactory THINGS_TEMPLATES_FACTORY = new OpenhabTemplatesFactory();
    }

    public static OpenhabTemplatesFactory getInstance() {
        return LatexTemplatesFactoryHolder.THINGS_TEMPLATES_FACTORY;
    }

    @Override
    public FileTemplateGroupDescriptor getFileTemplatesDescriptor() {
        final FileTemplateGroupDescriptor group = new FileTemplateGroupDescriptor(OpenhabBundle.message("file.template.group.title"), ThingsIcons.FILE);
        final FileTypeManager fileTypeManager = FileTypeManager.getInstance();

        for (String template : TEMPLATES) {
            group.addTemplate(new FileTemplateDescriptor(template, fileTypeManager.getFileTypeByFileName(template).getIcon()));
        }

        // register custom templates
        for (String template : getInstance().getCustomTemplates()) {
            group.addTemplate(new FileTemplateDescriptor(template, fileTypeManager.getFileTypeByFileName(template).getIcon()));
        }
        return group;
    }

    public static PsiFile createFromTemplate(@NotNull final PsiDirectory directory, @NotNull final String name,
                                                 @NotNull String fileName, @NotNull String templateName, boolean allowReformatting,
                                                 @NonNls String... parameters) throws IncorrectOperationException {
        final FileTemplate template = FileTemplateManager.getInstance(directory.getProject()).getInternalTemplate(templateName);

        Project project = directory.getProject();

        Properties properties = new Properties(FileTemplateManager.getInstance(project).getDefaultProperties());
        for (int i = 0; i < parameters.length; i += 2) {
            properties.setProperty(parameters[i], parameters[i + 1]);
        }

        String text;
        try {
            text = template.getText(properties);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load template for " + FileTemplateManager.getInstance(project).internalTemplateToSubject(templateName), e);
        }

        final PsiFileFactory factory = PsiFileFactory.getInstance(project);
        PsiFile file = factory.createFileFromText(fileName, OpenhabTemplates.findLanguageFileType(templateName), text);

        file = (PsiFile) directory.add(file);
        if (file != null && allowReformatting && template.isReformatCode()) {
            new ReformatCodeProcessor(project, file, null, false).run();
        }

        return file;
    }

    public String[] getCustomTemplates() {
        return ArrayUtil.toStringArray(myCustomTemplates);
    }
}

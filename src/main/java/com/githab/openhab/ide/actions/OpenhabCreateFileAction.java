package com.githab.openhab.ide.actions;

import com.githab.openhab.ide.icons.OpenhabIcons;
import com.githab.openhab.OpenhabBundle;
import com.githab.openhab.language.items.ItemsFileType;
import com.githab.openhab.language.items.ItemsIcons;
import com.githab.openhab.language.persist.PersistFileType;
import com.githab.openhab.language.persist.PersistIcons;
import com.githab.openhab.language.rules.RulesFileType;
import com.githab.openhab.language.rules.RulesIcons;
import com.githab.openhab.language.scripts.ScriptsFileType;
import com.githab.openhab.language.scripts.ScriptsIcons;
import com.githab.openhab.language.services.ServicesFileType;
import com.githab.openhab.language.services.ServicesIcons;
import com.githab.openhab.language.sitemaps.SitemapsFileType;
import com.githab.openhab.language.sitemaps.SitemapsIcons;
import com.githab.openhab.language.things.ThingsFileType;
import com.githab.openhab.language.things.ThingsIcons;
import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.Nullable;

import static com.githab.openhab.ide.actions.OpenhabTemplatesFactory.createFromTemplate;

public class OpenhabCreateFileAction extends CreateFileFromTemplateAction implements DumbAware {

    public OpenhabCreateFileAction() {
        super(OpenhabBundle.message("action.create.file"), OpenhabBundle.message("action.create.file.description"), OpenhabIcons.FILE);
    }

    @Override
    protected String getDefaultTemplateProperty() {
        return OpenhabTemplates.OPENHAB_THINGS;
    }

    @Nullable
    @Override
    protected PsiFile createFile(String name, String templateName, PsiDirectory dir) {
        String filename = name;

        filename = buildFileName(name, templateName, filename);
        return createFromTemplate(dir, name, filename, templateName, true, "NAME", name);
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
        builder.setTitle(OpenhabBundle.message("action.create.file"))
                .addKind(OpenhabBundle.message("action.create.file.kind.items"), ItemsIcons.FILE, OpenhabTemplates.OPENHAB_ITEMS)
                .addKind(OpenhabBundle.message("action.create.file.kind.persist"), PersistIcons.FILE, OpenhabTemplates.OPENHAB_PERSIST)
                .addKind(OpenhabBundle.message("action.create.file.kind.rules"), RulesIcons.FILE, OpenhabTemplates.OPENHAB_RULES)
                .addKind(OpenhabBundle.message("action.create.file.kind.scripts"), ScriptsIcons.FILE, OpenhabTemplates.OPENHAB_SCRIPT)
                .addKind(OpenhabBundle.message("action.create.file.kind.services"), ServicesIcons.FILE, OpenhabTemplates.OPENHAB_SERVICES)
                .addKind(OpenhabBundle.message("action.create.file.kind.sitemaps"), SitemapsIcons.FILE, OpenhabTemplates.OPENHAB_SITEMAPS)
                .addKind(OpenhabBundle.message("action.create.file.kind.things"), ThingsIcons.FILE, OpenhabTemplates.OPENHAB_THINGS);
    }

    @Override
    protected String getActionName(PsiDirectory directory, String newName, String templateName) {
        return OpenhabBundle.message("action.create.file");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof OpenhabCreateFileAction;
    }

    private String buildFileName(String name, String templateName, String filename) {
        switch (templateName) {
            case OpenhabTemplates.OPENHAB_ITEMS:
                filename = name.endsWith("." + ItemsFileType.INSTANCE.getDefaultExtension()) ? name : name + "." + ItemsFileType.INSTANCE.getDefaultExtension();
                break;
            case OpenhabTemplates.OPENHAB_PERSIST:
                filename = name.endsWith("." + PersistFileType.INSTANCE.getDefaultExtension()) ? name : name + "." + PersistFileType.INSTANCE.getDefaultExtension();
                break;
            case OpenhabTemplates.OPENHAB_RULES:
                filename = name.endsWith("." + RulesFileType.INSTANCE.getDefaultExtension()) ? name : name + "." + RulesFileType.INSTANCE.getDefaultExtension();
                break;
            case OpenhabTemplates.OPENHAB_SCRIPT:
                filename = name.endsWith("." + ScriptsFileType.INSTANCE.getDefaultExtension()) ? name : name + "." + ScriptsFileType.INSTANCE.getDefaultExtension();
                break;
            case OpenhabTemplates.OPENHAB_SERVICES:
                filename = name.endsWith("." + ServicesFileType.INSTANCE.getDefaultExtension()) ? name : name + "." + ServicesFileType.INSTANCE.getDefaultExtension();
                break;
            case OpenhabTemplates.OPENHAB_SITEMAPS:
                filename = name.endsWith("." + SitemapsFileType.INSTANCE.getDefaultExtension()) ? name : name + "." + SitemapsFileType.INSTANCE.getDefaultExtension();
                break;
            case OpenhabTemplates.OPENHAB_THINGS:
                filename = name.endsWith("." + ThingsFileType.INSTANCE.getDefaultExtension()) ? name : name + "." + ThingsFileType.INSTANCE.getDefaultExtension();
                break;
        }
        return filename;
    }
}

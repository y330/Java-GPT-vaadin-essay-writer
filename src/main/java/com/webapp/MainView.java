package com.webapp;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Article;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Easy EssayAbstract - GPT3 for lazy peeps",
        shortName = "Easy EssayAbstract",
        description = "This is an example GPT3 used to make lives better.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public String prompt = "";
    public int numParagraphs = 3;
    // Essay result
    public String essay = "";


    public MainView(@Autowired EssayService service) {

        // Use TextField for standard text input
        TextArea textArea = new TextArea("Enter the start of your essay");
        textArea.setSizeFull();
        textArea.addThemeName("bordered");

        // create nuber selector for nuber of paragraphs using numberfield
        NumberField numberField = new NumberField("Number of paragraphs");
        numberField.setHasControls(true);
        numberField.setMin(1);
        numberField.setMax(10);
        numberField.setStep(1);
        numberField.setLabel("How many paragraphs do you want to generate?");


        Label label = new Label("🎊Congratulations, your essay is complete!😁");
        Dialog dialog = new Dialog(label);
        dialog.setCloseOnEsc(true);
        add(dialog);

        Button buttonclose = new Button("X", ev -> {
            dialog.close();
        });
        Article article = new Article(buttonclose);


        Header header = new Header(new Label("Essay AI by Yonah Aviv"));
        // Button click listeners can be defined as lambda expressions
        Button button = new Button("Start AI", e -> {
            GPTInteractionManager gpt = new GPTInteractionManager();
            prompt = textArea.getValue();
            numParagraphs = numberField.getValue().intValue();
            dialog.open();
            gpt.generateEssayWrapper(prompt, numParagraphs);
            article.setText(gpt.getResult());

        });

        dialog.add(article, buttonclose);

        // Theme variants give you predefined extra styles for components.
        // Example: Primary button has a more prominent look.
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        button.addClickShortcut(Key.ENTER);

        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");

        add(header, textArea, numberField, button);
    }


}

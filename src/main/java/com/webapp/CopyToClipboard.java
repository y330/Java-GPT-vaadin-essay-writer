// package com.webapp;

// /**
// * @author avivy
// * @date 11/29/2021
// * @filename CopyToClipboard.java
// **/

// import com.vaadin.flow.component.UI;
// import com.vaadin.flow.component.button.Button;
// import com.vaadin.flow.component.dependency.JsModule;
// import com.vaadin.flow.component.icon.VaadinIcon;
// import com.vaadin.flow.component.orderedlayout.VerticalLayout;
// import com.vaadin.flow.component.textfield.TextArea;
// import com.vaadin.flow.router.Route;

// @Route("copy-to-clipboard")
// @JsModule("../../../../../frontend/src/copytoclipboard.js")
// public class CopyToClipboard extends VerticalLayout {

// public CopyToClipboard() {
// TextArea textArea = new TextArea("Example text");
// textArea.setValue("This is some example text that you can copy to your
// clipboard.");

// Button button = new Button("Copy to clipboard", VaadinIcon.COPY.create());
// button.addClickListener(
// e -> UI.getCurrent().getPage().executeJs("window.copyToClipboard($0)",
// textArea.getValue())
// );
// add(textArea, button);
// }
// }

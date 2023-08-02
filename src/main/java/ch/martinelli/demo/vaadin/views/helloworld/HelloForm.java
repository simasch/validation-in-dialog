package ch.martinelli.demo.vaadin.views.helloworld;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationResult;

public class HelloForm extends FormLayout {

    public HelloForm(Hello hello) {
        var binder = new Binder<Hello>();

        var name = new TextField("Name");

        binder.forField(name)
                .withValidator((value, context) -> {
                    System.out.println("Validate: " + value);
                    return ValidationResult.ok();
                })
                .bind(Hello::getName, Hello::setName);

        add(name);

        binder.setBean(hello);
    }

}

package to.lova.flow.components.jelements;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.dom.Element;

/**
 * A mixin interface for component containers with slots.
 */
public interface HasSlots extends HasElement {

    static HasSlots from(HasElement component) {
        return component::getElement;
    }

    /**
     * Gets a slot by name.
     *
     * @param name
     *            the slot name
     * @return the slot
     */
    default HasComponents getSlot(String name) {
        return new HasComponents() {

            private static final String SLOT = "slot";

            @Override
            public void add(Component... components) {
                for (Component component : components) {
                    Element element = component.getElement();
                    element.setAttribute(SLOT, name);
                    component.addDetachListener(event -> {
                        element.removeAttribute(SLOT);
                        event.unregisterListener();
                    });
                    this.getElement().appendChild(element);
                }
            }

            @Override
            public void removeAll() {
                this.getElement().getChildren()
                        .filter(e -> name.equals(e.getAttribute(SLOT)))
                        .forEach(Element::removeFromParent);
            }

            @Override
            public Element getElement() {
                return HasSlots.this.getElement();
            }

        };
    }

}

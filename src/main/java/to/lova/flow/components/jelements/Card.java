package to.lova.flow.components.jelements;

import java.util.stream.Stream;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.server.AbstractStreamResource;

@Tag("j-card")
@HtmlImport("bower_components/j-elements/j-card.html")
public class Card extends Component
        implements HasComponents, HasSize, HasStyle {

    public Card(Component... components) {
        this.add(components);
    }

    public String getImage() {
        return this.getElement().getAttribute("image");
    }

    public void setImage(String image) {
        this.getElement().setAttribute("image", image);
    }

    public void setImage(AbstractStreamResource resource) {
        this.getElement().setAttribute("image", resource);
    }

    public double getImageAspect() {
        String value = this.getElement().getAttribute("image-aspect");
        return Double.valueOf(value);
    }

    public void setImageAspect(double aspect) {
        this.getElement().setAttribute("image-aspect", String.valueOf(aspect));
    }

    public void addToHeader(Component... components) {
        this.addToSlot("header", components);
    }

    public void addToFooter(Component... components) {
        this.addToSlot("footer", components);
    }

    public void addToTitle(Component... components) {
        this.addToSlot("title", components);
    }

    public void addToTitleSuffix(Component... components) {
        this.addToSlot("title-suffix", components);
    }

    private void addToSlot(String slot, Component... components) {
        Stream.of(components).map(Component::getElement)
                .forEach(e -> e.setAttribute("slot", slot));
        this.add(components);
    }

}

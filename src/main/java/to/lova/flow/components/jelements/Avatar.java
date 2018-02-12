package to.lova.flow.components.jelements;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.server.AbstractStreamResource;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("j-avatar")
@HtmlImport("bower_components/j-elements/j-avatar.html")
public class Avatar extends PolymerTemplate<Avatar.Model> {

    public interface Model extends TemplateModel {

        String getName();

        void setName(String name);

        String getAbbreviation();

        void setAbbreviation(String abbreviation);

    }

    public Avatar() {
    }

    public Avatar(String name) {
        this.setName(name);
    }

    public Avatar(String name, String image) {
        this(name);
        this.setImage(image);
    }

    public Avatar(String name, AbstractStreamResource resource) {
        this(name);
        this.setImage(resource);
    }

    public String getName() {
        return this.getModel().getName();
    }

    public void setName(String name) {
        this.getModel().setName(name);
    }

    public String getAbbreviation() {
        return this.getModel().getAbbreviation();
    }

    public void setAbbreviation(String abbreviation) {
        this.getModel().setAbbreviation(abbreviation);
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

}
